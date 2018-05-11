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
     * Llave primaria de la Entidad Carrito de Compras
     */
    @Id
    @Column (name = "id_carrito", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCarrito;    
    
    @OneToMany
    @JoinColumn (name = "idFactura")
    private FacturaEntity facturaEntity;    
    
    @ManyToOne
    @JoinColumn (name = "idProducto")
    private ProductosEntity productoEntity;      

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

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public FacturaEntity getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

    public ProductosEntity getProductoEntity() {
        return productoEntity;
    }

    public void setProductoEntity(ProductosEntity productoEntity) {
        this.productoEntity = productoEntity;
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
