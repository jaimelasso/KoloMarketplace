package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.FacturaDTO;
import co.edu.konrad.kolo.entities.FacturaEntity;
import co.edu.konrad.kolo.logic.FacturaLogic;

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

/**
 *
 * @author marti
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Cliente")
public class FacturaResource {
    @EJB
    private FacturaLogic facturaLogic;
    
    @GET
    public List<FacturaDTO> getFacturaList(){
        List<FacturaEntity> facturas = facturaLogic.obtenerFacturas();
        return FacturaDTO.toFacturaList(facturas);
    }
}
