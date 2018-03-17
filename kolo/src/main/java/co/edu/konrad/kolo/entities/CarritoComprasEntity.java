/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Clase para modelar la Entidad Proveedor
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class CarritoComprasEntity implements Serializable {
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;
    
    /**
     * Llave primaria de la Entidad Proveedor
     */
    @Id
    @Column (name = "id_carrito", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCarrito;    
    
    @OneToMany
    @JoinColumn (name = "idFactura")
    private FacturaEntity factura;    
    
    @ManyToOne
    @JoinColumn (name = "idProducto")
    private ProductosEntity productos;      

    /**
     * Variable que almacena el valor unitario por producto en el carrito
     */
    @Column (name = "valor_unitario", nullable = false)
    private Long valorUnitario;
    
    /**
     * Variable que almacena la cantidad de productos comprados en el carrito
     */
    @Column (name = "cantidad", nullable = false)
    private Long cantidad;

    /**
     * Variable que almacena el total de la compra en el carrito
     */
    @Column (name = "total", nullable = false)
    private Long total;

   
    /**
     * Métodos GET Y SET
     * @return 
     */
    
    public Long getIdCarrito() {
        return idCarrito;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public ProductosEntity getProductos() {
        return productos;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Long getTotal() {
        return total;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    public void setProductos(ProductosEntity productos) {
        this.productos = productos;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    
    
    
}
