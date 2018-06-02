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
 * Clase para modelar la Entidad Ciudad
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class PaisEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad Ciudad
     */
    @Id
    @Column (name = "id_pais")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idPais;
    
    /**
     * Variable que almacena el nombre de a ciudad
     */
    @Column (name = "nombre_pais")
    private String nombrePais;

    /**
     * Métodos GET Y SET
     * @return 
     */
    
    public Long getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
}
