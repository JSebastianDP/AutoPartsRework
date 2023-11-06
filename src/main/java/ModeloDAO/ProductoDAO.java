/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import util.ConexionBD;

/**
 *
 * @author Sebastian Diaz
 */
public class ProductoDAO extends ConexionBD {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();

    public ProductoDAO() {
        conexion = new ConexionBD().obtenerConexion();

    }

 //Listar productos en general ( para carrito ) 
    public List Listar() {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        sql = "select * from producto";
        try {

            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO();
                proVO.setId(mensajero.getInt(1));
                proVO.setNombre_producto(mensajero.getString(2));
                proVO.setMarca_producto(mensajero.getString(3));
                proVO.setCantidad_producto(mensajero.getInt(4));
                proVO.setImagen(mensajero.getString(5));
//                proVO.setFoto(mensajero.getString(5));
                proVO.setPrecio_producto(mensajero.getDouble(6));
                proVO.setDescripcion_producto(mensajero.getString(7));
                proVO.setEstado(mensajero.getString(8));
                productos.add(proVO);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
    

// Listar para la imagen
    public void listarImg(int id, HttpServletResponse response) {
        sql = "select * from producto where id_producto=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                inputStream = mensajero.getBinaryStream("foto");

            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;

            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {
        }

    }
    //Metodo para listar producto por Id, tener en cuenta que este metodo tambien se esta utilizando para listar la imagen
    public ProductoVO buscar(String id_producto) {
    ProductoVO p = new ProductoVO();
    String sql = "SELECT * FROM producto WHERE id_producto= ?";
    try {
        conexion = this.obtenerConexion();
        puente = conexion.prepareStatement(sql);
        puente.setString(1, id_producto); // Asigna el valor del ID
        mensajero = puente.executeQuery();
        if (mensajero.next()) {
                p.setId_producto(mensajero.getString(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setMarca_producto(mensajero.getString(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//                p.setFoto(rs.getBinaryStream(5));
                p.setPrecio_producto(mensajero.getDouble(6));
                p.setDescripcion_producto(mensajero.getString(7));
                             
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo de excepciones o lanzar una excepción personalizada
    } 
    return p;
}   
    public ProductoVO listarIdproducto(String Id_producto) {
        ProductoVO p = new ProductoVO();
        String sql = "select * from producto where id_producto=" + Id_producto;
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                p.setId_producto(mensajero.getString(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setMarca_producto(mensajero.getString(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//                p.setFoto(rs.getBinaryStream(5));
                p.setPrecio_producto(mensajero.getDouble(6));
                p.setDescripcion_producto(mensajero.getString(7));
                             
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    

}
