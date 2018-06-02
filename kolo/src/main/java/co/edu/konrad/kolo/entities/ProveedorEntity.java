/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Clase para modelar la Entidad Proveedor
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class ProveedorEntity implements Serializable {
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad Proveedor
     */
    @Id
    @Column (name = "id_proveedor")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idProveedor;
    
    /**
     * Variable que almacena el nit del proveedor
     */
    @Column (name = "nit_proveedor")
    private Long nitProveedor;
    
    /**
     * Variable que almacena el nombre del proveedor
     */
    @Column (name = "nombre_proveedor")
    private String nombreProveedor;
    
    /**
     * Variable que almacena el usuario del proveedor
     */
    @Column (name = "usuario_proveedor")
    private String usuarioProveedor;    

    /**
     * Variable que almacena el password del proveedor
     */
    @Column (name = "password_proveedor")
    private String passwordProveedor;    

    /**
     * Variable que almacena la URL del avatar del proveedor
     */
    @Column (name = "urlAvatar_proveedor")
    private String urlAvatarProveedor;    

    /**
     * Variable que almacena las ventas anuales del proveedor
     */
    @Column (name = "ventas_anuales")
    private Long ventasAnuales;

    /**
     * Variable que almacena el mercado objetivo del proveedor
     */
    @Column (name = "mercado_objetivo")
    private String mercadoObjetivo;

    /**
     * Variable que almacena el nivel de reputación del proveedor
     */
    @Column (name = "nivel_reputacion")
    private Long nivelReputacion;

    /**
     * Variable que almacena el número de teléfono del proveedor
     */
    @Column (name = "num_telefono")
    private Long numTelefono;

    /**
     * Variable que almacena la URL del chat del proveedor
     */
    @Column (name = "url_chat")
    private String urlChat;

    /**
     * Variable que almacena la dirección del proveedor
     */
    @Column (name = "direccion_proveedor")
    private String direccionProveedor;
    
    /**
     * Variable que almacena la fecha de creación del proveedor
     */
    @Column (name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
  
    /**
     * Métodos GET Y SET
     * @return 
     */

    public Long getIdProveedor() {
        return idProveedor;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getUsuarioProveedor() {
        return usuarioProveedor;
    }

    public String getPasswordProveedor() {
        return passwordProveedor;
    }

    public String getUrlAvatarProveedor() {
        return urlAvatarProveedor;
    }

    public Long getVentasAnuales() {
        return ventasAnuales;
    }

    public String getMercadoObjetivo() {
        return mercadoObjetivo;
    }

    public Long getNivelReputacion() {
        return nivelReputacion;
    }

    public Long getNumTelefono() {
        return numTelefono;
    }

    public String getUrlChat() {
        return urlChat;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setUsuarioProveedor(String usuarioProveedor) {
        this.usuarioProveedor = usuarioProveedor;
    }

    public void setPasswordProveedor(String passwordProveedor) {
        this.passwordProveedor = passwordProveedor;
    }

    public void setUrlAvatarProveedor(String urlAvatarProveedor) {
        this.urlAvatarProveedor = urlAvatarProveedor;
    }

    public void setVentasAnuales(Long ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }

    public void setMercadoObjetivo(String mercadoObjetivo) {
        this.mercadoObjetivo = mercadoObjetivo;
    }

    public void setNivelReputacion(Long nivelReputacion) {
        this.nivelReputacion = nivelReputacion;
    }

    public void setNumTelefono(Long numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setUrlChat(String urlChat) {
        this.urlChat = urlChat;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    
    
}
