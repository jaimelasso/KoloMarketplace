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
    private ClienteEntity cliente;    
 
    @Column 
    private Long total;
    
    @ManyToOne
    @JoinColumn(name="id_tipoPago")
    private TipoPagoEntity tipoPago;        

    @ManyToOne
    @JoinColumn(name="num_cuenta")
    private InfoDebitoEntity infoDebito;        
    
    @ManyToOne
    @JoinColumn(name="num_tarjeta")
    private InfoCreditoEntity infoCredito;            

    @Column 
    private boolean activoEnvioAlternativo;    
    
    @Column 
    private String direccionAlternativa;    

    @ManyToOne
    @JoinColumn(name="id_ciudadAlternativa")
    private CiudadEntity ciudad;            

    @ManyToOne
    @JoinColumn(name="id_paisAlternativo")
    private PaisEntity pais;            

    @Column 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCompra;    

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public TipoPagoEntity getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoEntity tipoPago) {
        this.tipoPago = tipoPago;
    }

    public InfoDebitoEntity getInfoDebito() {
        return infoDebito;
    }

    public void setInfoDebito(InfoDebitoEntity infoDebito) {
        this.infoDebito = infoDebito;
    }

    public InfoCreditoEntity getInfoCredito() {
        return infoCredito;
    }

    public void setInfoCredito(InfoCreditoEntity infoCredito) {
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

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    
    
}
