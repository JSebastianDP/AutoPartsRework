<%@include file="/Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <title>Listar Compras</title>
</head>
<body>
<style>
    /* Estilos para los contenedores principales */
    .custom-container {
        margin: 10px;
        background-color: #f5f5f5; /* Color de fondo para los contenedores */
        padding: 20px; /* Espaciado interno para los contenedores */
        margin-left: 250px; /* Ancho del menú lateral */
    }

    /* Estilos para los campos de entrada y etiquetas */
    .custom-form-group {
        margin: 10px 0;
    }

    /* Estilos para los campos de entrada y botones en línea */
    .custom-d-flex {
        display: flex;
        align-items: center;
    }

    .custom-col-6 {
        width: 50%;
        margin-right: 10px;
    }

    /* Estilos para los botones */
    .custom-btn {
        padding: 8px 16px;
        background-color: #3498db;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    .custom-btn-outline-info {
        background-color: transparent;
        border: 2px solid #3498db;
        color: #3498db;
    }

    .custom-btn:hover,
    .custom-btn-outline-info:hover {
        background-color: #2980b9;
        border-color: #2980b9;
    }

    /* Estilos para la tabla */
    .custom-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px; /* Espacio entre la tabla y el contenido superior */
    }

    .custom-table th, .custom-table td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: left;
    }

    .custom-table th {
        background-color: #3498db;
        color: #fff;
    }

    .custom-table-hover tbody tr:hover {
        background-color: #f2f2f2;
    }

    /* Estilos para la disposición de los elementos */
    .custom-card-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
</style>

<div class="custom-container">
    <div class="custom-card">
        <form action="<%= request.getContextPath()%>/ControladorCompras" method="POST">
            <div class="custom-card-body">
                <div class="custom-form-group">
                    <label for="custom-codigoproveedor">Datos del Proveedor</label>
                </div>
                <div class="custom-form-group custom-d-flex">
                    <div class="custom-col-6 custom-d-flex">
                        <input type="text" name="txtIdProveedor" id="custom-codigoproveedor" value="${proveedor.id_proveedor}" class="custom-form-control"
                               placeholder="Código proveedor">
                        <button type="submit" name="opcion" value="2" class="custom-btn custom-btn-outline-info">
                            Buscar Proveedor
                        </button>
                    </div>
                    <div class="custom-col-6">
                        <input type="text" name="custom-nombreproveedor" value="${proveedor.nombre_proveedor}" id="custom-nombreproveedor" class="custom-form-control readonly"
                               placeholder="Nombre Proveedor" readonly>
                    </div>
                </div>

                <div class="custom-form-group">
                    <label for="custom-codigoproducto">Datos Producto</label>
                </div>

                <div class="custom-form-group custom-d-flex">
                    <div class="custom-col-6 custom-d-flex">
                        <input type="text" name="txtIdProducto" value="${producto.id_producto}" id="custom-codigoproducto" class="custom-form-control"
                               placeholder="Código producto">
                        <button type="submit" name="opcion" value="3" class="custom-btn custom-btn-outline-info">Buscar Producto</button>
                    </div>
                    <div class="custom-col-6">
                        <input type="text" name="custom-nombreproducto" value="${producto.nombre_producto}" id="custom-nombreproducto" class="custom-form-control"
                               placeholder="Nombre Producto" readonly>
                    </div>
                </div>
                <div class="custom-form-group custom-d-flex">
                    <div class="custom-col-6 custom-d-flex">
                        <input type="text" name="custom-Precio" id="custom-Precio" class="custom-form-control" placeholder="$0.00">
                    </div>
                    <div class="custom-col-6">
                        <input type="number" min="0" name="custom-Cantidad" id="custom-Cantidad" class="custom-form-control" value="1">
                    </div>
                </div>

                <!-- Botón para agregar al carrito -->
                <div class="custom-form-group">
                    <input type="button" value="Agregar al Carrito" class="custom-btn">
                </div>
            </div>
        </form>
    </div>
</div>

<div class="custom-container">
    <div class="custom-card">
        <div class="custom-card-body">
            <table class="custom-table custom-table-hover">
                <thead>
                <tr>
                    <th>Numero</th>
                    <th>Codigo</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                </tr>
                </thead>
                <tbody id="carrito-body">
                <!-- Aquí se agregarán las filas de productos en el carrito -->
                </tbody>
            </table>
        </div>
        <div class="custom-card-footer custom-d-flex">
            <div class="custom-col-4" style="display: flex; align-items: center;">
                <input type="submit" name="accion" value="Cancelar" class="custom-btn custom-btn-danger" style="margin-right: 10px;">
                <input type="text" name="custom-txtTotal" id="custom-txtTotal" class="custom-form-control" value="">
            </div>
            <div class="custom-col-8" style="text-align: right;">
                <!-- Asegúrate de que este enlace envíe el carrito al servlet -->
                <a href="<%= request.getContextPath()%>/ControladorCompras?menu=NuevaCompra&&accion=GenerarCompra" class="custom-btn custom-btn-success">
                    Generar Compra
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
