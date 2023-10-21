<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <title>Listar Compras</title>
</head>
<body>
<div class="my-added-content">
    <table class="table table-striped datatable" id="miTabla">
        <h1>Listar Compras</h1>
        <thead>
        <tr>
            <th>Compra ID</th>
            <th>Fecha compra</th>
            <th>Total compra</th>
            <th>Estado compra</th>
            <th>id proveedor</th>
            <th>Nombre proveedor</th>
            <th>Correo proveedor</th>
            <th>Estado proveedor</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="compra" items="${compras}">
                <tr>
                    <td>${compra.id_compra}</td>
                    <td>${compra.fecha_compra}</td>
                    <td>${compra.total_compra}</td>
                    <td>${compra.estado_compra}</td>
                    <td>${compra.id_proveedor_fk}</td>
                    <td>${compra.proveedorVO.nombre_proveedor}</td>
                    <td>${compra.proveedorVO.correo_proveedor}</td>
                    <td>${compra.estado_compra}</td>
                    <td>
                        <a href="editarCompra.jsp?id=${compra.id_compra}" class="btn-edit">Editar</a>
                        <a href="eliminarCompra.jsp?id=${compra.id_compra}" class="btn-delete">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#miTabla').DataTable();
    });
</script>
</body>
</html>
