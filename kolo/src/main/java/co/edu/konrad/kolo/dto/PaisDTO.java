/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.PaisEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad País
 * @author Jaime Lasso
 */
public class PaisDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */
    
    private Long idPais;
    private String nombrePais;
    
    /**
     * Constructor por defecto
     */
    public PaisDTO () {
    }    
    
    /**
     * Constructor recibiendo como parámetro la ciudad
     * @param paisEntity
     */
    public PaisDTO (PaisEntity paisEntity) {    
        this.idPais = paisEntity.getIdPais();
        this.nombrePais = paisEntity.getNombrePais();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo PaisEntity
     */
     public PaisEntity toEntity() {
         PaisEntity pais = new PaisEntity();
         
         pais.setIdPais(this.idPais);
         pais.setNombrePais(this.nombrePais);
         
         return pais;
     }
     
    /**
     * Conversión masiva de PaisEntity a PaisDTO
     * @param paisList
     * @return Lista Pais DTO
     */     
    public static List<PaisDTO> toPaisList(List<PaisEntity> paisList) {
        List<PaisDTO> listaPaisDTO = new ArrayList<>();
        for (int i = 0; i < paisList.size(); i++) {
            listaPaisDTO.add(new PaisDTO(paisList.get(i)));
        }
        return listaPaisDTO;
    }

    /**
     * Métodos SET y GET
     */
    
    public Long getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    
}