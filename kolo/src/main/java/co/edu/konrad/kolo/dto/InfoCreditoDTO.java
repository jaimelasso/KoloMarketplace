/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import java.util.Date;
import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad InfoCredito
 * @author Jaime Lasso
 */
public class InfoCreditoDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */

     private Long numTarjeta;
     private String nombreFranquicia;
     private Date fechaVencimiento;
     private Long codigoClave;
     
     /**
     * Constructor por defecto
     */
     
     public InfoCreditoDTO() {
     }
     
    /**
     * Constructor recibiendo como parámetro la entidad
     * @param infoCreditoEntity
     */
    public InfoCreditoDTO (InfoCreditoEntity infoCreditoEntity) {
        this.numTarjeta = infoCreditoEntity.getNumTarjeta();
        this.nombreFranquicia = infoCreditoEntity.getNombreFranquicia();
        this.fechaVencimiento = infoCreditoEntity.getFechaVencimiento();
        this.codigoClave = infoCreditoEntity.getCodigoClave();
    }     
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo InfoDebitoEntity
     */        
    public InfoCreditoEntity toEntity() {
        InfoCreditoEntity infoCredito = new InfoCreditoEntity();
        
        infoCredito.setNumTarjeta(this.numTarjeta);
        infoCredito.setNombreFranquicia(this.nombreFranquicia);
        infoCredito.setFechaVencimiento(this.fechaVencimiento);
        infoCredito.setCodigoClave(this.codigoClave);
        
        return infoCredito;
    }    
    
    /**
     * Conversión masiva de InfoDebitoEntity a InfoDebitoDTO
     * @param infoCreditoList
     * @return Lista TipoPago DTO
     */    
    public static List<InfoCreditoDTO> toInfoCreditoList(List<InfoCreditoEntity> infoCreditoList) {
        List<InfoCreditoDTO> listaInfoCreditoDTO = new ArrayList<>();
        for (int i = 0; i < infoCreditoList.size(); i++) {
            listaInfoCreditoDTO.add(new InfoCreditoDTO(infoCreditoList.get(i)));
        }
        return listaInfoCreditoDTO;
    }    
}
