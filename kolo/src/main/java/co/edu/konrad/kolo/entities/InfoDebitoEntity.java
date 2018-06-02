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
 * Clase para modelar la Entidad InfoDebito
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class InfoDebitoEntity implements Serializable{
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad InfoDebito
     */
    @Id
    @Column (name = "num_cuenta")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long numCuenta;
    
    /**
     * Variable que almacena el nombre de InfoDebito
     */
    @Column (name = "nombre_banco")
    private String nombreBanco;


    /**
     * Métodos GET Y SET
     * @return 
     */    
    
    public Long getNumCuenta() {
        return numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNumCuenta(Long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
        
}
