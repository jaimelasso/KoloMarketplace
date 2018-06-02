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
 * Clase para modelar la Entidad Tipo de documento
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class TipoDocumentoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;

    /**
     * Llave primaria de la Entidad TipoDocumento
     */
    @Id
    @Column (name = "id_tipoDocumento")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idTipoDocumento;    
    
    /**
     * Variable que almacena el nombre del tipo de documento
     */
    @Column (name = "tipo_documento")
    private String tipoDocumento;

     /**
     * Métodos GET Y SET
     * @return 
     */
    
    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
}
