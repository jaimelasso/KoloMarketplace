/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.TipoPagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad TipoPago
 * @author Jaime Lasso
 */
public class TipoPagoDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */

     private Long idTipoPago;
     private String nombreTipoPago;

    /**
     * Constructor por defecto
     */
    public TipoPagoDTO () {
    }
    
    /**
     * Constructor recibiendo como parámetro la entidad
     * @param tipoPagoEntity
     */
    public TipoPagoDTO (TipoPagoEntity tipoPagoEntity) {
        this.idTipoPago = tipoPagoEntity.getIdTipoPago();
        this.nombreTipoPago = tipoPagoEntity.getNombreTipoPago();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo TipoPagoEntity
     */    
    public TipoPagoEntity toEntity() {
        TipoPagoEntity tipoPago = new TipoPagoEntity();
        
        tipoPago.setIdTipoPago(this.idTipoPago);
        tipoPago.setNombreTipoPago(this.nombreTipoPago);
        
        return tipoPago;
    }
    
    /**
     * Conversión masiva de TipoPagoEntity a TipoPagoDTO
     * @param tipoPagoList
     * @return Lista TipoPago DTO
     */
    public static List<TipoPagoDTO> toTipoPagoList(List<TipoPagoEntity> tipoPagoList) {
        List<TipoPagoDTO> listaTipoPagoDTO = new ArrayList<>();
        for (int i = 0; i < tipoPagoList.size(); i++) {
            listaTipoPagoDTO.add(new TipoPagoDTO(tipoPagoList.get(i)));
        }
        return listaTipoPagoDTO;
    }

    /**
     * Métodos SET y GET
     */    
    
    public Long getIdTipoPago() {
        return idTipoPago;
    }

    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    public void setIdTipoPago(Long idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }
    
}
