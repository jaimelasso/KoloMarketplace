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
 * Clase para modelar la Entidad InfoCredito
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class InfoCredito implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad InfoCredito
     */
    @Id
    @Column (name = "num_tarjeta", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long numTarjeta;
    
    /**
     * Variable que almacena el nombre de InfoCredito
     */
    @Column (name = "nombre_franquicia")
    private String nombreFranquicia;

    /**
     * Variable que almacena la fecha de vencimiento
     */
    @Column (name = "fecha_vencimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    /**
     * Variable que almacena el codgo clave
     */
    @Column (name = "codigo_clave")
    private Long codigoClave;

    
    /**
     * Métodos GET Y SET
     * @return 
     */        
    
    public Long getNumTarjeta() {
        return numTarjeta;
    }

    public String getNombreFranquicia() {
        return nombreFranquicia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Long getCodigoClave() {
        return codigoClave;
    }

    public void setNumTarjeta(Long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setNombreFranquicia(String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCodigoClave(Long codigoClave) {
        this.codigoClave = codigoClave;
    }

}
