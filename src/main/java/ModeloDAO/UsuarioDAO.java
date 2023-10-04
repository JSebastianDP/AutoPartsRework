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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;

/**
 *
 * @author Sebastian Diaz
 */
public class UsuarioDAO extends ConexionBD {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();
    int r = 0;
    
    String id_usuario="", email="", clave_usuario="", estado_usuario="", nombre="", apellido="", tdoc="",documento="", telefono="",direccion="",id_rol_fk="";

    public UsuarioDAO(UsuarioVO usuVO) {
         super();
        try {
            conexion = this.obtenerConexion();
            id_usuario = usuVO.getId_usuario();
            email = usuVO.getCorreo();
            clave_usuario = usuVO.getClave_usuario();
            estado_usuario = usuVO.getEstado_usuario();
            nombre = usuVO.getNombre_usuario();
            apellido = usuVO.getApelido_usuario();
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
                usuVO = new UsuarioVO(id_usuario, email, clave_usuario, estado_usuario, nombre, apellido, tdoc,documento, telefono,direccion,id_rol_fk="");
            }

        } catch (SQLException e) {
            System.out.println("Error en el login");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuVO;
    }

}
