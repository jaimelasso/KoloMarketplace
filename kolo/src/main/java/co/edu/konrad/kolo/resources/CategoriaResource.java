package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.CategoriaDTO;
import co.edu.konrad.kolo.entities.CategoriaEntity;
import co.edu.konrad.kolo.logic.CategoriaLogic;

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
 * @author martin
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Categoria")
public class CategoriaResource {
    
}
