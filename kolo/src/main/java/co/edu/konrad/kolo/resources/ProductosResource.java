package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.ProductoDTO;
import co.edu.konrad.kolo.entities.ProductosEntity;
import co.edu.konrad.kolo.logic.ProductosLogic;

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
@Path("/Productos")
public class ProductosResource {

    @EJB
    private ProductosLogic productosLogic;

    @GET
    public List<ProductoDTO> getProductosList() {
        List<ProductosEntity> productos = productosLogic.obtenerProductoss();
        return ProductoDTO.toProductosList(productos);
    }

    @GET
    @Path("{id: \\d+}")
    public ProductoDTO getProducto(@PathParam("id") Long id) {
        ProductosEntity productos = productosLogic.obtenerProductos(id);
        if (productos == null) {
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ProductoDTO(productos);
    }

    @POST
    public ProductoDTO createProducto(ProductoDTO productosDTO) {
        return new ProductoDTO(productosLogic.crearProductos(productosDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public ProductoDTO updateProducto(@PathParam("id") Long id, ProductoDTO productoDTO) {
        ProductosEntity entity = productosLogic.obtenerProductos(id);
        if (entity == null) {
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ProductoDTO(productosLogic.actualizarProductos(id, productoDTO.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteProductos(@PathParam("id") Long id) {
        ProductosEntity entity = productosLogic.obtenerProductos(id);
        if (entity == null) {
            throw new RuntimeException("El producto solicitado no existe");
        }
        productosLogic.eliminarProductos(id);
    }
}
