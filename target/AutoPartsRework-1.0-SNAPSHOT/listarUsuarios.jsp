<%@include file="./Gerente/DashBoardAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>
        <div class="my-added-content">
            <h1>Listar Usuarios</h1>
            <table class="table table-striped">
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
    </body>
</html>
