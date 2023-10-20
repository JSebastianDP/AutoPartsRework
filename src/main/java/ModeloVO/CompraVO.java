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
    
    ProveedorVO proveedorVO;

    public CompraVO() {
    }

    public CompraVO(String id_compra, String fecha_compra, String total_compra, String estado_compra, String id_proveedor_fk, ProveedorVO proveedorVO) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.total_compra = total_compra;
        this.estado_compra = estado_compra;
        this.id_proveedor_fk = id_proveedor_fk;
        this.proveedorVO = proveedorVO;
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

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

 
    
    
     
    
}
