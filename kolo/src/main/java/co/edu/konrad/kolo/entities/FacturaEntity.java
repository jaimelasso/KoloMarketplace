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
 * Clase para modelar la Entidad Proveedor
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class FacturaEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;    
    
    /**
     * Llave primaria de la entidad Factura
     */
    @Id
    @Column (name = "id_Factura")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idFactura;
    
}
