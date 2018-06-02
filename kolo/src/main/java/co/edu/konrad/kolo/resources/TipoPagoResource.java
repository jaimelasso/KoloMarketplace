package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.TipoPagoDTO;
import co.edu.konrad.kolo.entities.TipoPagoEntity;
import co.edu.konrad.kolo.logic.TipoPagoLogic;

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
@Path("/TipoPago")
public class TipoPagoResource {

    @EJB
    private TipoPagoLogic tipoPagoLogic;

    @GET
    public List<TipoPagoDTO> getTipoPagoList() {
        List<TipoPagoEntity> tiposPago = tipoPagoLogic.obtenerTipoPagos();
        return TipoPagoDTO.toTipoPagoList(tiposPago);
    }

    @GET
    @Path("{id: \\d+}")
    public TipoPagoDTO getTipoPago(@PathParam("id") Long id) {
        TipoPagoEntity tipoPago = tipoPagoLogic.obtenerTipoPago(id);
        if (tipoPago == null) {
            throw new RuntimeException("El tipo de pago solicitado no existe");
        }
        return new TipoPagoDTO(tipoPago);
    }

    @POST
    public TipoPagoDTO createTipoPago(TipoPagoDTO tipoPagoDTO) {
        return new TipoPagoDTO(tipoPagoLogic.crearTipoPago(tipoPagoDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public TipoPagoDTO updateTipoPago(@PathParam("id") Long id, TipoPagoDTO tipoPagoDTO) {
        TipoPagoEntity entity = tipoPagoLogic.obtenerTipoPago(id);
        if (entity == null) {
            throw new RuntimeException("El tipo de pago solicitado no existe");
        }
        return new TipoPagoDTO(tipoPagoLogic.actualizarTipoPago(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoPago(@PathParam("id") Long id) {
        TipoPagoEntity entity = tipoPagoLogic.obtenerTipoPago(id);
        if (entity == null) {
            throw new RuntimeException("El tipo de pago solicitado no existe");
        }
        tipoPagoLogic.eliminarTipoPago(id);
    }
}
