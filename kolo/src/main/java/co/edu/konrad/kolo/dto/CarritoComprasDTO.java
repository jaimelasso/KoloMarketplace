/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CarritoComprasEntity;
import co.edu.konrad.kolo.entities.FacturaEntity;
import co.edu.konrad.kolo.entities.ProductosEntity;

/**
 * DTO para el mapeo objeto relacional de la Entidad CarritoCompras
 * @author Jaime Lasso
 */
public class CarritoComprasDTO {

    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */    
    
    private Long idCarrito;
    private FacturaDTO factura;
    private ProductoDTO producto;
    private Long valorUnitario;
    private Long cantidad;
    private Long total;

    /**
     * Constructor por defecto
     */    
    
    public CarritoComprasDTO() {
    }

    /**
     * Constructor que permite realizar el mapeo entidad a objeto
     * @param cc 
     */
     public CarritoComprasDTO(CarritoComprasEntity cc) {
         this.idCarrito = cc.getIdCarrito();
         
         if (cc.getFacturaEntity() != null) {
             FacturaEntity factura = new FacturaEntity();
             
             factura.setIdFactura(cc.getFacturaEntity().getIdFactura());
             factura.setClienteEntity(cc.getFacturaEntity().getClienteEntity());
             factura.setTotal(cc.getFacturaEntity().getTotal());
             factura.setTipoPagoEntity(cc.getFacturaEntity().getTipoPagoEntity());
             factura.setInfoDebitoEntity(cc.getFacturaEntity().getInfoDebitoEntity());
             factura.setInfoCreditoEntity(cc.getFacturaEntity().getInfoCreditoEntity());
             factura.setActivoEnvioAlternativo(cc.getFacturaEntity().isActivoEnvioAlternativo());
             factura.setDireccionAlternativa(cc.getFacturaEntity().getDireccionAlternativa());
             factura.setCiudadEntity(cc.getFacturaEntity().getCiudadEntity());
             factura.setPaisEntity(cc.getFacturaEntity().getPaisEntity());
             factura.setFechaCompra(cc.getFacturaEntity().getFechaCompra());
             
             this.factura = new FacturaDTO(factura);
         }
         
         if (cc.getProductoEntity() != null) {
             ProductosEntity producto = new ProductosEntity();
             
             producto.setIdProducto(cc.getProductoEntity().getIdProducto());
             producto.setNombreProducto(cc.getProductoEntity().getNombreProducto());
             producto.setValorUnitario(cc.getProductoEntity().getValorUnitario());
             producto.setMarcaProducto(cc.getProductoEntity().getMarcaProducto());
             producto.setGarantiaProducto(cc.getProductoEntity().getGarantiaProducto());
             producto.setStockDisponible(cc.getProductoEntity().getStockDisponible());
             producto.setProveedor(cc.getProductoEntity().getProveedor());
             producto.setCategoriaEntity(cc.getProductoEntity().getCategoriaEntity());
             
             this.producto = new ProductoDTO(producto);
         }
         
         this.valorUnitario = cc.getValorUnitario();
         this.cantidad = cc.getCantidad();
         this.total = cc.getTotal();
     }
    
    /**
     * Metodo que realiza el mapeo objeto relacional
     * @return entidad CarritoCompras
     */     
    public CarritoComprasEntity toEntity() {
        CarritoComprasEntity cce = new CarritoComprasEntity();
        
        cce.setIdCarrito(this.idCarrito);
        
        if(this.factura != null) {
            FacturaEntity factura = new FacturaEntity();
            
            factura.setIdFactura(this.factura.get);
            
            cce.setFacturaEntity(factura);
        }
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
    
}
