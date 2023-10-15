<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <title>Listar Usuarios</title>
    </head>
    <body>
        <div class="my-added-content">
            <table class="table table-striped datatable" id="miTabla">
                <h1>Listar Usuarios</h1>
                <thead>
                    <tr>
                        <th>Usuario ID</th>
                        <th>Correo</th>
                        <th>Clave Usuario</th>
                        <th>Estado Usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Tipo de Documento</th>
                        <th>Documento</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>ID Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.id_usuario}</td>
                            <td>${usuario.correo}</td>
                            <td>${usuario.clave_usuario}</td>
                            <td>${usuario.estado_usuario}</td>
                            <td>${usuario.nombre_usuario}</td>
                            <td>${usuario.apellido_usuario}</td>
                            <td>${usuario.tipo_doc}</td>
                            <td>${usuario.documento}</td>
                            <td>${usuario.telefono}</td>
                            <td>${usuario.direccion}</td>
                            <td>${usuario.id_rol_fk}</td>
                            <td>
                                <a href="editarUsuario.jsp?id=${usuario.id_usuario}" class="btn-edit">Editar</a>
                                <a href="eliminarUsuario.jsp?id=${usuario.id_usuario}" class="btn-delete">Eliminar</a>
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
