/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.TipoPagoEntity;
import co.edu.konrad.kolo.persistence.TipoPagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del TipoPago
 * @author David C.
 */
public class TipoPagoLogic {
                        /**
     * Inyección del persistence de tipoPago
     */
    @Inject 
    private TipoPagoPersistence tipoPagoPersistence;
    
    /**
     * Obtener todas las tipoPagos
     * @return Lista TipoPago
     */
    public List<TipoPagoEntity> obtenerTipoPagos(){
        List<TipoPagoEntity> tipoPagos = tipoPagoPersistence.findAll();
        return tipoPagos;
    }
    
    /**
     * Obtener un tipoPago a partir del id
     * @param id
     * @return tipoPago encontrado
     */
    public TipoPagoEntity obtenerTipoPago(Long id){
        TipoPagoEntity tipoPago = tipoPagoPersistence.find(id);
        if(tipoPago == null){
            throw new IllegalArgumentException("TipoPago solicitado no existe.");
        }
        return tipoPago;
    }
    
    /**
     * Crear un nuevo tipoPago
     * @param tipoPagoEntity
     * @return tipoPagoEntity
     */
    public TipoPagoEntity crearTipoPago(TipoPagoEntity tipoPagoEntity){
        tipoPagoPersistence.create(tipoPagoEntity);
        return tipoPagoEntity;
    }
    
    /**
     * Actualiza un tipoPago - Pilas cn el parametro id O-O
     * @param tipoPagoEntity
     * @param id
     * @return tipoPago actualizado
     */
    public TipoPagoEntity actualizarTipoPago(Long id, TipoPagoEntity tipoPagoEntity){
        TipoPagoEntity tipoPago = tipoPagoPersistence.update(tipoPagoEntity);
        return tipoPago;
    }
    
    /**
     * Elimina un tipoPago
     * @param id 
     */
    public void eliminarTipoPago(Long id){
        tipoPagoPersistence.delete(id);
    }
}
