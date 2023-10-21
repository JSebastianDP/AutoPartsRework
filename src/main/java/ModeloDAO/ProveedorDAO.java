/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.ProveedorVO;
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
public class ProveedorDAO extends ConexionBD{
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();

    public ProveedorDAO() {
    }

    public List<ProveedorVO> Listar() {
        List<ProveedorVO> proveedores = new ArrayList<>();
        String sql = "select * from proveedor";

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                ProveedorVO proVO = new ProveedorVO();
                proVO.setId_proveedor(mensajero.getString("id_proveedor"));
                proVO.setNombre_proveedor(mensajero.getString("nombre_proveedor"));
                proVO.setTelefono_proveedor(mensajero.getString("telefono_proveedor"));
                proVO.setCorreo_proveedor(mensajero.getString("correo_proveedor"));
                proveedores.add(proVO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            // Cierre de recursos
        }
        return proveedores;
    }
    
   
}
