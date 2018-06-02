/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CategoriaEntity;
import co.edu.konrad.kolo.entities.ProductosEntity;
import co.edu.konrad.kolo.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Producto
 *
 * @author Jaime Lasso
 */
public class ProductoDTO {

    private Long idProducto;
    private String nombreProducto;
    private Long valorUnitario;
    private String marcaProducto;
    private String garantiaProducto;
    private Long stockDisponible;
    private ProveedorDTO proveedor;
    private CategoriaDTO categoria;

    /**
     * Constructor por defecto
     */
    public ProductoDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad Permite realizar el
     * mapeo entidad a objeto
     *
     * @param productoEntity
     */
    public ProductoDTO(ProductosEntity productoEntity) {
        this.idProducto = productoEntity.getIdProducto();
        this.nombreProducto = productoEntity.getNombreProducto();
        this.valorUnitario = productoEntity.getValorUnitario();
        this.marcaProducto = productoEntity.getMarcaProducto();
        this.garantiaProducto = productoEntity.getGarantiaProducto();
        this.stockDisponible = productoEntity.getStockDisponible();
        if (productoEntity.getProveedor() != null) {
            ProveedorEntity pe = new ProveedorEntity();
            pe.setIdProveedor(productoEntity.getProveedor().getIdProveedor());
            pe.setNitProveedor(productoEntity.getProveedor().getNitProveedor());
            pe.setUsuarioProveedor(productoEntity.getProveedor().getUsuarioProveedor());
            pe.setPasswordProveedor(productoEntity.getProveedor().getPasswordProveedor());
            pe.setUrlAvatarProveedor(productoEntity.getProveedor().getUrlAvatarProveedor());
            pe.setVentasAnuales(productoEntity.getProveedor().getVentasAnuales());
            pe.setMercadoObjetivo(productoEntity.getProveedor().getMercadoObjetivo());
            pe.setNivelReputacion(productoEntity.getProveedor().getNivelReputacion());
            pe.setNumTelefono(productoEntity.getProveedor().getNumTelefono());
            pe.setUrlChat(productoEntity.getProveedor().getUrlChat());
            pe.setDireccionProveedor(productoEntity.getProveedor().getDireccionProveedor());
            pe.setFechaCreacion(productoEntity.getProveedor().getFechaCreacion());
        }
        if (productoEntity.getCategoria() != null) {
            CategoriaEntity ce = new CategoriaEntity();
            ce.setIdCategoria(productoEntity.getCategoria().getIdCategoria());
            ce.setNombreCategoria(productoEntity.getCategoria().getNombreCategoria());
        }
    }

    /**
     * Metodo que realiza el mapeo objeto relacional Método para mapear a la
     * entidad los datos capturados en la vista
     *
     * @return objeto de tipo ProductoEntity
     */
    public ProductosEntity toEntity() {
        ProductosEntity productosEntity = new ProductosEntity();

        productosEntity.setIdProducto(this.idProducto);
        productosEntity.setNombreProducto(this.nombreProducto);
        productosEntity.setValorUnitario(this.valorUnitario);
        productosEntity.setMarcaProducto(this.marcaProducto);
        productosEntity.setGarantiaProducto(this.garantiaProducto);
        productosEntity.setStockDisponible(this.stockDisponible);
        if (this.proveedor != null) {
            ProveedorEntity pe = new ProveedorEntity();

            pe.setIdProveedor(this.proveedor.getId());
            pe.setNitProveedor(this.proveedor.getNit());
            pe.setNombreProveedor(this.proveedor.getNombre());
            pe.setUsuarioProveedor(this.proveedor.getUsuario());
            pe.setPasswordProveedor(this.proveedor.getPassword());
            pe.setUrlAvatarProveedor(this.proveedor.getUrlAvatar());
            pe.setVentasAnuales(this.proveedor.getVentasAnuales());
            pe.setMercadoObjetivo(this.proveedor.getMercadoObjetivo());
            pe.setNivelReputacion(this.proveedor.getNivelReputacion());
            pe.setNumTelefono(this.proveedor.getNumTelefono());
            pe.setUrlAvatarProveedor(this.proveedor.getUrlAvatar());
            pe.setDireccionProveedor(this.proveedor.getDireccion());
            pe.setFechaCreacion(this.proveedor.getFechaCreacion());

            productosEntity.setProveedor(pe);
        }
        if (this.categoria != null) {
            CategoriaEntity ce = new CategoriaEntity();

            ce.setIdCategoria(this.categoria.getIdCategoria());
            ce.setNombreCategoria(this.categoria.getNombreCategoria());
        }

        return productosEntity;
    }

    /**
     * Conversión masiva de ProductoEntity a ProductoDTO
     *
     * @param ProductoList
     * @return Lista ProductoDTO
     */
    public static List<ProductoDTO> toProductosList(List<ProductosEntity> productosList) {
        List<ProductoDTO> listaProductoDTO = new ArrayList<>();
        for (int i = 0; i < productosList.size(); i++) {
            listaProductoDTO.add(new ProductoDTO(productosList.get(i)));
        }
        return listaProductoDTO;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getGarantiaProducto() {
        return garantiaProducto;
    }

    public void setGarantiaProducto(String garantiaProducto) {
        this.garantiaProducto = garantiaProducto;
    }

    public Long getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Long stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

}
