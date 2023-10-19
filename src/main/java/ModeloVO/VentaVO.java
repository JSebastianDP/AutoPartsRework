package ModeloVO;

public class VentaVO {
    String id_venta, fecha_venta, fecha_entrega, total_venta, descuento, id_usuario_fk, estado;
    UsuarioVO usuarioVO; // Cambié el nombre de la variable para que coincida con la propiedad

    public VentaVO() {
    }

    public VentaVO(String id_venta, String fecha_venta, String fecha_entrega, String total_venta, String descuento, String id_usuario_fk, String estado, UsuarioVO usuarioVO) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.fecha_entrega = fecha_entrega;
        this.total_venta = total_venta;
        this.descuento = descuento;
        this.id_usuario_fk = id_usuario_fk;
        this.estado = estado;
        this.usuarioVO = usuarioVO;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(String total_venta) {
        this.total_venta = total_venta;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(String id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
}
