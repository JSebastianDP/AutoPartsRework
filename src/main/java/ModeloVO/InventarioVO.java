/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;


/**
 *
 * @author Sebastian Diaz
 */
public class InventarioVO {
    
    String id_inventario;
    String informacion_inventario;
    String fecha_inventario;
    String perdidas_productos;
    String id_producto_fk;
    String id_usuario_fk;
    ProductoVO productoVO;

    public InventarioVO() {
    }

    public InventarioVO(String id_inventario, String informacion_inventario, String fecha_inventario, String perdidas_productos, String id_producto_fk, String id_usuario_fk, ProductoVO productoVO) {
        this.id_inventario = id_inventario;
        this.informacion_inventario = informacion_inventario;
        this.fecha_inventario = fecha_inventario;
        this.perdidas_productos = perdidas_productos;
        this.id_producto_fk = id_producto_fk;
        this.id_usuario_fk = id_usuario_fk;
        this.productoVO = productoVO;
    }

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getInformacion_inventario() {
        return informacion_inventario;
    }

    public void setInformacion_inventario(String informacion_inventario) {
        this.informacion_inventario = informacion_inventario;
    }

    public String getFecha_inventario() {
        return fecha_inventario;
    }

    public void setFecha_inventario(String fecha_inventario) {
        this.fecha_inventario = fecha_inventario;
    }

    public String getPerdidas_productos() {
        return perdidas_productos;
    }

    public void setPerdidas_productos(String perdidas_productos) {
        this.perdidas_productos = perdidas_productos;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public String getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(String id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    
    
    
    
}
