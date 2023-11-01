/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import ModeloDAO.InventarioDAO;
import ModeloVO.InventarioVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Fecha;

/**
 *
 * @author Sebastian Diaz
 */
@WebServlet(name = "ControladorInventarios", urlPatterns = {"/ControladorInventarios"})
public class ControladorInventarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String informacionInventario = request.getParameter("textInformacion");
        String perdidasProductos = request.getParameter("textPerdida");
        String fechaInventario = request.getParameter("textFecha");
        String idProductoSeleccionado = request.getParameter("textProducto");
        UsuarioVO usuVO = new UsuarioVO();

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        InventarioVO invVO = new InventarioVO();
        InventarioDAO invDAO = new InventarioDAO();
        switch (opcion) {
            case 1:
                List<InventarioVO> inventario = invDAO.Listar();
                request.setAttribute("inventario", inventario);
                request.getRequestDispatcher("listarInventarios.jsp").forward(request, response);
                break;

            case 2:
                HttpSession sesion = request.getSession();
                String idUsuario  = (String) sesion.getAttribute("idUsuario");                
                Fecha fechaSystem = new Fecha();                
                invVO.setInformacion_inventario(informacionInventario);
                invVO.setPerdidas_productos(perdidasProductos);
                invVO.setId_producto_fk(idProductoSeleccionado);
                boolean registrado = invDAO.Registrar(invVO, idUsuario,  fechaSystem.Fecha());

                if (registrado) {
                    request.setAttribute("mensajeExito", "Inventario registrado con éxito.");
                } else {
                    request.setAttribute("mensajeError", "No se pudo registrar el inventario.");
                }
                // Redirigir a la vista para agregar más inventario
                request.getRequestDispatcher("Gerente/agregarInventario.jsp").forward(request, response);
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
