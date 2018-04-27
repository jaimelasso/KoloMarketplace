/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.ClienteEntity;
import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import java.util.Date;

/**
 *
 * @author Jaime Lasso
 */
public class ClienteDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */    
    
    private Long idCliente;
    private String nombreCliente;    
    private String apellidoCliente;
    private TipoDocumentoDTO tipoDocumento; 
    private Long numDocumento;    
    private Date fechaNacimiento;  
    private String direccionCliente;   
    private CiudadDTO idCiudad;    
    private PaisDTO idPais;
    private Long telefonoCliente;
    private String emailCliente; 
    private String usuarioCliente;        
    private String passwordCliente;    
    private String urlAvatar;    
    private Date fechaCreacion; 

    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad
     * @param clienteEntity
     */
     public ClienteDTO(ClienteEntity clienteEntity) {
         this.idCliente = clienteEntity.getIdCliente();
         this.nombreCliente = clienteEntity.getNombreCliente();
         this.apellidoCliente = clienteEntity.getApellidoCliente();
         
         if(clienteEntity.getTipoDocumentoEntity()!= null) {
             TipoDocumentoEntity tde = new TipoDocumentoEntity();
             
             tde.setIdTipoDocumento(clienteEntity.getTipoDocumentoEntity);
         }
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
