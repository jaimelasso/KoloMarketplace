package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.ClienteDTO;
import co.edu.konrad.kolo.entities.ClienteEntity;
//import co.edu.konrad.kolo.logic.ClienteLogic;

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
    @Path("{id: \\d+}")
    public ClienteDTO getCliente(@PathParam("id") Long id){
        ClienteEntity cliente = clienteLogic.obtenerCliente(id);
        if(cliente == null){
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new ClienteDTO(cliente);
    }
}
