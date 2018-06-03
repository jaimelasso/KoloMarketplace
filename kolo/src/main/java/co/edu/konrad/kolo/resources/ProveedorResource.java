package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.ProveedorDTO;
import co.edu.konrad.kolo.entities.ProveedorEntity;
import co.edu.konrad.kolo.logic.ProveedorLogic;

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
@Path("/Proveedor")
public class ProveedorResource {

    @EJB
    private ProveedorLogic proveedorLogic;

    @GET//correcto
    public List<ProveedorDTO> getProveedorList() {
        List<ProveedorEntity> proveedores = proveedorLogic.obtenerProveedors();
        return ProveedorDTO.toProveedorList(proveedores);
    }
    
    @GET//correcto
    @Path("{id: \\d+}")
    public ProveedorDTO getProveedor(@PathParam("id") Long id) {
        ProveedorEntity proveedor = proveedorLogic.obtenerProveedor(id);
        if (proveedor == null) {
            throw new RuntimeException("El proveedor solicitado no existe");
        }
        return new ProveedorDTO(proveedor);
    }
    
    @PUT//correcto
    @Path("{id: \\d+}")
    public ProveedorDTO updateProveedor(@PathParam("id") Long id, ProveedorDTO proveedorDTO) {
        ProveedorEntity entity = proveedorLogic.obtenerProveedor(id);
        if (entity == null) {
            throw new RuntimeException("El proveedor solicitado no existe");
        }
        return new ProveedorDTO(proveedorLogic.actualizarProveedor(id, proveedorDTO.toEntity()));
    }
    
    

    @POST//correcto
    public ProveedorDTO createProveedor(ProveedorDTO proveedorDTO) {
        return new ProveedorDTO(proveedorLogic.crearProveedor(proveedorDTO.toEntity()));
    }

    

    @DELETE
    @Path("{id: \\d+}")
    public void deleteProveedor(@PathParam("id") Long id) {
        ProveedorEntity entity = proveedorLogic.obtenerProveedor(id);
        if (entity == null) {
            throw new RuntimeException("El proveedor solicitado no existe");
        }
        proveedorLogic.eliminarProveedor(id);
    }
}
