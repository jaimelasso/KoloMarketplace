/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.CategoriaEntity;
import co.edu.konrad.kolo.persistence.CategoriaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Categoria
 * @author David C.
 */
@Stateless
public class CategoriaLogic {
    /**
     * Inyección del persistence de categoria
     */
    @Inject 
    private CategoriaPersistence categoriaPersistence;
    
    /**
     * Obtener todas las categorias
     * @return Lista Categoria
     */
    public List<CategoriaEntity> obtenerCategorias(){
        List<CategoriaEntity> categorias = categoriaPersistence.findAll();
        return categorias;
    }
    
    /**
     * Obtener un categoria a partir del id
     * @param id
     * @return categoria encontrado
     */
    public CategoriaEntity obtenerCategoria(Long id){
        CategoriaEntity categoria = categoriaPersistence.find(id);
        if(categoria == null){
            throw new IllegalArgumentException("Categoria solicitado no existe.");
        }
        return categoria;
    }
    
    /**
     * Crear un nuevo categoria
     * @param cateEntity
     * @return cateEntity
     */
    public CategoriaEntity crearCategoria(CategoriaEntity cateEntity){
        categoriaPersistence.create(cateEntity);
        return cateEntity;
    }
    
    /**
     * Actualiza un categoria - Pilas cn el parametro id O-O
     * @param cateEntity
     * @param id
     * @return categoria actualizado
     */
    public CategoriaEntity actualizarCategoria(Long id, CategoriaEntity cateEntity){
        CategoriaEntity categoria = categoriaPersistence.update(cateEntity);
        return categoria;
    }
    
    /**
     * Elimina un categoria
     * @param id 
     */
    public void eliminarCategoria(Long id){
        categoriaPersistence.delete(id);
    }
}
