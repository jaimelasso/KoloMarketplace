package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.InfoCreditoDTO;
import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import co.edu.konrad.kolo.logic.InfoCreditoLogic;

import java.util.List;
import javax.ejb.EJB;
//import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import org.eclipse.persistence.internal.jpa.parsing.EscapeNode;

/**
 *
 * @author marti
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/InfoCredito")
public class InfoDebitoResource {
    
    @EJB
    private InfoCreditoLogic infocreditoLogic;
    
    @GET
    public List<InfoCreditoDTO> getInfoCreditoList() {
        List<InfoCreditoEntity> infocredito = infocreditoLogic.obtenerInfoCreditos();
        return InfoCreditoDTO.toInfoCreditoList(infocredito);
    }
    
    @Path("{id: \\d+}")
    public InfoCreditoDTO getInfoCredito(@PathParam("id") Long id) {
        InfoCreditoEntity infocredito = infocreditoLogic.obtenerInfoCredito(id);
        if (infocredito == null) {
            throw new RuntimeException("El crédito solicitado no existe");
        }
        return new InfoCreditoDTO(infocredito);
    }
    
    @POST
    public InfoCreditoDTO createInfoCredito(InfoCreditoDTO infoCreditoDTO) {
        return new InfoCreditoDTO(infocreditoLogic.crearInfoCredito(infoCreditoDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public InfoCreditoDTO updateInfoCredito(@PathParam("id") Long id, InfoCreditoDTO infoCreditoDTO) {
        InfoCreditoEntity entity = infocreditoLogic.obtenerInfoCredito(id);
        if (entity == null) {
            throw new RuntimeException("El credito solicitado no existe");
        }
        return new InfoCreditoDTO(infocreditoLogic.actualizarInfoCredito(id, entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteInfoCredito(@PathParam("id") Long id) {
        InfoCreditoEntity entity = infocreditoLogic.obtenerInfoCredito(id);
        if (entity == null) {
            throw new RuntimeException("El credito solicitado no existe");
        }
        infocreditoLogic.eliminarInfoCredito(id);
    }
    
}
