<%@include file = "./DashBoardAdmin.jsp" %>

<%-- 
    Document   : home
    Created on : 11/10/2023, 8:35:12 p. m.
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
        
         <div class="my-added-content">
             <h1>Bienvenido</h1>
             <p>Usuario: ${sessionScope.nombreUsuario} ${sessionScope.apellido}</p>
        </div>
        
    </body>
</html>
