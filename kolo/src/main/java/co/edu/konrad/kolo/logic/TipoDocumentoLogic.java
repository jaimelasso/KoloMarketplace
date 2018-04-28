/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import co.edu.konrad.kolo.persistence.TipoDocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del TipoDocumento
 * @author David C.
 */
public class TipoDocumentoLogic {
                    /**
     * Inyección del persistence de tipoDocumento
     */
    @Inject 
    private TipoDocumentoPersistence tipoDocumentoPersistence;
    
    /**
     * Obtener todas las tipoDocumentos
     * @return Lista TipoDocumento
     */
    public List<TipoDocumentoEntity> obtenerTipoDocumentos(){
        List<TipoDocumentoEntity> tipoDocumentos = tipoDocumentoPersistence.findAll();
        return tipoDocumentos;
    }
    
    /**
     * Obtener un tipoDocumento a partir del id
     * @param id
     * @return tipoDocumento encontrado
     */
    public TipoDocumentoEntity obtenerTipoDocumento(Long id){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoPersistence.find(id);
        if(tipoDocumento == null){
            throw new IllegalArgumentException("TipoDocumento solicitado no existe.");
        }
        return tipoDocumento;
    }
    
    /**
     * Crear un nuevo tipoDocumento
     * @param tipoDocumentoEntity
     * @return tipoDocumentoEntity
     */
    public TipoDocumentoEntity crearTipoDocumento(TipoDocumentoEntity tipoDocumentoEntity){
        tipoDocumentoPersistence.create(tipoDocumentoEntity);
        return tipoDocumentoEntity;
    }
    
    /**
     * Actualiza un tipoDocumento - Pilas cn el parametro id O-O
     * @param tipoDocumentoEntity
     * @param id
     * @return tipoDocumento actualizado
     */
    public TipoDocumentoEntity actualizarTipoDocumento(Long id, TipoDocumentoEntity tipoDocumentoEntity){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoPersistence.update(tipoDocumentoEntity);
        return tipoDocumento;
    }
    
    /**
     * Elimina un tipoDocumento
     * @param id 
     */
    public void eliminarTipoDocumento(Long id){
        tipoDocumentoPersistence.delete(id);
    }
}
