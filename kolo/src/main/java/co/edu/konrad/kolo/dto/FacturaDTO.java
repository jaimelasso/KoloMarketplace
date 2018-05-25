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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Factura
 * @author Jaime Lasso
 */
public class FacturaDTO {
    
    private Long idFactura;
    private ClienteDTO cliente;    
    private Long total;
    private TipoPagoDTO tipoPago; 
    private InfoDebitoDTO infoDebito;   
    private InfoCreditoDTO infoCredito;  
    private boolean activoEnvioAlternativo;  
    private String direccionAlternativa;   
    private CiudadDTO ciudad;          
    private PaisDTO pais;       
    private Date fechaCompra; 

    /**
     * Constructor por defecto
     */    
    public FacturaDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad
     * Permite realizar el mapeo entidad a objeto
     * @param facturaEntity
     */    
    public FacturaDTO(FacturaEntity facturaEntity) {
        this.idFactura = facturaEntity.getIdFactura();
        if (facturaEntity.getCliente() != null) {
            ClienteEntity ce = new ClienteEntity();
            ce.setIdCliente(facturaEntity.getCliente().getIdCliente());
            ce.setNombreCliente(facturaEntity.getCliente().getNombreCliente());
            ce.setApellidoCliente(facturaEntity.getCliente().getApellidoCliente());
            ce.setTipoDocumento(facturaEntity.getCliente().getTipoDocumento());
            ce.setNumDocumento(facturaEntity.getCliente().getNumDocumento());
            ce.setFechaNacimiento(facturaEntity.getCliente().getFechaNacimiento());
            ce.setDireccionCliente(facturaEntity.getCliente().getDireccionCliente());
            ce.setCiudad(facturaEntity.getCliente().getCiudad());
            ce.setPais(facturaEntity.getCliente().getPais());
            ce.setTelefonoCliente(facturaEntity.getCliente().getTelefonoCliente());
            ce.setEmailCliente(facturaEntity.getCliente().getEmailCliente());
            ce.setUsuarioCliente(facturaEntity.getCliente().getUsuarioCliente());
            ce.setPasswordCliente(facturaEntity.getCliente().getPasswordCliente());
            ce.setUrlAvatar(facturaEntity.getCliente().getUrlAvatar());
            ce.setFechaCreacion(facturaEntity.getCliente().getFechaCreacion());
        }
        this.total = facturaEntity.getTotal();
        if (facturaEntity.getTipoPago() != null) {
            TipoPagoEntity tpe = new TipoPagoEntity();
            tpe.setIdTipoPago(facturaEntity.getTipoPago().getIdTipoPago());
            tpe.setNombreTipoPago(facturaEntity.getTipoPago().getNombreTipoPago());
        }
        if (facturaEntity.getInfoDebito() != null) {
            InfoDebitoEntity ide = new InfoDebitoEntity();
            ide.setNumCuenta(facturaEntity.getInfoDebito().getNumCuenta());
            ide.setNombreBanco(facturaEntity.getInfoDebito().getNombreBanco());
        }
        if (facturaEntity.getInfoCredito() != null) {
            InfoCreditoEntity ice = new InfoCreditoEntity();
            ice.setNumTarjeta(facturaEntity.getInfoCredito().getNumTarjeta());
            ice.setNombreFranquicia(facturaEntity.getInfoCredito().getNombreFranquicia());
            ice.setFechaVencimiento(facturaEntity.getInfoCredito().getFechaVencimiento());
            ice.setCodigoClave(facturaEntity.getInfoCredito().getCodigoClave());
        }
        this.activoEnvioAlternativo = facturaEntity.isActivoEnvioAlternativo();
        this.direccionAlternativa = facturaEntity.getDireccionAlternativa();
        if (facturaEntity.getCiudad() != null) {
            CiudadEntity ce = new CiudadEntity();
            
            ce.setIdCiudad(facturaEntity.getCiudad().getIdCiudad());
            ce.setNombreCiudad(facturaEntity.getCiudad().getNombreCiudad());
        }
        if (facturaEntity.getPais() != null) {
            PaisEntity pe = new PaisEntity();
            
            pe.setIdPais(facturaEntity.getPais().getIdPais());
            pe.setNombrePais(facturaEntity.getPais().getNombrePais());
        }
        this.fechaCompra = facturaEntity.getFechaCompra();
    }
    
