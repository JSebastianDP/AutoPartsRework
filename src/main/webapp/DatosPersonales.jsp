<%@include file = "./Cliente/DashBoardCliente.jsp" %>
<%@include file = "./Sesion/cache.jsp" %>
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
        <title>JSP Page</title>
    </head>
    <body>
        
         <!-- Agrega contenido debajo del navbar -->
        <div class="my-added-content">
            <form method="post" action="ControladorUsuario">
                <h2>Registra tus datos Personales</h2>
                <div class="form-group">
                    <label for="textNombre">Nombre:</label>
                    <input type="text" id="nombre" name="textNombre" placeholder="Ingrese su nombre" >
                </div>
                <div class="form-group">
                    <label for="textApellido">Apellido:</label>
                    <input type="text" id="apellido" name="textApellido" placeholder="Ingrese su apellido" >
                </div>
                <div class="form-group">
                    <label for="textTdoc">Tipo de Documento:</label>
                    <input type="text" id="textTdoc" name="textTdoc" placeholder="Ingrese su Tipo de documento" >
                </div>
                <div class="form-group">
                    <label for="Documento">Documento:</label>
                    <input type="number" id="Documento" name="textDocumento" placeholder="Ingrese su documento" >
                </div>
                <div class="form-group">
                    <label for="textTelefono">Telefono:</label>
                    <input type="number" id="textTelefono" name="textTelefono" placeholder="Ingrese su telefono" >
                </div>
                <div class="form-group">
                    <label for="documento">Direccion:</label>
                    <input type="text" id="documento" name="textDireccion" placeholder="Ingrese su direccion" >
                </div>
                <button type="submit" class="btn-submit" value="4" name="opcion">Actualizar datos Personales</button>
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
