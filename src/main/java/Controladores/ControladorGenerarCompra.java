/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import ModeloDAO.CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedorDAO;
import ModeloVO.GenerarCompraVO;
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
import util.Fecha;

/**
 *
 * @author Sebastian Diaz
 */
@WebServlet(name = "ControladorGenerarCompra", urlPatterns = {"/ControladorGenerarCompra"})
public class ControladorGenerarCompra extends HttpServlet {

 
        ProveedorVO pro = new ProveedorVO();
        ProveedorDAO pDAO = new ProveedorDAO();
        ProductoVO proVO = new ProductoVO();
        ProductoDAO proDAO = new ProductoDAO();
        GenerarCompraVO c = new GenerarCompraVO();
        CompraDAO cDAO = new CompraDAO();
        List<GenerarCompraVO> lista = new ArrayList<>();

        int item = 0;
        String codigo;
        String descripcion;
        Double precio;
        int cantidad;
        Double subtotal;
        Double totalpagar = 0.0;
        Fecha fechaSistem = new Fecha();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List compras = new ArrayList();
        compras = cDAO.Listar();
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("NuevaCompra")) {
            switch (accion) {
                case "BuscarProveedor":
                    String Id_proveedor = request.getParameter("codigoproveedor");
                    pro.setId_proveedor(Id_proveedor);
                    pro = pDAO.buscar(Id_proveedor);
                    request.setAttribute("pro", pro);

                case "BuscarProducto":
                    String Id_producto = request.getParameter("codigoproducto");
                    proVO.setId_producto(Id_producto);
                    proVO = proDAO.listarIdproducto(Id_producto);
                    request.setAttribute("p", pro);
                    request.setAttribute("producto", proVO);
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    request.setAttribute("p", pro);
                    totalpagar = 0.0;
                    item = item + 1;
                    codigo = proVO.getId_producto();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.parseDouble(request.getParameter("Precio"));
                    cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                    subtotal = precio * cantidad;
                    c = new GenerarCompraVO();
                    c.setItem(item);
                    c.setId_producto_fk(codigo);
                    c.setNombre(descripcion);
                    c.setPrecio(precio);
                    c.setCantidad(cantidad);
                    c.setSubtotal(subtotal);
                    lista.add(c);
                    for (int i = 0; i < lista.size(); i++) {
                        totalpagar = totalpagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", lista);

                    break;
                case "GenerarCompra":
                    c.setFecha_compra(fechaSistem.FechaBD());
                    c.setTotal_compra(totalpagar);
                    c.setEstado_compra("En Pedido");
                    c.setId_proveedor_fk(pro.getId_proveedor());
                    cDAO.GuardarCompra(c);
                    int idcompras = Integer.parseInt(cDAO.idCompra());
                    for (int i = 0; i < lista.size(); i++) {
                        c = new GenerarCompraVO();
                        c.setId_producto_fk(lista.get(i).getId_producto_fk());
                        c.setId_compra_fk(idcompras);
                        c.setCantidad(lista.get(i).getCantidad());
                        c.setPrecio(lista.get(i).getPrecio());
                        cDAO.GuardarDetalleCompra(c);

                    }
                    break;
                default:
                    request.setAttribute("compras", compras);
                    request.getRequestDispatcher("Gerente/agregarCompra.jsp").forward(request, response);
            }

            request.getRequestDispatcher("Gerente/agregarCompra.jsp").forward(request, response);
        }

        switch (accion) {
            case "NuevaCompra":
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
