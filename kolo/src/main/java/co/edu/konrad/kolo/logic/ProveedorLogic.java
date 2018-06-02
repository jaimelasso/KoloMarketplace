/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.ProveedorEntity;
import co.edu.konrad.kolo.persistence.ProveedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Proveedor
 * @author David C.
 */
@Stateless
public class ProveedorLogic {
                /**
     * Inyección del persistence de proveedor
     */
    @Inject 
    private ProveedorPersistence proveedorPersistence;
    
    /**
     * Obtener todas las proveedors
     * @return Lista Proveedor
     */
    public List<ProveedorEntity> obtenerProveedors(){
        List<ProveedorEntity> proveedors = proveedorPersistence.findAll();
        return proveedors;
    }
    
    /**
     * Obtener un proveedor a partir del id
     * @param id
     * @return proveedor encontrado
     */
    public ProveedorEntity obtenerProveedor(Long id){
        ProveedorEntity proveedor = proveedorPersistence.find(id);
        if(proveedor == null){
            throw new IllegalArgumentException("Proveedor solicitado no existe.");
        }
        return proveedor;
    }
    
    /**
     * Crear un nuevo proveedor
     * @param proveedorEntity
     * @return proveedorEntity
     */
    public ProveedorEntity crearProveedor(ProveedorEntity proveedorEntity){
        proveedorPersistence.create(proveedorEntity);
        return proveedorEntity;
    }
    
    /**
     * Actualiza un proveedor - Pilas cn el parametro id O-O
     * @param proveedorEntity
     * @param id
     * @return proveedor actualizado
     */
    public ProveedorEntity actualizarProveedor(Long id, ProveedorEntity proveedorEntity){
        ProveedorEntity proveedor = proveedorPersistence.update(proveedorEntity);
        return proveedor;
    }
    
    /**
     * Elimina un proveedor
     * @param id 
     */
    public void eliminarProveedor(Long id){
        proveedorPersistence.delete(id);
    }
}
