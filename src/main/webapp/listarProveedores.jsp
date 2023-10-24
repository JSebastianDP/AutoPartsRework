<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <title>Listar Proveedores</title>
    </head>
    <body>
        <div class="my-added-content">
            <table class="table table-striped datatable" id="miTabla">
                <h1>Listar Proveedores</h1>
                <a href="agregarProveedor.jsp" class="btn-add">Agregar Proveedor</a>
                <thead>
                    <tr>
                        <th>Proveedor ID</th>
                        <th>Nombre proveedor</th>
                        <th>telefono proveedor</th>
                        <th>correo proveedor</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="proveedor" items="${proveedores}">
                        <tr>
                            <td>${proveedor.id_proveedor}</td>
                            <td>${proveedor.nombre_proveedor}</td>
                            <td>${proveedor.telefono_proveedor}</td>
                            <td>${proveedor.correo_proveedor}</td>
                            <td>
                                <a href="editarProveedor.jsp?id=${proveedor.id_proveedor}" class="btn-edit">Editar</a>
                                <a href="eliminarProveedor.jsp?id=${proveedor.id_proveedor}" class="btn-delete">Eliminar</a>
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
