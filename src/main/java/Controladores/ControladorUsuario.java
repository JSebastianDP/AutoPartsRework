/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.jms.MessageEOFException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian Diaz
 */
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id_usuario = request.getParameter("id_usuario");
        String email = request.getParameter("txtCorreo");
        String clave_usuario = request.getParameter("txtPass");
        String estado_usuario = request.getParameter("textEstado");
        String nombre = request.getParameter("textNombre");
        String apellido = request.getParameter("textApellido");
        String tdoc = request.getParameter("textTdoc");
        String documento = request.getParameter("textDocumento");
        String telefono = request.getParameter("textTelefono");
        String direccion = request.getParameter("textDireccion");
        String id_rol_fk = request.getParameter(request.getParameter("textIdRol"));
        UsuarioVO usuVO = null;
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        switch (opcion) {
            case 1: // Iniciar Sesion
                if (email == null || email.isEmpty() || clave_usuario == null || clave_usuario.isEmpty()) {
                    request.setAttribute("mensajeError", "Por favor, ingrese correo y contraseña.");
                } else {
                    usuVO = usuDAO.login(email, clave_usuario); // Usar las variables definidas antes del switch
                    if (usuVO != null) {
                        String idUsuario = usuVO.getId_usuario();
                        usuVO = usuDAO.obtenerDatosUsuario(idUsuario); // Obtener más datos del usuario, incluido el nombre
                        nombre = usuVO.getNombre_usuario();
                        idUsuario = usuVO.getId_usuario();
                        apellido = usuVO.getApellido_usuario();
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("UsuarioVO", usuVO);
                        sesion.setAttribute("email", email);
                        sesion.setAttribute("nombreUsuario", nombre); // Establecer el nombre en la sesión
                        sesion.setAttribute("idUsuario", idUsuario);
                        System.out.println("El id del usuario es: " + idUsuario);
                        sesion.setAttribute("apellido", apellido); // Establecer el nombre en la sesión
                        request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    }
                    // Si llegamos aquí, significa que las credenciales son incorrectas
                    request.setAttribute("mensajeError", "Credenciales incorrectas. Por favor, inténtelo de nuevo.");
                }
                // Continuar con la redirección incluso en caso de error
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;

            case 2: //Registrar usuario
                if (nombre == null || nombre.isEmpty()) {
                    nombre = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }
                if (apellido == null || apellido.isEmpty()) {
                    apellido = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }
                if (tdoc == null || tdoc.isEmpty()) {
                    tdoc = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }
                if (documento == null || documento.isEmpty()) {
                    documento = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }
                if (telefono == null || telefono.isEmpty()) {
                    telefono = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }
                if (direccion == null || direccion.isEmpty()) {
                    direccion = "Desconocido"; // Cambia esto al valor predeterminado que desees
                }

                UsuarioVO usuarioVO = new UsuarioVO(id_usuario, email, clave_usuario, estado_usuario, nombre, apellido, tdoc, documento, telefono, direccion, id_rol_fk);
                UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioVO);

                if (usuarioDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "Usuario registrado correctamente, ahora puede iniciar sesión con sus credenciales");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se registró correctamente");
                }
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case 3: //Cerrar sesion
                HttpSession miSesion = request.getSession();
                miSesion.removeAttribute("UsuarioVO");
                miSesion.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case 4: // Actualizar datos personales
                HttpSession sesion = request.getSession();
                UsuarioVO usuarioSesion = (UsuarioVO) sesion.getAttribute("UsuarioVO"); // Obtener el objeto UsuarioVO de la sesión

                if (usuarioSesion != null) {
                    String idUsuario = usuarioSesion.getId_usuario(); // Obtener el ID de usuario de la sesión
                    if (idUsuario != null && !idUsuario.isEmpty()) {
                        if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty() || tdoc == null || tdoc.isEmpty()
                                || documento == null || documento.isEmpty() || direccion == null || direccion.isEmpty()) {
                            request.setAttribute("mensajeError", "Por favor, ingrese todos los datos para poder continuar.");
                        } else {
                            boolean exito = usuDAO.actualizarDatosPersonalesSesion(nombre, apellido, tdoc, documento, telefono, direccion, idUsuario);

                            if (exito) {
                                // Actualización exitosa
                                // Puedes agregar un mensaje de éxito y redirigir a la página deseada
                                request.setAttribute("mensajeExito", "Datos personales actualizados con éxito.");
                                request.getRequestDispatcher("DatosPersonales.jsp").forward(request, response);

                            } else {
                                request.setAttribute("mensajeError", "No se pudo actualizar los datos personales.");
                            }
                        }
                    } else {
                        // Manejar el caso en el que no se pudo obtener el idUsuario de la sesión
                        request.setAttribute("mensajeError", "No se pudo obtener el ID de usuario de la sesión.");
                    }
                } else {
                    // Manejar el caso en el que no se ha iniciado sesión
                    request.setAttribute("mensajeError", "No se ha iniciado sesión.");
                }
                // Redirigir a la página deseada
                request.getRequestDispatcher("DatosPersonales.jsp").forward(request, response);
                break;
            case 5: // Listar usuarios
                List<UsuarioVO> usuarios = usuDAO.Listar();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
