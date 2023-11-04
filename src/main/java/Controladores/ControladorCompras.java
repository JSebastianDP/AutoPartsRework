/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import ModeloDAO.CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedorDAO;
import ModeloVO.CompraVO;
import ModeloVO.ProductoVO;
import ModeloVO.ProveedorVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ControladorCompras", urlPatterns = {"/ControladorCompras"})
public class ControladorCompras extends HttpServlet {

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
        CompraVO comVO = new CompraVO();
        CompraDAO comDAO = new CompraDAO();

        ProveedorVO pro = new ProveedorVO();
        ProveedorDAO pDAO = new ProveedorDAO();

        ProductoDAO proDAO = new ProductoDAO();
        ProductoVO proVO = new ProductoVO();
        
        int item =0;
        Double totalpagar = 0.0;
        List<CompraVO> carrito = new ArrayList<>();

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        HttpSession session = request.getSession();

        switch (opcion) {
            case 1: //metodo para listar todas las compras
                List<CompraVO> compras = comDAO.Listar();
                request.setAttribute("compras", compras);
                request.getRequestDispatcher("listarCompras.jsp").forward(request, response);
                break;

            case 2: // Buscar el proveedor
                String Id_proveedor = request.getParameter("txtIdProveedor");
                pro.setId_proveedor(Id_proveedor);
                pro = pDAO.buscar(Id_proveedor);
                session.setAttribute("proveedor", pro); // Guarda el proveedor en la sesión
                request.getRequestDispatcher("Gerente/agregarCompra.jsp").forward(request, response);
                break;
            case 3: // Buscar el producto
                String id_producto = request.getParameter("txtIdProducto");
                System.out.println("ID del Producto: " + id_producto);
                proVO.setId_producto(id_producto);
                proVO = proDAO.buscar(id_producto);
                System.out.println("Producto encontrado: " + proVO.getNombre_producto());
                session.setAttribute("producto", proVO); // Guarda el producto en la sesión
                request.getRequestDispatcher("Gerente/agregarCompra.jsp").forward(request, response);
                break;      
                
            case 4: // Agregar producto al carrito
                String cantidadStr = request.getParameter("custom-Cantidad");
                double precio = Double.parseDouble(request.getParameter("custom-Precio"));
                int cantidad = Integer.parseInt(cantidadStr);
                // Realizar validaciones, por ejemplo, si la cantidad es mayor que 0
                if (cantidad <= 0) {
                    request.setAttribute("mensaje", "La cantidad debe ser mayor que 0");
                } else {
                    double subtotal = precio * cantidad;
                    comVO.setPrecio(precio);
                    comVO.setCantidad(cantidad);
                    comVO.setSubtotal(subtotal);
                    // Aquí puedes agregar el objeto comVO al carrito (por ejemplo, a un ArrayList en la sesión)
                }
                request.getRequestDispatcher("Gerente/agregarCompra.jsp").forward(request, response);
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
