/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.InventarioVO;
import ModeloVO.ProductoVO;
import java.sql.Connection;
import java.sql.Date;
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
public class InventarioDAO extends ConexionBD {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;

    public InventarioDAO() {
    }

    public List<InventarioVO> Listar() {
        List<InventarioVO> inventario = new ArrayList<>();
        String sql = "Select i.id_inventario, p.nombre_producto, i.informacion_inventario, i.perdidas_productos,i.fecha_inventario, i.id_usuario_fk from inventario i inner join producto p where id_producto = id_producto_fk";

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                InventarioVO invVO = new InventarioVO();
                invVO.setId_inventario(mensajero.getString("id_inventario"));
                invVO.setInformacion_inventario(mensajero.getString("informacion_inventario"));
                invVO.setPerdidas_productos(mensajero.getString("perdidas_productos"));
                invVO.setFecha_inventario(mensajero.getString("fecha_inventario"));
                invVO.setId_usuario_fk(mensajero.getString("id_usuario_fk"));
                ProductoVO proVO = new ProductoVO();
                proVO.setNombre_producto(mensajero.getString("nombre_producto"));
                invVO.setProductoVO(proVO);
                inventario.add(invVO);                
                System.out.println("Los productos encontrados en el metodo toString son: " + invVO.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            // Cierre de recursos en el bloque finally
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
        return inventario;

    }
}
