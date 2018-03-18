/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase para modelar la Entidad Tipo de Pago
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class TipoPagoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad TipoPago
     */
    @Id
    @Column (name = "id_tipoPago", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idTipoPago;
    
    /**
     * Variable que almacena el nombre de TipoPago
     */
    @Column (name = "nombre_tipoPago")
    private String nombreTipoPago;

    /**
     * Métodos GET Y SET
     * @return 
     */

    public Long getIdTipoPago() {
        return idTipoPago;
    }

    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    public void setIdTipoPago(Long idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }
    
}
