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
//import javax.persistence.NamedQuery;

/**
 * Clase para modelar la Entidad Proveedor
 * @author Jaime Lasso & Martín Cortés
 */
@Entity (name = "Categoria")
//@NamedQuery (name="Categoria.findByName", query="select e from Categoria e where e.nombreEstudiante = :nombre")
public class CategoriaEntity implements Serializable {
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;   
    
    /**
     * Llave primaria de la Entidad Categoria
     */
    @Id
    @Column (name = "id_categoria")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCategoria;
    
    /**
     * Variable que almacena el nombre de la categoría
     */
    @Column (name = "nombre_categoria")
    private String nombreCategoria;    

    
    /**
     * Métodos GET Y SET
     * @return 
     */

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
}
