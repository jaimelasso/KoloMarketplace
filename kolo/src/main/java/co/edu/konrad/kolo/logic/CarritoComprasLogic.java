/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.CarritoComprasEntity;
import co.edu.konrad.kolo.persistence.CarritoComprasPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del CarritoCompras
 * @author David C.
 */
@Stateless
public class CarritoComprasLogic {
    /**
     * Inyección del persistence de carritoCompras
     */
    @Inject 
    private CarritoComprasPersistence carritoComprasPersistence;
    
    /**
     * Obtener todos los carritoComprass
     * @return Lista CarritoCompras
     */
    public List<CarritoComprasEntity> obtenerCarritoComprass(){
        List<CarritoComprasEntity> carritoComprass = carritoComprasPersistence.findAll();
        return carritoComprass;
    }
    
    /**
     * Obtener un carritoCompras a partir del id
     * @param id
     * @return carritoCompras encontrado
     */
    public CarritoComprasEntity obtenerCarritoCompras(Long id){
        CarritoComprasEntity carritoCompras = carritoComprasPersistence.find(id);
        if(carritoCompras == null){
            throw new IllegalArgumentException("CarritoCompras solicitado no existe.");
        }
        return carritoCompras;
    }
    
    /**
     * Crear un nuevo carritoCompras
     * @param ccEntity
     * @return estEntity
     */
    public CarritoComprasEntity crearCarritoCompras(CarritoComprasEntity ccEntity){
        carritoComprasPersistence.create(ccEntity);
        return ccEntity;
    }
    
    /**
     * Actualiza un carritoCompras - Pilas cn el parametro id O-O
     * @param ccEntity
     * @param id
     * @return carritoCompras actualizado
     */
    public CarritoComprasEntity actualizarCarritoCompras(Long id, CarritoComprasEntity ccEntity){
        CarritoComprasEntity carritoCompras = carritoComprasPersistence.update(ccEntity);
        return carritoCompras;
    }
    
    /**
     * Elimina un carritoCompras
     * @param id 
     */
    public void eliminarCarritoCompras(Long id){
        carritoComprasPersistence.delete(id);
    }
}
