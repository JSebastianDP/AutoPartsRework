<%-- 
    Document   : login
    Created on : 1/10/2023, 6:09:37 p. m.
    Author     : Sebastian Diaz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link href="<%= request.getContextPath()%>/estilos/estiloLoginyRegistro.css" rel="stylesheet" type="text/css" />
        <title>Login</title> 
    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <form method="post" action="ControladorUsuario">
                    <h1>Crear cuenta</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>

                    </div>
                    <span>Usa tu correo para iniciar sesión</span>
                    <input type="email" placeholder="Email" name="txtCorreo">
                    <input type="password" placeholder="Password" name="txtPass">
                    <button value="2" name="opcion">Registrarse</button>
                </form>
            </div>
            <div class="form-container sign-in">
                <form method="post" action="ControladorUsuario">
                    <h1>Iniciar Sesión</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>Ingresa tu correo para iniciar sesión</span>
                    <input type="email" placeholder="Correo" name="txtCorreo">
                    <input type="password" placeholder="Conraseña" name="txtPass">
                    <a href="#">¿Olvidaste tu contraseña?</a>
                    <button type="hidden" value="1" name="opcion">Iniciar Sesión</button>
                </form>


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

            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>¡Bienvenido de vuelta!</h1>
                        <p>Ingresa tus datos personales para poder usar todas las funcionalidades del sitio.</p>
                        <button class="hidden" id="login">Iniciar sesión</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>¡Bienvenido!</h1>
                        <p>Regístrate con tus datos personales para poder usar todas las funcionalidades del sitio.</p>
                        <button class="hidden" id="register">Registrarse</button>
                    </div>
                </div>
            </div>
        </div>

        <%
            if (request.getAttribute("mensajeError") != null) {%>
        ${mensajeError}
        <%
        } else {%>
        ${mensajeExito}
        <%
            }
        %>
        <script src="estilos/jsLogin.js" type="text/javascript"></script>
    </body>

</html>