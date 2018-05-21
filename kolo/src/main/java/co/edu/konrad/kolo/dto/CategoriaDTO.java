/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Categoria
 * @author Jaime Lasso
 */
public class CategoriaDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */
    
    private Long idCategoria;
    private String nombreCategoria;

    /**
     * Constructor por defecto
     */
     
    public CategoriaDTO() {
    }
    
    /**
     * Constructor recibiendo como parámetro la ciudad
     * @param categoriaEntity
     */
    public CategoriaDTO (CategoriaEntity categoriaEntity) {
        this.idCategoria = categoriaEntity.getIdCategoria();
        this.nombreCategoria = categoriaEntity.getNombreCategoria();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo CategoriaEntity
     */    
    public CategoriaEntity toEntity() {
        CategoriaEntity categoria = new CategoriaEntity();
        
        categoria.setIdCategoria(this.idCategoria);
        categoria.setNombreCategoria(this.nombreCategoria);
        
        return categoria;
    }
    
    /**
     * Conversión masiva de PaisEntity a PaisDTO
     * @param categoriaList
     * @return Lista Categoria DTO
     */         
    public static List<CategoriaDTO> toCategoriaList(List<CategoriaEntity> categoriaList) {
        List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
        for (int i = 0; i < categoriaList.size(); i++) {
            listaCategoriaDTO.add(new CategoriaDTO(categoriaList.get(i)));
        }
        return listaCategoriaDTO;
    }
    
    /**
     * Métodos SET y GET
     */    

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
    
}
