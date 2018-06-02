package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.InfoDebitoDTO;
import co.edu.konrad.kolo.entities.InfoDebitoEntity;
import co.edu.konrad.kolo.logic.InfoDebitoLogic;

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
@Path("/InfoDebito")
public class InfoDebitoResource {
    
    @EJB
    private InfoDebitoLogic infocreditoLogic;
    
    @GET
    public List<InfoDebitoDTO> getInfoDebitoList() {
        List<InfoDebitoEntity> infocredito = infocreditoLogic.obtenerInfoDebitos();
        return InfoDebitoDTO.toInfoDebitoList(infocredito);
    }
    
    @GET
    @Path("{id: \\d+}")
    public InfoDebitoDTO getInfoDebito(@PathParam("id") Long id) {
        InfoDebitoEntity infocredito = infocreditoLogic.obtenerInfoDebito(id);
        if (infocredito == null) {
            throw new RuntimeException("El crédito solicitado no existe");
        }
        return new InfoDebitoDTO(infocredito);
    }
    
    @POST
    public InfoDebitoDTO createInfoDebito(InfoDebitoDTO iinfoDebitoDTO) {
        return new InfoDebitoDTO(infocreditoLogic.crearInfoDebito(iinfoDebitoDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public InfoDebitoDTO updateInfoDebito(@PathParam("id") Long id, InfoDebitoDTO infoDebitoDTO) {
        InfoDebitoEntity entity = infocreditoLogic.obtenerInfoDebito(id);
        if (entity == null) {
            throw new RuntimeException("El credito solicitado no existe");
        }
        return new InfoDebitoDTO(infocreditoLogic.actualizarInfoDebito(id, infoDebitoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteInfoDebito(@PathParam("id") Long id) {
        InfoDebitoEntity entity = infocreditoLogic.obtenerInfoDebito(id);
        if (entity == null) {
            throw new RuntimeException("El credito solicitado no existe");
        }
        infocreditoLogic.eliminarInfoDebito(id);
    }
    
}
