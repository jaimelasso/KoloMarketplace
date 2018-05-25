/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CarritoComprasEntity;
import co.edu.konrad.kolo.entities.FacturaEntity;
import co.edu.konrad.kolo.entities.ProductosEntity;
import java.util.ArrayList;
import java.util.List;

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
             factura.setCliente(cc.getFacturaEntity().getCliente());
             factura.setTotal(cc.getFacturaEntity().getTotal());
             factura.setTipoPago(cc.getFacturaEntity().getTipoPago());
             factura.setInfoDebito(cc.getFacturaEntity().getInfoDebito());
             factura.setInfoCredito(cc.getFacturaEntity().getInfoCredito());
             factura.setActivoEnvioAlternativo(cc.getFacturaEntity().isActivoEnvioAlternativo());
             factura.setDireccionAlternativa(cc.getFacturaEntity().getDireccionAlternativa());
             factura.setCiudad(cc.getFacturaEntity().getCiudad());
             factura.setPais(cc.getFacturaEntity().getPais());
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
             producto.setCategoria(cc.getProductoEntity().getCategoria());
             
             this.producto = new ProductoDTO(producto);
         }
         
         this.valorUnitario = cc.getValorUnitario();
         this.cantidad = cc.getCantidad();
         this.total = cc.getTotal();
     }
    
    /**
     * Metodo que realiza el mapeo objeto relacional
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo CarritoComprasEntity
     */
    public CarritoComprasEntity toEntity() {
        CarritoComprasEntity cce = new CarritoComprasEntity();
        
        cce.setIdCarrito(this.idCarrito);
        if (this.factura != null) {
            FacturaEntity fe = new FacturaEntity();
            
            fe.setIdFactura(this.factura.getIdFactura());
            fe.setCliente(this.factura.getCliente().toEntity());
            fe.setTotal(this.factura.getTotal());
            fe.setTipoPago(this.factura.getTipoPago().toEntity());
            fe.setInfoDebito(this.factura.getInfoDebito().toEntity());
            fe.setInfoCredito(this.factura.getInfoCredito().toEntity());
            fe.setActivoEnvioAlternativo(this.factura.isActivoEnvioAlternativo());
            fe.setDireccionAlternativa(this.factura.getDireccionAlternativa());
            fe.setCiudad(this.factura.getCiudad().toEntity());
            fe.setPais(this.factura.getPais().toEntity());
            fe.setFechaCompra(this.factura.getFechaCompra());
            
            cce.setFacturaEntity(fe);
        }
        if (this.producto != null) {
            ProductosEntity pe = new ProductosEntity();
            
            pe.setIdProducto(this.producto.getIdProducto());
            pe.setNombreProducto(this.producto.getNombreProducto());
            pe.setValorUnitario(this.producto.getValorUnitario());
            pe.setMarcaProducto(this.producto.getMarcaProducto());
            pe.setGarantiaProducto(this.producto.getGarantiaProducto());
            pe.setStockDisponible(this.producto.getStockDisponible());
            pe.setProveedor(this.producto.getProveedor().toEntity());
            pe.setCategoria(this.producto.getCategoria().toEntity());
            
            cce.setProductoEntity(pe);
        }
        
        return cce;
    }
     /**
     * Conversión masiva de CarritoComprasEntity a CarritoComprasDTO
     * @param CarritoComprasList
     * @return Lista CarritoComprasDTO
     */  
    public static List<CarritoComprasDTO> toCarritoComprasList(List<CarritoComprasEntity> carritoComprasList) {
        List<CarritoComprasDTO> listaCarritoComprasDTO = new ArrayList<>();
        for (int i = 0; i < carritoComprasList.size(); i++) {
            listaCarritoComprasDTO.add(new CarritoComprasDTO(carritoComprasList.get(i)));
        }
        return listaCarritoComprasDTO;
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
