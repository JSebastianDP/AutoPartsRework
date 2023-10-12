<%@include file = "./Sesion/cache.jsp" %>
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
    <link href="<%= request.getContextPath()%>/Css/estiloprueba.css" rel="stylesheet" type="text/css" />
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
    <form>
    <h2>Registra tus datos Personales</h2>
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
        </div>

        <div class="form-group">
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="tel" id="telefono" name="telefono" required>
        </div>

        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" required>
        </div>

        <div class="form-group">
            <label for="documento">Documento:</label>
            <input type="text" id="documento" name="documento" required>
        </div>

        <button type="submit" class="btn-submit">Actualizar datos Personales</button>
    </form>
</div>  

</div>

<script src="<%= request.getContextPath()%>/Js/index.js" type="text/javascript"></script>
</body>
</html>
