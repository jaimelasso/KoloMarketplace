package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.TipoDocumentoDTO;
import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import co.edu.konrad.kolo.logic.TipoDocumentoLogic;

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
@Path("/TipoDocumento")
public class TipoDocumentoResource {

    @EJB
    private TipoDocumentoLogic tipoDocumentoLogic;

    @GET
    public List<TipoDocumentoDTO> getTipoDocumentoList() {
        List<TipoDocumentoEntity> tipodocumentos = tipoDocumentoLogic.obtenerTipoDocumentos();
        return TipoDocumentoDTO.toTipoDocumentoList(tipodocumentos);
    }

    @Path("{id: \\d+}")
    public TipoDocumentoDTO getTipoDocumento(@PathParam("id") Long id) {
        TipoDocumentoEntity tipodocumento = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if (tipodocumento == null) {
            throw new RuntimeException("El tipo de documento solicitado no existe");
        }
        return new TipoDocumentoDTO(tipodocumento);
    }

    @POST
    public TipoDocumentoDTO createCliente(TipoDocumentoDTO tipoDocumentoDTO) {
        return new TipoDocumentoDTO(tipoDocumentoLogic.crearTipoDocumento(tipoDocumentoDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public TipoDocumentoDTO updateTipoDocumento(@PathParam("id") Long id, TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumentoEntity entity = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if (entity == null) {
            throw new RuntimeException("El tipo de documento solicitado no existe");
        }
        return new TipoDocumentoDTO(tipoDocumentoLogic.actualizarTipoDocumento(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoDocumento(@PathParam("id") Long id) {
        TipoDocumentoEntity entity = tipoDocumentoLogic.obtenerTipoDocumento(id);
        if (entity == null) {
            throw new RuntimeException("El tipo de documento solicitado no existe");
        }
        tipoDocumentoLogic.eliminarTipoDocumento(id);
    }
}
