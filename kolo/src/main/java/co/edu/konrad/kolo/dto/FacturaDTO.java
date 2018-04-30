/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CiudadEntity;
import co.edu.konrad.kolo.entities.ClienteEntity;
import co.edu.konrad.kolo.entities.FacturaEntity;
import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import co.edu.konrad.kolo.entities.InfoDebitoEntity;
import co.edu.konrad.kolo.entities.PaisEntity;
import co.edu.konrad.kolo.entities.TipoPagoEntity;
import java.util.Date;

/**
 * DTO para el mapeo objeto relacional de la Entidad Factura
 * @author Jaime Lasso
 */
public class FacturaDTO {
    
    private Long idFactura;
    private ClienteEntity clienteEntity;    
    private Long total;
    private TipoPagoEntity tipoPagoEntity; 
    private InfoDebitoEntity infoDebitoEntity;   
    private InfoCreditoEntity infoCreditoEntity;  
    private boolean activoEnvioAlternativo;  
    private String direccionAlternativa;   
    private CiudadEntity ciudadEntity;          
    private PaisEntity paisEntity;       
    private Date fechaCompra; 

    /**
     * Constructor por defecto
     */    
    public FacturaDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad
     *
     * @param facturaEntity
     */
    
    public FacturaDTO(FacturaEntity facturaEntity) {
        this.idFactura = facturaEntity.getIdFactura();
        if (facturaEntity.getClienteEntity() != null) {
            ClienteEntity ce = new ClienteEntity();
            
            ce.setIdCliente(facturaEntity.getClienteEntity().getIdCliente());
            ce.setNombreCliente(facturaEntity.getClienteEntity().getNombreCliente());
            ce.setApellidoCliente(facturaEntity.getClienteEntity().getApellidoCliente());
            ce.setTipoDocumento(facturaEntity.getClienteEntity().getTipoDocumentoEntity());
            ce.setNumDocumento(facturaEntity.getClienteEntity().getNumDocumento());
            ce.setFechaNacimiento(facturaEntity.getClienteEntity().getFechaNacimiento());
            ce.setDireccionCliente(facturaEntity.getClienteEntity().getDireccionCliente());
            ce.setIdCiudad(facturaEntity.getClienteEntity().getCiudadEntity());
            ce.setIdPais(facturaEntity.get);
        }
    }
    
}
