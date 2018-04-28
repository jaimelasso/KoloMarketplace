/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import co.edu.konrad.kolo.persistence.InfoCreditoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del InfoCredito
 * @author David C.
 */
@Stateless
public class InfoCreditoLogic {
    /**
     * Inyección del persistence de infoCredito
     */
    @Inject 
    private InfoCreditoPersistence infoCreditoPersistence;
    
    /**
     * Obtener todas las infoCreditos
     * @return Lista InfoCredito
     */
    public List<InfoCreditoEntity> obtenerInfoCreditos(){
        List<InfoCreditoEntity> infoCreditos = infoCreditoPersistence.findAll();
        return infoCreditos;
    }
    
    /**
     * Obtener un infoCredito a partir del id
     * @param id
     * @return infoCredito encontrado
     */
    public InfoCreditoEntity obtenerInfoCredito(Long id){
        InfoCreditoEntity infoCredito = infoCreditoPersistence.find(id);
        if(infoCredito == null){
            throw new IllegalArgumentException("InfoCredito solicitado no existe.");
        }
        return infoCredito;
    }
    
    /**
     * Crear un nuevo infoCredito
     * @param infoCreditoEntity
     * @return infoCreditoEntity
     */
    public InfoCreditoEntity crearInfoCredito(InfoCreditoEntity infoCreditoEntity){
        infoCreditoPersistence.create(infoCreditoEntity);
        return infoCreditoEntity;
    }
    
    /**
     * Actualiza un infoCredito - Pilas cn el parametro id O-O
     * @param infoCreditoEntity
     * @param id
     * @return infoCredito actualizado
     */
    public InfoCreditoEntity actualizarInfoCredito(Long id, InfoCreditoEntity infoCreditoEntity){
        InfoCreditoEntity infoCredito = infoCreditoPersistence.update(infoCreditoEntity);
        return infoCredito;
    }
    
    /**
     * Elimina un infoCredito
     * @param id 
     */
    public void eliminarInfoCredito(Long id){
        infoCreditoPersistence.delete(id);
    }
}
