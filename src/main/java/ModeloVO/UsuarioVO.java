/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author Sebastian Diaz
 */
public class UsuarioVO {
    String id_usuario, correo, clave_usuario, estado_usuario, nombre_usuario, apelido_usuario, tipo_doc,documento, telefono,direccion,id_rol_fk;

    public UsuarioVO() {
    }

    public UsuarioVO(String id_usuario, String correo, String clave_usuario, String estado_usuario, String nombre_usuario, String apelido_usuario, String tipo_doc, String documento, String telefono, String direccion, String id_rol_fk) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apelido_usuario = apelido_usuario;
        this.tipo_doc = tipo_doc;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_rol_fk = id_rol_fk;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApelido_usuario() {
        return apelido_usuario;
    }

    public void setApelido_usuario(String apelido_usuario) {
        this.apelido_usuario = apelido_usuario;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId_rol_fk() {
        return id_rol_fk;
    }

    public void setId_rol_fk(String id_rol_fk) {
        this.id_rol_fk = id_rol_fk;
    }

    
    
}
