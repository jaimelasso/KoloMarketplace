/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Clase para modelar la Entidad Factura
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class FacturaEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;    
    
    /**
     * Llave primaria de la entidad Factura
     */
    @Id
    @Column (name = "id_Factura")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idFactura;
    
    @ManyToOne
    @JoinColumn(name="cliente")
    private ClienteEntity clienteEntity;    
 
    @Column 
    private Long total;
    
    @ManyToOne
    @JoinColumn(name="tipoPago")
    private TipoPagoEntity tipoPagoEntity;        

    @ManyToOne
    @JoinColumn(name="num_cuenta")
    private InfoDebitoEntity infoDebitoEntity;        
    
    @ManyToOne
    @JoinColumn(name="num_tarjeta")
    private InfoCreditoEntity infoCreditoEntity;            

    @Column 
    private boolean activoEnvioAlternativo;    
    
    @Column 
    private String direccionAlternativa;    

    @ManyToOne
    @JoinColumn(name="id_ciudadAlternativa")
    private CiudadEntity ciudadEntity;            

    @ManyToOne
    @JoinColumn(name="id_paisAlternativo")
    private PaisEntity paisEntity;            

    @Column 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCompra;    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public Long getTotal() {
        return total;
    }

    public TipoPagoEntity getTipoPagoEntity() {
        return tipoPagoEntity;
    }

    public InfoDebitoEntity getInfoDebitoEntity() {
        return infoDebitoEntity;
    }

    public InfoCreditoEntity getInfoCreditoEntity() {
        return infoCreditoEntity;
    }

    public boolean isActivoEnvioAlternativo() {
        return activoEnvioAlternativo;
    }

    public String getDireccionAlternativa() {
        return direccionAlternativa;
    }

    public CiudadEntity getCiudadEntity() {
        return ciudadEntity;
    }

    public PaisEntity getPaisEntity() {
        return paisEntity;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setTipoPagoEntity(TipoPagoEntity tipoPagoEntity) {
        this.tipoPagoEntity = tipoPagoEntity;
    }

    public void setInfoDebitoEntity(InfoDebitoEntity infoDebitoEntity) {
        this.infoDebitoEntity = infoDebitoEntity;
    }

    public void setInfoCreditoEntity(InfoCreditoEntity infoCreditoEntity) {
        this.infoCreditoEntity = infoCreditoEntity;
    }

    public void setActivoEnvioAlternativo(boolean activoEnvioAlternativo) {
        this.activoEnvioAlternativo = activoEnvioAlternativo;
    }

    public void setDireccionAlternativa(String direccionAlternativa) {
        this.direccionAlternativa = direccionAlternativa;
    }

    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

    public void setPaisEntity(PaisEntity paisEntity) {
        this.paisEntity = paisEntity;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
    
}
