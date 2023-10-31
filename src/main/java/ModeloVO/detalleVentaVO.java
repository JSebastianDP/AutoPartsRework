/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author Sebastian Diaz
 */
public class detalleVentaVO {
   int id_detalle_venta;
   int id_venta_fk;
   int id_producto_fk;
   int cantidad;
   double precio;
   ProductoVO productoVO;

    public detalleVentaVO() {
    }

    public detalleVentaVO(int id_detalle_venta, int id_venta_fk, int id_producto_fk, int cantidad, double precio, ProductoVO productoVO) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta_fk = id_venta_fk;
        this.id_producto_fk = id_producto_fk;
        this.cantidad = cantidad;
        this.precio = precio;
        this.productoVO = productoVO;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta_fk() {
        return id_venta_fk;
    }

    public void setId_venta_fk(int id_venta_fk) {
        this.id_venta_fk = id_venta_fk;
    }

    public int getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(int id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }
   
   
   
}
