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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * Clase para modelar la Entidad Cliente
 * @author Jaime Lasso
 */
@Entity
public class ClienteEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    @Id
    @Column (name = "id_cliente", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCliente;
    
    @Column (name = "nombre_cliente")
    private String nombreCliente;    

    @Column (name = "apellido_cliente")
    private String apellidoCliente;
    
    @OneToMany
    @JoinColumn (name = "idTipoDocumento")
    private TipoDocumentoEntity tipoDocumento;    
    
    @Column (name = "num_documento")
    private Long numDocumento;    
    
    @Column (name = "fecha_nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;        

    @Column (name = "direccion_cliente")
    private String direccionCliente;        

    @OneToMany
    @JoinColumn (name = "id_ciudad")
    private CiudadEntity ciudad;    

    @OneToMany
    @JoinColumn (name = "id_pais")
    private PaisEntity pais;

    @Column (name = "telefono_cliente")
    private Long telefonoCliente;
    
    @Column (name = "email_cliente")
    private String emailCliente;     
    
    @Column (name = "usuario_cliente")
    private String usuarioCliente;         
    
    @Column (name = "password_cliente")
    private String passwordCliente;    
    
    @Column (name = "URL_avatar")
    private String urlAvatar;    

    @Column (name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion; 
    
     /**
     * Métodos GET Y SET
     * @return 
     */

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public TipoDocumentoEntity getTipoDocumentoEntity() {
        return tipoDocumento;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public CiudadEntity getCiudadEntity() {
        return ciudad;
    }

    public PaisEntity getPaisEntity() {
        return pais;
    }

    public Long getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setIdCiudad(CiudadEntity idCiudad) {
        this.ciudad = idCiudad;
    }

    public void setIdPais(PaisEntity idPais) {
        this.pais = idPais;
    }

    public void setTelefonoCliente(Long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
            
    
    
}
