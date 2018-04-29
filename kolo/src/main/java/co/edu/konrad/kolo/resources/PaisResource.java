package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.PaisDTO;
import co.edu.konrad.kolo.entities.PaisEntity;
import co.edu.konrad.kolo.logic.PaisLogic;

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
@Path("/Pais")
public class PaisResource {
    
    @EJB
    private PaisLogic paisLogic;
    
    @GET
    public List<PaisDTO> getPaisList() {
        List<PaisEntity> paises = paisLogic.obtenerPaiss();
        return PaisDTO.toPaisList(paises);
    }
    
    @Path("{id: \\d+}")
    public PaisDTO getPais(@PathParam("id") Long id) {
        PaisEntity pais = paisLogic.obtenerPais(id);
        if (pais == null) {
            throw new RuntimeException("El pais solicitado no existe");
        }
        return new PaisDTO(pais);
    }
    
    @POST
    public PaisDTO createPais(PaisDTO paisDTO) {
        return new PaisDTO(paisLogic.crearPais(paisDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public PaisDTO updatePais(@PathParam("id") Long id, PaisDTO paisDTO) {
        PaisEntity entity = paisLogic.obtenerPais(id);
        if (entity == null) {
            throw new RuntimeException("El pais solicitado no existe");
        }
        return new PaisDTO(paisLogic.actualizarPais(id, entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deletePais(@PathParam("id") Long id) {
        PaisEntity entity = paisLogic.obtenerPais(id);
        if (entity == null) {
            throw new RuntimeException("El pais solicitado no existe");
        }
        paisLogic.eliminarPais(id);
    }
}
