/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.InfoDebitoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad InfoDebito
 * @author Jaime Lasso
 */
public class InfoDebitoDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */

     private Long numCuenta;
     private String nombreBanco;
     
    /**
     * Constructor por defecto
     */
    public InfoDebitoDTO () {
    }
    
    /**
     * Constructor recibiendo como parámetro la entidad
     * @param infoDebitoEntity
     */
    public InfoDebitoDTO (InfoDebitoEntity infoDebitoEntity) {
        this.numCuenta = infoDebitoEntity.getNumCuenta();
        this.nombreBanco = infoDebitoEntity.getNombreBanco();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo InfoDebitoEntity
     */    
    public InfoDebitoEntity toEntity() {
        InfoDebitoEntity infoDebito = new InfoDebitoEntity();
        
        infoDebito.setNumCuenta(this.numCuenta);
        infoDebito.setNombreBanco(this.nombreBanco);
        
        return infoDebito;
    }
    
    /**
     * Conversión masiva de InfoDebitoEntity a InfoDebitoDTO
     * @param infoDebitoList
     * @return Lista TipoPago DTO
     */
    public static List<InfoDebitoDTO> toInfoPagoList(List<InfoDebitoEntity> infoDebitoList) {
        List<InfoDebitoDTO> listaInfoDebitoDTO = new ArrayList<>();
        for (int i = 0; i < infoDebitoList.size(); i++) {
            listaInfoDebitoDTO.add(new InfoDebitoDTO(infoDebitoList.get(i)));
        }
        return listaInfoDebitoDTO;
    }

    /**
     * Métodos SET y GET
     */        

    public Long getNumCuenta() {
        return numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNumCuenta(Long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
