<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <title>Listar inventarios</title>
    </head>
    <body>
        <div class="my-added-content">
            <table class="table table-striped datatable" id="miTabla">
                <h1>Listar inventarios</h1>
                <a href="Gerente/agregarInventario.jsp" class="btn-add">Agregar inventario</a>
                <thead>
                    <tr>
                        <th>Inventario ID</th>
                        <th>Informacion inventario</th>
                        <th>Nombre producto</th>
                        <th>Perdidas Productos</th>
                        <th>fecha inventario</th>
                        <th>Id usuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="inventario" items="${inventario}">
                        <tr>
                            <td>${inventario.id_inventario}</td>
                            <td>${inventario.informacion_inventario}</td>
                            <td>${inventario.productoVO.nombre_producto}</td>
                            <td>${inventario.perdidas_productos}</td>
                            <td>${inventario.fecha_inventario}</td>
                            <td>${inventario.id_usuario_fk}</td>
                            <td>
                                <a href="editarProveedor.jsp?id=${inventario.id_inventario}" class="btn-edit">Editar</a>
                                <a href="eliminarProveedor.jsp?id=${inventario.id_inventario}" class="btn-delete">Eliminar</a>
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
