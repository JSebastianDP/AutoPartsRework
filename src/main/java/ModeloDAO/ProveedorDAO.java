package ModeloDAO;

import ModeloVO.ProveedorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class ProveedorDAO extends ConexionBD {
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    
    public ProveedorDAO() {
    }

    public List<ProveedorVO> Listar() {
        List<ProveedorVO> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

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
        return proveedores;
    }
    
    
    public boolean Registrar(ProveedorVO proveedor) {
        boolean registrado = false;
        String sql = "INSERT INTO proveedor (nombre_proveedor, telefono_proveedor,correo_proveedor) VALUES (?,?,?)";
        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, proveedor.getNombre_proveedor());
            puente.setString(2, proveedor.getTelefono_proveedor());
            puente.setString(3, proveedor.getCorreo_proveedor());
            int resultado = puente.executeUpdate();
            
            registrado = (resultado > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (puente != null) {
                try {
                    puente.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return registrado;
    }
    
    
}
