package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.ClienteDTO;
import co.edu.konrad.kolo.entities.ClienteEntity;
import co.edu.konrad.kolo.logic.ClienteLogic;

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
@Path("/Cliente")
public class ClienteResource {
    
    @EJB
    private ClienteLogic clienteLogic;
    
    @GET
    public List<ClienteDTO> getEstudianteList() {
        List<ClienteEntity> clientes = clienteLogic.obtenerClientes();
        return ClienteDTO.toClienteList(clientes);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ClienteDTO getCliente(@PathParam("id") Long id) {
        ClienteEntity cliente = clienteLogic.obtenerCliente(id);
        if (cliente == null) {
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new ClienteDTO(cliente);
    }
    
    @POST
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        return new ClienteDTO(clienteLogic.crearCliente(clienteDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ClienteDTO updateCliente(@PathParam("id") Long id, ClienteDTO clienteDTO) {
        ClienteEntity entity = clienteLogic.obtenerCliente(id);
        if (entity == null) {
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new ClienteDTO(clienteLogic.actualizarCliente(id, entity));
    }
    
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("clienteId") Long id) {
        ClienteEntity entity = clienteLogic.obtenerCliente(id);
        if (entity == null) {
            throw new RuntimeException("El cliente solicitado no existe");
        }
        clienteLogic.eliminarCliente(id);
    }
}
