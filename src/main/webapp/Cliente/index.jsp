<%@include file = "../Sesion/cache.jsp" %>
<%-- 
    Document   : index.jsp
    Created on : 23/09/2023, 06:31:57 PM
    Author     : Sebastian Diaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> 
        <link href="Css/estiloUsuario.css" rel="stylesheet" type="text/css"/>
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
                <li><a href="#"><i class='bx bx-cog'></i>Settings</a></li>                
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
        </div>
        <script src="Js/indexUsuario.js" type="text/javascript"></script>
    </body>
</html>
