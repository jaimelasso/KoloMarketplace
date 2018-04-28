/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.CiudadEntity;
import co.edu.konrad.kolo.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Ciudad
 * @author David C.
 */
@Stateless
public class CiudadLogic {
    /**
     * Inyección del persistence de ciudad
     */
    @Inject 
    private CiudadPersistence ciudadPersistence;
    
    /**
     * Obtener todas las ciudads
     * @return Lista Ciudad
     */
    public List<CiudadEntity> obtenerCiudads(){
        List<CiudadEntity> ciudads = ciudadPersistence.findAll();
        return ciudads;
    }
    
    /**
     * Obtener un ciudad a partir del id
     * @param id
     * @return ciudad encontrado
     */
    public CiudadEntity obtenerCiudad(Long id){
        CiudadEntity ciudad = ciudadPersistence.find(id);
        if(ciudad == null){
            throw new IllegalArgumentException("Ciudad solicitado no existe.");
        }
        return ciudad;
    }
    
    /**
     * Crear un nuevo ciudad
     * @param ciudadEntity
     * @return ciudadEntity
     */
    public CiudadEntity crearCiudad(CiudadEntity ciudadEntity){
        ciudadPersistence.create(ciudadEntity);
        return ciudadEntity;
    }
    
    /**
     * Actualiza un ciudad - Pilas cn el parametro id O-O
     * @param ciudadEntity
     * @param id
     * @return ciudad actualizado
     */
    public CiudadEntity actualizarCiudad(Long id, CiudadEntity ciudadEntity){
        CiudadEntity ciudad = ciudadPersistence.update(ciudadEntity);
        return ciudad;
    }
    
    /**
     * Elimina un ciudad
     * @param id 
     */
    public void eliminarCiudad(Long id){
        ciudadPersistence.delete(id);
    }
}
