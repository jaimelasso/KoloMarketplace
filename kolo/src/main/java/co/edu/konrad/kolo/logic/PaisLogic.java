/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.PaisEntity;
import co.edu.konrad.kolo.persistence.PaisPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Pais
 * @author David C.
 */
@Stateless
public class PaisLogic {
        /**
     * Inyección del persistence de pais
     */
    @Inject 
    private PaisPersistence paisPersistence;
    
    /**
     * Obtener todas las paiss
     * @return Lista Pais
     */
    public List<PaisEntity> obtenerPaiss(){
        List<PaisEntity> paiss = paisPersistence.findAll();
        return paiss;
    }
    
    /**
     * Obtener un pais a partir del id
     * @param id
     * @return pais encontrado
     */
    public PaisEntity obtenerPais(Long id){
        PaisEntity pais = paisPersistence.find(id);
        if(pais == null){
            throw new IllegalArgumentException("Pais solicitado no existe.");
        }
        return pais;
    }
    
    /**
     * Crear un nuevo pais
     * @param paisEntity
     * @return paisEntity
     */
    public PaisEntity crearPais(PaisEntity paisEntity){
        paisPersistence.create(paisEntity);
        return paisEntity;
    }
    
    /**
     * Actualiza un pais - Pilas cn el parametro id O-O
     * @param paisEntity
     * @param id
     * @return pais actualizado
     */
    public PaisEntity actualizarPais(Long id, PaisEntity paisEntity){
        PaisEntity pais = paisPersistence.update(paisEntity);
        return pais;
    }
    
    /**
     * Elimina un pais
     * @param id 
     */
    public void eliminarPais(Long id){
        paisPersistence.delete(id);
    }
}
