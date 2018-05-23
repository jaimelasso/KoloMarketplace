package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.CiudadDTO;
import co.edu.konrad.kolo.entities.CiudadEntity;
import co.edu.konrad.kolo.logic.CiudadLogic;

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
@Path("/Ciudad")
public class CiudadResource {
    
    @EJB
    private CiudadLogic ciudadLogic;
    
    @GET
    public List<CiudadDTO> getCiudadList (){
        List<CiudadEntity> ciudades = ciudadLogic.obtenerCiudads();
        return CiudadDTO.toCiudadList(ciudades);
    }
    
    @Path("{id: \\d+}")
    public CiudadDTO getCiudad(@PathParam("id") Long id){
        CiudadEntity ciudad = ciudadLogic.obtenerCiudad(id);
        if(ciudad == null){
            throw new RuntimeException("La ciudad solicitada no existe");
        }
        return new CiudadDTO(ciudad);
    }
    
    @POST
    public CiudadDTO createCiudad(CiudadDTO ciudadDTO){
        return new CiudadDTO(ciudadLogic.crearCiudad(ciudadDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad (@PathParam("id") Long id, CiudadDTO ciudadDTO){
        CiudadEntity entity = ciudadLogic.obtenerCiudad(id);
        if(entity == null){
            throw new RuntimeException("La ciudad solicitada no existe");
        }
        return new CiudadDTO(ciudadLogic.actualizarCiudad(id, entity));
    }
    
    @DELETE
    @Path("{ciudadId: \\d+}")
    public void deleteCiudad(@PathParam("ciudadId") Long id) {
        CiudadEntity entity = ciudadLogic.obtenerCiudad(id);
        if (entity == null) {
            throw new RuntimeException("La ciudada solicitada no existe");
        }
        ciudadLogic.eliminarCiudad(id);
    }
}