    /**
     * Metodo que realiza el mapeo objeto relacional
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo FacturaEntity
     */
    public FacturaEntity toEntity() {
        FacturaEntity facturaEntity = new FacturaEntity();
        
        facturaEntity.setIdFactura(this.idFactura);
        if (this.cliente != null) {
            ClienteEntity ce = new ClienteEntity();
            
            ce.setIdCliente(this.cliente.getIdCliente());
            ce.setNombreCliente(this.cliente.getNombreCliente());
            ce.setApellidoCliente(this.cliente.getApellidoCliente());
            ce.setTipoDocumento(this.cliente.getTipoDocumento().toEntity());
            ce.setNumDocumento(this.cliente.getNumDocumento());
            ce.setFechaNacimiento(this.cliente.getFechaNacimiento());
            ce.setDireccionCliente(this.cliente.getDireccionCliente());
            ce.setCiudad(this.cliente.getCiudad().toEntity());
            ce.setPais(this.cliente.getPais().toEntity());
            ce.setTelefonoCliente(this.cliente.getTelefonoCliente());
            ce.setEmailCliente(this.cliente.getEmailCliente());
            ce.setUsuarioCliente(this.cliente.getUsuarioCliente());
            ce.setPasswordCliente(this.cliente.getPasswordCliente());
            ce.setUrlAvatar(this.cliente.getUrlAvatar());
            ce.setFechaCreacion(this.cliente.getFechaCreacion());
            
            facturaEntity.setCliente(ce);
        }
        facturaEntity.setTotal(this.total);
        if (this.tipoPago != null) {
            TipoPagoEntity tpe = new TipoPagoEntity();
            
            tpe.setIdTipoPago(this.tipoPago.getIdTipoPago());
            tpe.setNombreTipoPago(this.tipoPago.getNombreTipoPago());
            
            facturaEntity.setTipoPago(tpe);
        }
        if (this.infoDebito != null) {
            InfoDebitoEntity ide = new InfoDebitoEntity();
            
            ide.setNumCuenta(this.infoDebito.getNumCuenta());
            ide.setNombreBanco(this.infoDebito.getNombreBanco());
            
            facturaEntity.setInfoDebito(ide);
        }
        if (this.infoCredito != null) {
            InfoCreditoEntity ice = new InfoCreditoEntity();
            
            ice.setNumTarjeta(this.infoCredito.getNumTarjeta());
            ice.setNombreFranquicia(this.infoCredito.getNombreFranquicia());
            ice.setFechaVencimiento(this.infoCredito.getFechaVencimiento());
            ice.setCodigoClave(this.infoCredito.getCodigoClave());
            
            facturaEntity.setInfoCredito(ice);
        }
        facturaEntity.setActivoEnvioAlternativo(this.activoEnvioAlternativo);
        facturaEntity.setDireccionAlternativa(this.direccionAlternativa);
        if (this.ciudad != null) {
            CiudadEntity ce = new CiudadEntity();
            
            ce.setIdCiudad(this.ciudad.getIdCiudad());
            ce.setNombreCiudad(this.ciudad.getNombreCiudad());
            
            facturaEntity.setCiudad(ce);
        }
        if (this.pais != null) {
            PaisEntity pe = new PaisEntity();
            
            pe.setIdPais(this.pais.getIdPais());
            pe.setNombrePais(this.pais.getNombrePais());
            
            facturaEntity.setPais(pe);
        }        
        facturaEntity.setFechaCompra(this.fechaCompra);
        
        return facturaEntity;
    }
     /**
     * Conversión masiva de FacturaEntity a FacturaDTO
     * @param facturaList
     * @return Lista FacturaDTO
     */     
    public static List<FacturaDTO> toFacturaList(List<FacturaEntity> facturaList) {
        List<FacturaDTO> listaFacturaDTO = new ArrayList<>();
        for (int i = 0; i < facturaList.size(); i++) {
            listaFacturaDTO.add(new FacturaDTO(facturaList.get(i)));
        }
        return listaFacturaDTO;
    }  

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public TipoPagoDTO getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoDTO tipoPago) {
        this.tipoPago = tipoPago;
    }

    public InfoDebitoDTO getInfoDebito() {
        return infoDebito;
    }

    public void setInfoDebito(InfoDebitoDTO infoDebito) {
        this.infoDebito = infoDebito;
    }

    public InfoCreditoDTO getInfoCredito() {
        return infoCredito;
    }

    public void setInfoCredito(InfoCreditoDTO infoCredito) {
        this.infoCredito = infoCredito;
    }

    public boolean isActivoEnvioAlternativo() {
        return activoEnvioAlternativo;
    }

    public void setActivoEnvioAlternativo(boolean activoEnvioAlternativo) {
        this.activoEnvioAlternativo = activoEnvioAlternativo;
    }

    public String getDireccionAlternativa() {
        return direccionAlternativa;
    }

    public void setDireccionAlternativa(String direccionAlternativa) {
        this.direccionAlternativa = direccionAlternativa;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
    
}
