/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.CompraVO;
import ModeloVO.GenerarCompraVO;
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
public class CompraDAO extends ConexionBD {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    int r; 

    ConexionBD con = new ConexionBD();

    public CompraDAO() {
    }

    public List<CompraVO> Listar() {
        List<CompraVO> compras = new ArrayList<>();
        String sql = "Select c.id_compra, c.fecha_compra, c.total_compra, c.estado_compra, c.id_proveedor_fk, p.nombre_proveedor, p.correo_proveedor from compra c inner JOIN proveedor p where id_proveedor_fk = id_proveedor";

        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                CompraVO comVO = new CompraVO();
                comVO.setId_compra(mensajero.getString("id_compra"));
                comVO.setFecha_compra(mensajero.getString("fecha_compra"));
                comVO.setTotal_compra(mensajero.getString("total_compra"));
                comVO.setEstado_compra(mensajero.getString("estado_compra"));
                comVO.setId_proveedor_fk(mensajero.getString("id_proveedor_fk"));
                // Crear un objeto ProveedorVO y obtener los datos que se piden en la consulta sql
                ProveedorVO proVO = new ProveedorVO();
                // Asignar el objeto de ProveedorVO creado anteriormente  a ComprasVO
                proVO.setNombre_proveedor(mensajero.getString("nombre_proveedor"));
                proVO.setCorreo_proveedor(mensajero.getString("correo_proveedor"));
                comVO.setProveedorVO(proVO);
                compras.add(comVO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            // Cierre de recursos
        }
        return compras;
    }
    
    
    public int GuardarCompra(GenerarCompraVO c) {
        sql = "insert into compra (fecha_compra, total_compra,estado_compra, id_proveedor_fk) values(?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);

            puente.setString(1, c.getFecha_compra());
            puente.setDouble(2, c.getTotal_compra());
            puente.setString(3, c.getEstado_compra());
            puente.setString(4, c.getId_proveedor_fk());
            puente.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int GuardarDetalleCompra(GenerarCompraVO c) {
        sql = "insert into detallecompra(id_producto_fk, id_compra_fk, precio_compra,cantidad_compra) values(?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, c.getId_producto_fk());
            puente.setInt(2, c.getId_compra_fk());
            puente.setDouble(3, c.getPrecio());
            puente.setInt(4, c.getCantidad());
            puente.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    
    public String idCompra (){
    String id_compras ="";
    sql="Select max(id_compra) from compra";
        try {
            conexion = this.obtenerConexion();
            puente= conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                id_compras = mensajero.getString(1);
            }
            
        } catch (Exception e) {
        }
        return id_compras;
        
    }

}
