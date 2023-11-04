/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author Sebastian Diaz
 */
public class CompraVO {
    String id_compra, fecha_compra,total_compra,estado_compra, id_proveedor_fk;
    int item;
    double precio;
    int cantidad;
    double subtotal;
    ProductoVO productoVO;
    ProveedorVO proveedorVO;
    String id_producto_fk;
    int id_compra_fk;
    String Nombre;
    

    public CompraVO() {
    }

    public CompraVO(String id_compra, String fecha_compra, String total_compra, String estado_compra, String id_proveedor_fk, int item, double precio, int cantidad, double subtotal, ProductoVO productoVO, ProveedorVO proveedorVO, String id_producto_fk, int id_compra_fk, String Nombre) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.total_compra = total_compra;
        this.estado_compra = estado_compra;
        this.id_proveedor_fk = id_proveedor_fk;
        this.item = item;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.productoVO = productoVO;
        this.proveedorVO = proveedorVO;
        this.id_producto_fk = id_producto_fk;
        this.id_compra_fk = id_compra_fk;
        this.Nombre = Nombre;
    }

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(String total_compra) {
        this.total_compra = total_compra;
    }

    public String getEstado_compra() {
        return estado_compra;
    }

    public void setEstado_compra(String estado_compra) {
        this.estado_compra = estado_compra;
    }

    public String getId_proveedor_fk() {
        return id_proveedor_fk;
    }

    public void setId_proveedor_fk(String id_proveedor_fk) {
        this.id_proveedor_fk = id_proveedor_fk;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public int getId_compra_fk() {
        return id_compra_fk;
    }

    public void setId_compra_fk(int id_compra_fk) {
        this.id_compra_fk = id_compra_fk;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

   
    
   
     
    
}
