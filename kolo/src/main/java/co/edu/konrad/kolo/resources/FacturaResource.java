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
@Path("/Factura")
public class FacturaResource {
    @EJB
    private FacturaLogic facturaLogic;

    @GET
    public List<FacturaDTO> getFacturaList() {
        List<FacturaEntity> factura = facturaLogic.obtenerFacturas();
        return FacturaDTO.toFacturaList(factura);
    }

    @GET
    @Path("{id: \\d+}")
    public FacturaDTO getFactura(@PathParam("id") Long id) {
        FacturaEntity factura = facturaLogic.obtenerFactura(id);
        if (factura == null) {
            throw new RuntimeException("La categoria no existe");
        }
        return new FacturaDTO(factura);
    }

    @POST
    public FacturaDTO createFactura(FacturaDTO facturaDTO) {
        return new FacturaDTO(facturaLogic.crearFactura(facturaDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public FacturaDTO updateFactura(@PathParam("id") Long id, FacturaDTO facturaDTO) {
        FacturaEntity entity = facturaLogic.obtenerFactura(id);
        if (entity == null) {
            throw new RuntimeException("la categoria no existe");
        }
        return new FacturaDTO(facturaLogic.actualizarFactura(id, facturaDTO.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteFactura(@PathParam("id") Long id) {
        FacturaEntity entity = facturaLogic.obtenerFactura(id);
        if (entity == null) {
            throw new RuntimeException("la categoria no existe");
        }
        facturaLogic.eliminarFactura(id);
    }
}
