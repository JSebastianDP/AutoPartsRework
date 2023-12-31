/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;
import util.Usuario;

/**
 *
 * @author Sebastian Diaz
 */
public class UsuarioDAO extends ConexionBD implements Usuario {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();
    int r = 0;
    int rol = 2;

    String id_usuario = "", email = "", clave_usuario = "", estado_usuario = "", nombre = "", apellido = "", tdoc = "", documento = "", telefono = "", direccion = "", id_rol_fk = "";

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_usuario = usuVO.getId_usuario();
            email = usuVO.getCorreo();
            clave_usuario = usuVO.getClave_usuario();
            estado_usuario = usuVO.getEstado_usuario();
            nombre = usuVO.getNombre_usuario();
            apellido = usuVO.getApellido_usuario();
            tdoc = usuVO.getTipo_doc();
            documento = usuVO.getDocumento();
            telefono = usuVO.getTelefono();
            direccion = usuVO.getDireccion();
            id_rol_fk = usuVO.getId_rol_fk();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public UsuarioVO login(String email, String clave_usuario) {
        UsuarioVO usuVO = null;

        sql = "Select * from usuario where email = ? AND clave_usuario = ?";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email);
            puente.setString(2, clave_usuario);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                String id_usuario = mensajero.getString("id_usuario");
                email = mensajero.getString("email");
                clave_usuario = mensajero.getString("clave_usuario");
                id_rol_fk = mensajero.getString("id_rol_fk");
                usuVO = new UsuarioVO(id_usuario, email, clave_usuario, estado_usuario, nombre, apellido, tdoc, documento, telefono, direccion, id_rol_fk = "");
            }

        } catch (SQLException e) {
            System.out.println("Error en el login");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuVO;
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO `usuario`(email, clave_usuario, nombre, apellido, tdoc, documento,telefono, direccion, id_rol_fk) VALUES (?,?,?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email);
            puente.setString(2, clave_usuario);
            puente.setString(3, nombre);
            puente.setString(4, apellido);
            puente.setString(5, tdoc);
            puente.setString(6, documento);
            puente.setString(7, telefono);
            puente.setString(8, direccion);
            puente.setInt(9, rol);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;

    }

    public UsuarioVO obtenerDatosUsuario(String idUsuario) {
        UsuarioVO usuVO = null;

        sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                String email = mensajero.getString("email");
                String clave_usuario = mensajero.getString("clave_usuario");
                String estado_usuario = mensajero.getString("estado_usuario");
                String nombre = mensajero.getString("nombre");
                String apellido = mensajero.getString("apellido");
                String tdoc = mensajero.getString("tdoc");
                String documento = mensajero.getString("documento");
                String telefono = mensajero.getString("telefono");
                String direccion = mensajero.getString("direccion");
                String id_rol_fk = mensajero.getString("id_rol_fk");

                // Crear un nuevo UsuarioVO con todos los datos obtenidos
                usuVO = new UsuarioVO(idUsuario, email, clave_usuario, estado_usuario, nombre, apellido, tdoc, documento, telefono, direccion, id_rol_fk);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del usuario");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuVO;
    }
//Metodo para actualizar los datos personales del usuario

    public boolean actualizarDatosPersonalesSesion(String nombre, String apellido, String tdoc, String documento, String telefono, String direccion, String idUsuario) {
        try {
            String sql = "UPDATE usuario SET nombre=?, apellido=?, tdoc=?, documento=?, telefono=?, direccion=? WHERE id_usuario=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, apellido);
            puente.setString(3, tdoc);
            puente.setString(4, documento);
            puente.setString(5, telefono);
            puente.setString(6, direccion);
            puente.setString(7, idUsuario);

            int filasAfectadas = puente.executeUpdate();

            if (filasAfectadas > 0) {
                return true; // Actualización exitosa
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos personales del usuario");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false; // No se pudo realizar la actualización
    }

    public List<UsuarioVO> Listar() {
        List<UsuarioVO> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";  // Selecciona todas las columnas

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO();
                usuVO.setId_usuario(mensajero.getString("id_usuario"));
                usuVO.setCorreo(mensajero.getString("email"));
                usuVO.setClave_usuario(mensajero.getString("clave_usuario"));
                usuVO.setEstado_usuario(mensajero.getString("estado_usuario"));
                usuVO.setNombre_usuario(mensajero.getString("nombre"));
                usuVO.setApellido_usuario(mensajero.getString("apellido"));
                usuVO.setTipo_doc(mensajero.getString("tdoc"));
                usuVO.setDocumento(mensajero.getString("documento"));
                usuVO.setTelefono(mensajero.getString("telefono"));
                usuVO.setDireccion(mensajero.getString("direccion"));
                usuVO.setId_rol_fk(mensajero.getString("id_rol_fk"));
                usuarios.add(usuVO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            try {
                if (mensajero != null) {
                    mensajero.close();  // Cierre del ResultSet
                }
                if (puente != null) {
                    puente.close();     // Cierre del PreparedStatement
                }
                if (conexion != null) {
                    conexion.close();    // Cierre de la conexión a la base de datos
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de excepciones en el cierre de recursos
            }
        }
        return usuarios;
    }

}
