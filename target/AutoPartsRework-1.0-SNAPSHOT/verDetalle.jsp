<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <title>Detalles de Venta</title>
    </head>
    <body>
        <div class="my-added-content">
            <h1>Detalles de Venta</h1>
            <table class="table table-striped datatable" id="miTabla">
                <thead>
                    <tr>
                        <th>id detalle</th>
                        <th>id venta</th>
                        <th>id producto</th>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio de Venta</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detalle" items="${detallesVenta}">
                        <tr>
                            <td>${detalle.id_detalle_venta}</td>
                            <td>${detalle.id_venta_fk}</td>
                            <td>${detalle.id_producto_fk}</td>
                            <td>${detalle.productoVO.nombre_producto}</td>
                            <td>${detalle.cantidad}</td>
                            <td>${detalle.precio}</td>
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
