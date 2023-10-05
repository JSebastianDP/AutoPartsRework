/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
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
            case 1:
                if (request.getParameter("txtCorreo").equals("") || request.getParameter("txtPass").equals("")) {
                    request.getRequestDispatcher("DashBoardUsuario/index.jsp").forward(request, response);
                } else {
                    UsuarioVO usuVo = null;
                    UsuarioDAO usuDAo = new UsuarioDAO(usuVo);
                    usuVO = usuDAo.login(email, clave_usuario);
                    if (usuVO != null) {
                        String nombreUsuario = usuVO.getNombre_usuario(); // Reemplaza esto con la forma en que obtienes el nombre del usuario
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("UsuarioVO", usuVO);
                        sesion.setAttribute("email", email);
                        request.getRequestDispatcher("DashBoardUsuario/index.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                }
                break;

            case 2:
                nombre = "null";
                apellido = "null";
                tdoc = "null";
                documento = "null";
                telefono = "null";
                direccion = "null";

                UsuarioVO usuarioVO = new UsuarioVO(id_usuario, email, clave_usuario, estado_usuario, nombre, apellido, tdoc, documento, telefono, direccion, id_rol_fk);
                UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioVO);

                if (usuarioDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "Usuario registrado correctamente, ahora puede iniciar sesión con sus credenciales");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se registró correctamente");
                }
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
