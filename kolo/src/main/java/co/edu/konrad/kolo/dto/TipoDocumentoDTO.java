/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime Lasso
 */
public class TipoDocumentoDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */    
    
    private Long idTipoDocumento;
    private String tipoDocumento;  

    /**
     * Constructor por defecto
     */
    public TipoDocumentoDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad
     * @param tipoDocumentoEntity
     */
     public TipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
         this.idTipoDocumento = tipoDocumentoEntity.getIdTipoDocumento();
         this.tipoDocumento = tipoDocumentoEntity.getTipoDocumento();
     }

    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo ProveedorEntity
     */
     public TipoDocumentoEntity toEntity() {
         TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();
         
         tipoDocumento.setIdTipoDocumento(this.idTipoDocumento);
         tipoDocumento.setTipoDocumento(this.tipoDocumento);
         
         return tipoDocumento;
     }

    /**
     * Conversión masiva de ProveedorEntity a ProveedorDTO
     * @param tipoDocumentoList
     * @return Lista TipoDocumento DTO
     */
     public static List<TipoDocumentoDTO> toTipoDocumentoList(List<TipoDocumentoEntity> tipoDocumentoList) {
        List<TipoDocumentoDTO> listaTipoDocumentoDTO = new ArrayList<>();
        for (int i = 0; i < tipoDocumentoList.size(); i++) {
            listaTipoDocumentoDTO.add(new TipoDocumentoDTO(tipoDocumentoList.get(i)));
        }
        return listaTipoDocumentoDTO;         
     }

    /**
     * Métodos SET y GET
     */     
     
    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
