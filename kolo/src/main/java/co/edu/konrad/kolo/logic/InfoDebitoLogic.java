/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.InfoDebitoEntity;
import co.edu.konrad.kolo.persistence.InfoDebitoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del InfoDebito
 * @author David C.
 */
@Stateless
public class InfoDebitoLogic {
    /**
     * Inyección del persistence de infoDebito
     */
    @Inject 
    private InfoDebitoPersistence infoDebitoPersistence;
    
    /**
     * Obtener todas las infoDebitos
     * @return Lista InfoDebito
     */
    public List<InfoDebitoEntity> obtenerInfoDebitos(){
        List<InfoDebitoEntity> infoDebitos = infoDebitoPersistence.findAll();
        return infoDebitos;
    }
    
    /**
     * Obtener un infoDebito a partir del id
     * @param id
     * @return infoDebito encontrado
     */
    public InfoDebitoEntity obtenerInfoDebito(Long id){
        InfoDebitoEntity infoDebito = infoDebitoPersistence.find(id);
        if(infoDebito == null){
            throw new IllegalArgumentException("InfoDebito solicitado no existe.");
        }
        return infoDebito;
    }
    
    /**
     * Crear un nuevo infoDebito
     * @param infoDebitoEntity
     * @return infoDebitoEntity
     */
    public InfoDebitoEntity crearInfoDebito(InfoDebitoEntity infoDebitoEntity){
        infoDebitoPersistence.create(infoDebitoEntity);
        return infoDebitoEntity;
    }
    
    /**
     * Actualiza un infoDebito - Pilas cn el parametro id O-O
     * @param infoDebitoEntity
     * @param id
     * @return infoDebito actualizado
     */
    public InfoDebitoEntity actualizarInfoDebito(Long id, InfoDebitoEntity infoDebitoEntity){
        InfoDebitoEntity infoDebito = infoDebitoPersistence.update(infoDebitoEntity);
        return infoDebito;
    }
    
    /**
     * Elimina un infoDebito
     * @param id 
     */
    public void eliminarInfoDebito(Long id){
        infoDebitoPersistence.delete(id);
    }
}
