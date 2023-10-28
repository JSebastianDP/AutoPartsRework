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
}
