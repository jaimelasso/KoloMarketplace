/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CiudadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Ciudad
 * @author Jaime Lasso
 */
public class CiudadDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */
    
    private Long idCiudad;
    private String nombreCiudad;
    
    /**
     * Constructor por defecto
     */
    public CiudadDTO () {
    }    
    
    /**
     * Constructor recibiendo como parámetro la ciudad
     * @param ciudadEntity
     */
    public CiudadDTO (CiudadEntity ciudadEntity) {    
        this.idCiudad = ciudadEntity.getIdCiudad();
        this.nombreCiudad = ciudadEntity.getNombreCiudad();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo ProveedorEntity
     */
     public CiudadEntity toEntity() {
         CiudadEntity ciudad = new CiudadEntity();
         
         ciudad.setIdCiudad(this.idCiudad);
         ciudad.setNombreCiudad(this.nombreCiudad);
         
         return ciudad;
     }
     
    /**
     * Conversión masiva de CiudadEntity a CiudadDTO
     * @param ciudadList
     * @return Lista Ciudad DTO
     */     
    public static List<CiudadDTO> toCiudadList(List<CiudadEntity> ciudadList) {
        List<CiudadDTO> listaCiudadDTO = new ArrayList<>();
        for (int i = 0; i < ciudadList.size(); i++) {
            listaCiudadDTO.add(new CiudadDTO(ciudadList.get(i)));
        }
        return listaCiudadDTO;
    }     
    
     /**
     * Métodos SET y GET
     */

    public Long getIdCiudad() {
        return idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
       
}
