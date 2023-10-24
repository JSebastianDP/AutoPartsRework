<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <title>Listar Ventas</title>
    </head>
    <body>
        <div class="my-added-content">
            <table class="table table-striped datatable" id="miTabla">
                <h1>Listar Ventas</h1>
                <thead>
                    <tr>
                        <th>Venta ID</th>
                        <th>Fecha venta</th>
                        <th>Fecha entrega</th>
                        <th>Total venta</th>
                        <th>Descuento</th>
                        <th>Id usuario</th>
                        <th>Email</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="venta" items="${ventas}">
                        <tr>
                            <td>${venta.id_venta}</td>
                            <td>${venta.fecha_venta}</td>
                            <td>${venta.fecha_entrega}</td>
                            <td>${venta.total_venta}</td>
                            <td>${venta.descuento}</td>
                            <td>${venta.id_usuario_fk}</td>
                            <td>${venta.usuarioVO.correo}</td>
                            <td>${venta.estado}</td>
                            <td>
                                <a href="editarVenta.jsp?id=${venta.id_venta}" class="btn-edit">Editar</a>
                                <a href="eliminarVenta.jsp?id=${venta.id_venta}" class="btn-delete">Eliminar</a>
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
