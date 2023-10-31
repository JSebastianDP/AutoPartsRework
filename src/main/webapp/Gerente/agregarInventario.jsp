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
        <title>Registrar inventario</title>
    </head>
    <body>
        
         <!-- Agrega contenido debajo del navbar -->
        <div class="my-added-content">
            <form method="post" action="ControladorUsuario">
                <h2>Registra un inventario</h2>
                <div class="form-group">
                    <label for="textInformacion">Informacion del inventario:</label>
                    <input type="text" id="Informacion" name="textInformacion" placeholder="Ingrese la informacion del inventario" >
                </div>
                <div class="form-group">
                    <label for="textFecha">fecha del inventario:</label>
                    <input type="text" id="textFecha" name="textFecha" placeholder="Ingrese la fecha del inventario" >
                </div>
                <div class="form-group">
                    <label for="textPerdida">Perdida productos:</label>
                    <input type="text" id="textPerdida" name="textPerdida" placeholder="Por favor ingrese las perdidas de los productos" >
                </div>
                <div class="form-group">
                    <label for="textProducto">Id producto</label>
                    <input type="text" id="textProducto" name="textProducto" placeholder="Por favor ingrese el id del producto" >
                </div>
                <button type="submit" class="btn-submit" value="1" name="opcion">Registrar Inventario</button>
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