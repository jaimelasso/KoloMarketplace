/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Proveedor
 * @author Jaime Lasso
 */
public class ProveedorDTO {
    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */
    
    private Long id;
    private Long nit;
    private String nombre;
    private String usuario;
    private String password;
    private String urlAvatar;
    private Long ventasAnuales;
    private String mercadoObjetivo;
    private Long nivelReputacion;
    private Long numTelefono;
    private String urlChat;
    private String direccion;
    private Date fechaCreacion;
    
    /**
     * Constructor por defecto
     */
    public ProveedorDTO () {
    }
    
    /**
     * Constructor recibiendo como parámetro la entidad
     * @param proveedorEntity
     */
    public ProveedorDTO (ProveedorEntity proveedorEntity) {
        this.id = proveedorEntity.getIdProveedor();
        this.nit = proveedorEntity.getNitProveedor();
        this.nombre = proveedorEntity.getNombreProveedor();
        this.usuario = proveedorEntity.getUsuarioProveedor();
        this.password = proveedorEntity.getPasswordProveedor();
        this.urlAvatar = proveedorEntity.getUrlAvatarProveedor();
        this.ventasAnuales = proveedorEntity.getVentasAnuales();
        this.mercadoObjetivo = proveedorEntity.getMercadoObjetivo();
        this.nivelReputacion = proveedorEntity.getNivelReputacion();
        this.numTelefono = proveedorEntity.getNumTelefono();
        this.urlChat = proveedorEntity.getUrlChat();
        this.direccion = proveedorEntity.getDireccionProveedor();
        this.fechaCreacion = proveedorEntity.getFechaCreacion();
    }
    
    /**
     * Método para mapear a la entidad los datos capturados en la vista
     * @return objeto de tipo ProveedorEntity
     */
    public ProveedorEntity toEntity() {
        ProveedorEntity proveedor = new ProveedorEntity();
        
        proveedor.setIdProveedor(this.id);
        proveedor.setNitProveedor(this.nit);
        proveedor.setNombreProveedor(this.nombre);
        proveedor.setUsuarioProveedor(this.usuario);
        proveedor.setPasswordProveedor(this.password);
        proveedor.setUrlAvatarProveedor(this.urlAvatar);
        proveedor.setVentasAnuales(this.ventasAnuales);
        proveedor.setMercadoObjetivo(this.mercadoObjetivo);
        proveedor.setNivelReputacion(this.nivelReputacion);
        proveedor.setNumTelefono(this.numTelefono);
        proveedor.setUrlChat(this.urlChat);
        proveedor.setDireccionProveedor(this.direccion);
        proveedor.setFechaCreacion(this.fechaCreacion);
        
        return proveedor;
        
        
    }

    /**
     * Conversión masiva de ProveedorEntity a ProveedorDTO
     * @param proveedorList
     * @return Lista Proveedor DTO
     */
    public static List<ProveedorDTO> toProveedorList(List<ProveedorEntity> proveedorList) {
        List<ProveedorDTO> listaProveedorDTO = new ArrayList<>();
        for (int i = 0; i < proveedorList.size(); i++) {
            listaProveedorDTO.add(new ProveedorDTO(proveedorList.get(i)));
        }
        return listaProveedorDTO;
    }
    
    /**
     * Métodos SET y GET
     */

    public Long getId() {
        return id;
    }

    public Long getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public Long getVentasAnuales() {
        return ventasAnuales;
    }

    public String getMercadoObjetivo() {
        return mercadoObjetivo;
    }

    public Long getNivelReputacion() {
        return nivelReputacion;
    }

    public Long getNumTelefono() {
        return numTelefono;
    }

    public String getUrlChat() {
        return urlChat;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public void setVentasAnuales(Long ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }

    public void setMercadoObjetivo(String mercadoObjetivo) {
        this.mercadoObjetivo = mercadoObjetivo;
    }

    public void setNivelReputacion(Long nivelReputacion) {
        this.nivelReputacion = nivelReputacion;
    }

    public void setNumTelefono(Long numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setUrlChat(String urlChat) {
        this.urlChat = urlChat;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
