/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
import ModeloVO.UsuarioVO;
import ModeloVO.VentaVO;
import ModeloVO.detalleVentaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

/**
 *
 * @author Sebastian Diaz
 */
public class VentaDAO extends ConexionBD {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();

    public VentaDAO() {
    }

    public List<VentaVO> Listar() {
        List<VentaVO> ventas = new ArrayList<>();
        String sql = "SELECT v.id_venta, v.fecha_venta, v.fecha_entrega, v.total_venta, v.descuento,v.id_usuario_fk, u.email , v.estado FROM venta v INNER JOIN usuario u ON v.id_usuario_fk = u.id_usuario";

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                VentaVO venVO = new VentaVO();
                venVO.setId_venta(mensajero.getString("id_venta"));
                venVO.setFecha_venta(mensajero.getString("fecha_venta"));
                venVO.setFecha_entrega(mensajero.getString("fecha_entrega"));
                venVO.setTotal_venta(mensajero.getString("total_venta"));
                venVO.setDescuento(mensajero.getString("descuento"));
                venVO.setId_usuario_fk(mensajero.getString("id_usuario_fk"));
                venVO.setEstado(mensajero.getString("estado"));

                // Crear un objeto UsuarioVO y obtener el correo del usuario
                UsuarioVO usuarioVO = new UsuarioVO();
                usuarioVO.setCorreo(mensajero.getString("email"));
                // Asignar el objeto UsuarioVO a VentaVO
                venVO.setUsuarioVO(usuarioVO);
                ventas.add(venVO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            if (mensajero != null) {
                try {
                    mensajero.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
            if (puente != null) {
                try {
                    puente.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
        }
        return ventas;
    }

    //Metodo para obtener el detalle de la venta
    public List<detalleVentaVO> ListarDetalle(int idVenta) {
        List<detalleVentaVO> detalles = new ArrayList<>();
        String sql = "SELECT dv.*, p.nombre_producto FROM detalleventa dv INNER JOIN producto p ON dv.id_producto_fk = p.id_producto WHERE dv.id_venta_fk = ?";

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idVenta); // Pasamos el ID de la venta como parámetro
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                detalleVentaVO detalle = new detalleVentaVO();
                detalle.setId_detalle_venta(mensajero.getInt("id_detalle_venta"));
                detalle.setId_venta_fk(mensajero.getInt("id_venta_fk"));
                detalle.setId_producto_fk(mensajero.getInt("id_producto_fk"));
                detalle.setCantidad(mensajero.getInt("cantidad"));
                detalle.setPrecio(mensajero.getDouble("precio_venta"));
                //Se crea un objeto de ProductoVO, del cual se obtiene el nombre del producto para asignarle el nombre del producto que venga de la consulta, luego se añade a la lista
                ProductoVO proVO = new ProductoVO();
                proVO.setNombre_producto(mensajero.getString("nombre_producto"));
                detalle.setProductoVO(proVO);
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            // Cierre de recursos
            if (mensajero != null) {
                try {
                    mensajero.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
            if (puente != null) {
                try {
                    puente.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de excepciones
                }
            }
        }
        return detalles;
    }

}
