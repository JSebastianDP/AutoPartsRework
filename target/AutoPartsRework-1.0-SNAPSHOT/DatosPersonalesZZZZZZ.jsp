<%@ include file="./Sesion/cache.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> 
    <link href="<%= request.getContextPath()%>/Css/estiloprueba.css" rel="stylesheet" type="text/css" />
    <style>
        <!--
        Tu CSS personalizado aquí
        -->
    </style>
    <title>Home</title>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <a href="#" class="logo">
            <i class='bx bx-code-alt'></i>
            <div class="logo-name"><span>Auto</span>Parts</div>
        </a>
        <ul class="side-menu">
            <li><a href="#"><i class='bx bxs-dashboard'></i>Dashboard</a></li>
            <li><a href="#"><i class='bx bx-store-alt'></i>Shop</a></li>
            <li><a href="#"><i class='bx bx-message-square-dots'></i>Tickets</a></li>
            <li><a href="#"><i class='bx bx-group'></i>Users</a></li>
            <li><a href="registrarDatosPersonales.jsp"><i class='bx bx-cog'></i>Settings</a></li>                
        </ul>
        <ul class="side-menu">
            <li>
                <a href="ControladorUsuario?opcion=3" class="logout">
                    <i class='bx bx-log-out-circle'></i>
                    Cerrar Sesión
                </a>
            </li>
        </ul>
    </div>
    <!-- End of Sidebar -->
    <!-- Main Content -->
    <div class="content">
        <!-- Navbar -->
        <nav>
            <i class='bx bx-menu'></i>
            <form action="#">
                <div class="form-input">
                    <input type="search" placeholder="Search...">
                    <button class="search-btn" type="submit"><i class='bx bx-search'></i></button>
                </div>
            </form>
            <input type="checkbox" id="theme-toggle" hidden>
            <label for="theme-toggle" class="theme-toggle"></label>
            <a href="#" class="notif">
                <i class='bx bx-bell'></i>
                <span class="count">12</span>
            </a>
            <a href="#" class="profile">
                <img src="images/logo.png">
                <span>${sessionScope.nombreUsuario} ${sessionScope.apellido}</span>
            </a>
        </nav>
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
    </div>
    <script src="<%= request.getContextPath()%>/Js/index.js" type="text/javascript"></script>
</body>
</html>


