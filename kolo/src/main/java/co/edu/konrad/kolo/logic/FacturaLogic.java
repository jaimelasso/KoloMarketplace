/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.FacturaEntity;
import co.edu.konrad.kolo.persistence.FacturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Factura
 * @author David C.
 */
@Stateless
public class FacturaLogic {
    /**
     * Inyección del persistence de factura
     */
    @Inject 
    private FacturaPersistence facturaPersistence;
    
    /**
     * Obtener todas las facturas
     * @return Lista Factura
     */
    public List<FacturaEntity> obtenerFacturas(){
        List<FacturaEntity> facturas = facturaPersistence.findAll();
        return facturas;
    }
    
    /**
     * Obtener un factura a partir del id
     * @param id
     * @return factura encontrado
     */
    public FacturaEntity obtenerFactura(Long id){
        FacturaEntity factura = facturaPersistence.find(id);
        if(factura == null){
            throw new IllegalArgumentException("Factura solicitado no existe.");
        }
        return factura;
    }
    
    /**
     * Crear un nuevo factura
     * @param facturaEntity
     * @return facturaEntity
     */
    public FacturaEntity crearFactura(FacturaEntity facturaEntity){
        facturaPersistence.create(facturaEntity);
        return facturaEntity;
    }
    
    /**
     * Actualiza un factura - Pilas cn el parametro id O-O
     * @param facturaEntity
     * @param id
     * @return factura actualizado
     */
    public FacturaEntity actualizarFactura(Long id, FacturaEntity facturaEntity){
        FacturaEntity factura = facturaPersistence.update(facturaEntity);
        return factura;
    }
    
    /**
     * Elimina un factura
     * @param id 
     */
    public void eliminarFactura(Long id){
        facturaPersistence.delete(id);
    }
}
