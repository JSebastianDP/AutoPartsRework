<%@include file = "./DashBoardAdmin.jsp" %>
<%@include file = "../Sesion/cache.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : DatosPersonalesConEstilo
    Created on : 13/10/2023, 9:36:03 p. m.
    Author     : Sebastian Diaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar proveedor</title>
    </head>
    <body>
        
         <!-- Agrega contenido debajo del navbar -->
        <div class="my-added-content">
            <form method="post" action="<%= request.getContextPath()%>/ControladorProveedores">
                <h2>Registra un nuevo proveedor</h2>
                <div class="form-group">
                    <label for="textNombre">Nombre del proveedor:</label>
                    <input type="text" id="nombre" name="txtNombre" placeholder="Ingrese el nombre del proveedor" >
                </div>
                <div class="form-group">
                    <label for="textTelefono">Telefono del proveedor:</label>
                    <input type="number" id="txtTelefono" name="txtTelefono" placeholder="Ingrese el telefono del proveedor" >
                </div>
                <div class="form-group">
                    <label for="textCorreo">Correo del proveedor:</label>
                    <input type="text" id="txtCorreo" name="txtCorreo" placeholder="Ingrese el correo del proveedor" >
                </div>
                <button type="submit" class="btn-submit" value="2" name="opcion">Registrar proveedor</button>
                <br>
                <center>
                <%
                    if (request.getAttribute("mensajeError") != null) {
                %>
                <div class="mensaje-error">
                    <%= request.getAttribute("mensajeError")%>
                </div>
                <%
                } else if (request.getAttribute("mensajeExito") != null) {
                %>
                <div class="mensaje-exito">
                    <%= request.getAttribute("mensajeExito")%>
                </div>
                <%
                    }
                %>
                </center>
            </form>
        </div>
        
    </body>
</html>
s