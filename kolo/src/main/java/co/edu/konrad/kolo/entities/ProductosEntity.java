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

/**
 * Clase para modelar la Entidad Proveedor
 * @author Jaime Lasso & Martín Cortés
 */
@Entity
public class ProductosEntity implements Serializable {
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID=1L;    

    /**
     * Llave primaria de la Entidad Productos
     */
    @Id
    @Column (name = "id_producto", unique = true)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idProducto;
    
    /**
     * Variable que almacena el nombre del producto
     */
    @Column (name = "nombre_producto")
    private String nombreProducto;    

    /**
     * Variable que almacena el valor unitario del producto
     */
    @Column (name = "valor_unitario")
    private Long valorUnitario;

    /**
     * Variable que almacena la marca del producto
     */
    @Column (name = "marca_producto")
    private String marcaProducto;    
    
    /**
     * Variable que almacena la marca del producto
     */
    @Column (name = "garantia_producto")
    private String garantiaProducto;      

    /**
     * Variable que almacena el stock disponible del producto
     */
    @Column (name = "stock_disponible")
    private Long stockDisponible;
    
     /**
     * Variable que almacena y relaciona el ID del proveedor
     */
    @ManyToOne
    @JoinColumn (name = "idProveedor")
    private ProveedorEntity proveedor;
    
    /**
     * Variable que almacena y relaciona el ID de la categoría
     */
    @ManyToOne
    @JoinColumn (name = "idCategoria")
    private ProveedorEntity CategoriaEntity;

   
    /**
     * Métodos GET Y SET
     * @return 
     */
    
    public Long getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public String getGarantiaProducto() {
        return garantiaProducto;
    }

    public Long getStockDisponible() {
        return stockDisponible;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public ProveedorEntity getCategoriaEntity() {
        return CategoriaEntity;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public void setGarantiaProducto(String garantiaProducto) {
        this.garantiaProducto = garantiaProducto;
    }

    public void setStockDisponible(Long stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public void setCategoriaEntity(ProveedorEntity CategoriaEntity) {
        this.CategoriaEntity = CategoriaEntity;
    }

    
    
}
