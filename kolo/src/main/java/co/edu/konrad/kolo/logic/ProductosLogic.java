/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.ProductosEntity;
import co.edu.konrad.kolo.persistence.ProductosPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Productos
 * @author David C.
 */
public class ProductosLogic {
            /**
     * Inyección del persistence de productos
     */
    @Inject 
    private ProductosPersistence productosPersistence;
    
    /**
     * Obtener todas las productoss
     * @return Lista Productos
     */
    public List<ProductosEntity> obtenerProductoss(){
        List<ProductosEntity> productoss = productosPersistence.findAll();
        return productoss;
    }
    
    /**
     * Obtener un productos a partir del id
     * @param id
     * @return productos encontrado
     */
    public ProductosEntity obtenerProductos(Long id){
        ProductosEntity productos = productosPersistence.find(id);
        if(productos == null){
            throw new IllegalArgumentException("Productos solicitado no existe.");
        }
        return productos;
    }
    
    /**
     * Crear un nuevo productos
     * @param productosEntity
     * @return productosEntity
     */
    public ProductosEntity crearProductos(ProductosEntity productosEntity){
        productosPersistence.create(productosEntity);
        return productosEntity;
    }
    
    /**
     * Actualiza un productos - Pilas cn el parametro id O-O
     * @param productosEntity
     * @param id
     * @return productos actualizado
     */
    public ProductosEntity actualizarProductos(Long id, ProductosEntity productosEntity){
        ProductosEntity productos = productosPersistence.update(productosEntity);
        return productos;
    }
    
    /**
     * Elimina un productos
     * @param id 
     */
    public void eliminarProductos(Long id){
        productosPersistence.delete(id);
    }
}
