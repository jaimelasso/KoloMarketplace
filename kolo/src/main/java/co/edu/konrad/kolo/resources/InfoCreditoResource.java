/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.InfoCreditoDTO;
import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import co.edu.konrad.kolo.logic.InfoCreditoLogic;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author martin
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/InfoCredito")
public class InfoCreditoResource {
    @EJB
    private InfoCreditoLogic infoCreditoLogic;

    @GET
    public List<InfoCreditoDTO> getInfoCreditoList() {
        List<InfoCreditoEntity> carritosCompra = infoCreditoLogic.obtenerInfoCreditos();
        return InfoCreditoDTO.toInfoCreditoList(carritosCompra);
    }

    @Path("{id: \\d+}")
    public InfoCreditoDTO getInfoCredito(@PathParam("id") Long id) {
        InfoCreditoEntity infoCredito = infoCreditoLogic.obtenerInfoCredito(id);
        if (infoCredito == null) {
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new InfoCreditoDTO(infoCredito);
    }

    @POST
    public InfoCreditoDTO createInfoCredito(InfoCreditoDTO infoCreditoDTO) {
        return new InfoCreditoDTO(infoCreditoLogic.crearInfoCredito(infoCreditoDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public InfoCreditoDTO updateInfoCredito(@PathParam("id") Long id, InfoCreditoDTO infoCreditoDTO) {
        InfoCreditoEntity entity = infoCreditoLogic.obtenerInfoCredito(id);
        if (entity == null) {
            throw new RuntimeException("El carrito de compras solicitado no existe");
        }
        return new InfoCreditoDTO(infoCreditoLogic.actualizarInfoCredito(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteInfoCredito(@PathParam("id") Long id) {
        InfoCreditoEntity entity = infoCreditoLogic.obtenerInfoCredito(id);
        if (entity == null) {
            throw new RuntimeException("El carrito de compras solicitado no existe");
        }
        infoCreditoLogic.eliminarInfoCredito(id);
    }

    
}
