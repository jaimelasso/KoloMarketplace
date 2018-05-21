/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

import co.edu.konrad.kolo.entities.CiudadEntity;
import co.edu.konrad.kolo.entities.ClienteEntity;
import co.edu.konrad.kolo.entities.PaisEntity;
import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la Entidad Cliente
 *
 * @author Jaime Lasso
 */
public class ClienteDTO {

    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */

    private Long idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private TipoDocumentoDTO tipoDocumento;
    private Long numDocumento;
    private Date fechaNacimiento;
    private String direccionCliente;
    private CiudadDTO ciudad;
    private PaisDTO pais;
    private Long telefonoCliente;
    private String emailCliente;
    private String usuarioCliente;
    private String passwordCliente;
    private String urlAvatar;
    private Date fechaCreacion;

    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
    }

    /**
     * Constructor recibiendo como parámetro la entidad
     *
     * @param clienteEntity
     */
    public ClienteDTO(ClienteEntity clienteEntity) {
        this.idCliente = clienteEntity.getIdCliente();
        this.nombreCliente = clienteEntity.getNombreCliente();
        this.apellidoCliente = clienteEntity.getApellidoCliente();

        if (clienteEntity.getTipoDocumento() != null) {
            TipoDocumentoEntity tde = new TipoDocumentoEntity();

            tde.setIdTipoDocumento(clienteEntity.getTipoDocumento().getIdTipoDocumento());
            tde.setTipoDocumento(clienteEntity.getTipoDocumento().getTipoDocumento());

            this.tipoDocumento = new TipoDocumentoDTO(tde);
        }

        this.numDocumento = clienteEntity.getNumDocumento();
        this.fechaNacimiento = clienteEntity.getFechaNacimiento();
        this.direccionCliente = clienteEntity.getDireccionCliente();

        if (clienteEntity.getCiudad() != null) {
            CiudadEntity ce = new CiudadEntity();

            ce.setIdCiudad(clienteEntity.getCiudad().getIdCiudad());
            ce.setNombreCiudad(clienteEntity.getCiudad().getNombreCiudad());

            this.ciudad = new CiudadDTO(ce);
        }

        if (clienteEntity.getPais() != null) {
            PaisEntity pe = new PaisEntity();

            pe.setIdPais(clienteEntity.getPais().getIdPais());

            pe.setNombrePais(clienteEntity.getPais().getNombrePais());

            this.pais = new PaisDTO(pe);
        }

        this.telefonoCliente = clienteEntity.getTelefonoCliente();
        this.emailCliente = clienteEntity.getEmailCliente();
        this.usuarioCliente = clienteEntity.getUsuarioCliente();
        this.passwordCliente = clienteEntity.getPasswordCliente();
        this.urlAvatar = clienteEntity.getUrlAvatar();
        this.fechaCreacion = clienteEntity.getFechaCreacion();
    }

    /**
     * Método para mapear a la entidad los datos capturados en la vista
     *
     * @return objeto de tipo ClienteEntity
     */
    public ClienteEntity toEntity() {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setIdCliente(this.idCliente);
        clienteEntity.setNombreCliente(this.nombreCliente);
        clienteEntity.setApellidoCliente(this.apellidoCliente);

        if (this.tipoDocumento != null) {
            TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();

            tipoDocumento.setIdTipoDocumento(this.tipoDocumento.getIdTipoDocumento());
            tipoDocumento.setTipoDocumento(this.tipoDocumento.getTipoDocumento());
        }

        clienteEntity.setNumDocumento(this.numDocumento);
        clienteEntity.setFechaNacimiento(this.fechaNacimiento);
        clienteEntity.setDireccionCliente(this.direccionCliente);

        if (this.ciudad != null) {
            CiudadEntity ciudad = new CiudadEntity();

            ciudad.setIdCiudad(this.ciudad.getIdCiudad());
            ciudad.setNombreCiudad(this.ciudad.getNombreCiudad());
        }

        if (this.pais != null) {
            PaisEntity pais = new PaisEntity();

            pais.setIdPais(this.pais.getIdPais());
            pais.setNombrePais(this.pais.getNombrePais());
        }

        clienteEntity.setTelefonoCliente(this.telefonoCliente);
        clienteEntity.setEmailCliente(this.emailCliente);
        clienteEntity.setUsuarioCliente(this.usuarioCliente);
        clienteEntity.setPasswordCliente(this.passwordCliente);
        clienteEntity.setUrlAvatar(this.urlAvatar);
        clienteEntity.setFechaCreacion(this.fechaCreacion);

        return clienteEntity;
    }

    /**
     * Conversión masiva de EstudianteEntity a EstudianteDTO
     *
     * @param clienteList
     * @return Lista Estudiante DTO
     */
    public static List<ClienteDTO> toClienteList(List<ClienteEntity> clienteList) {
        List<ClienteDTO> listaEstudianteDTO = new ArrayList<>();
        for (ClienteEntity clienteList1 : clienteList) {
            listaEstudianteDTO.add(new ClienteDTO(clienteList1));
        }
        return listaEstudianteDTO;
    }

    /**
     * Métodos SET y GET
     * @return 
     */
    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public Long getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public void setTelefonoCliente(Long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
