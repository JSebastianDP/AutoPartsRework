<%@ include file="../Sesion/cache.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> 
        <link href="<%= request.getContextPath()%>/Css/estiloUsuario.css" rel="stylesheet" type="text/css" />
        <title>Home Cliente</title>
    </head>
    <body>
        <!-- Sidebar -->
        <div class="sidebar">
            <a href="#" class="logo">
                <i class='bx bx-code-alt'></i>
                <div class="logo-name"><span>Auto</span>Parts</div>
            </a>
            <ul class="side-menu">
                <li><a href="#"><i class='bx bx-store-alt'></i>Shop</a></li>
                <li><a href="#"><i class='bx bx-group'></i>Mis Compras</a></li>
                <li><a href="registrarDatosPersonales.jsp"><i class='bx bx-cog'></i>Settings</a></li>  
                <li><a href="<%= request.getContextPath()%>/Cliente/DatosPersonales.jsp"><i class='bx bx-id-card'></i>Datos Personales</a></li>

            </ul>
            <ul class="side-menu">
                <li>
                    <a href="<%= request.getContextPath()%>/ControladorUsuario?opcion=3" class="logout">
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
        </div>
        <script src="<%= request.getContextPath()%>/Js/index.js" type="text/javascript"></script>
    </body>
</html>
