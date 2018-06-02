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
    @EJB
    private CategoriaLogic categoriaLogic;

    @GET
    public List<CategoriaDTO> getCategoriaList() {
        List<CategoriaEntity> categoria = categoriaLogic.obtenerCategorias();
        return CategoriaDTO.toCategoriaList(categoria);
    }

    @GET
    @Path("{id: \\d+}")
    public CategoriaDTO getCategoria(@PathParam("id") Long id) {
        CategoriaEntity categoria = categoriaLogic.obtenerCategoria(id);
        if (categoria == null) {
            throw new RuntimeException("La categoria no existe");
        }
        return new CategoriaDTO(categoria);
    }

    @POST
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        return new CategoriaDTO(categoriaLogic.crearCategoria(categoriaDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public CategoriaDTO updateCategoria(@PathParam("id") Long id, CategoriaDTO categoriaDTO) {
        CategoriaEntity entity = categoriaLogic.obtenerCategoria(id);
        if (entity == null) {
            throw new RuntimeException("la categoria no existe");
        }
        return new CategoriaDTO(categoriaLogic.actualizarCategoria(id, categoriaDTO.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCarritoCompras(@PathParam("id") Long id) {
        CategoriaEntity entity = categoriaLogic.obtenerCategoria(id);
        if (entity == null) {
            throw new RuntimeException("la categoria no existe");
        }
        categoriaLogic.eliminarCategoria(id);
    }

}
