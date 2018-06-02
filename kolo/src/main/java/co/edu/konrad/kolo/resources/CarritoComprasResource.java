/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.CarritoComprasDTO;
import co.edu.konrad.kolo.entities.CarritoComprasEntity;
import co.edu.konrad.kolo.logic.CarritoComprasLogic;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
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
@Path("/CarritoCompras")
public class CarritoComprasResource {

    @EJB
    private CarritoComprasLogic carritoComprasLogic;

    @GET
    public List<CarritoComprasDTO> getCarritoComprasList() {
        List<CarritoComprasEntity> carritosCompra = carritoComprasLogic.obtenerCarritoComprass();
        return CarritoComprasDTO.toCarritoComprasList(carritosCompra);
    }

    @GET
    @Path("{id: \\d+}")
    public CarritoComprasDTO getCarritoCompras(@PathParam("id") Long id) {
        CarritoComprasEntity carritoCompras = carritoComprasLogic.obtenerCarritoCompras(id);
        if (carritoCompras == null) {
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new CarritoComprasDTO(carritoCompras);
    }

    @POST
    public CarritoComprasDTO createCarritoCompras(CarritoComprasDTO carritoComprasDTO) {
        return new CarritoComprasDTO(carritoComprasLogic.crearCarritoCompras(carritoComprasDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public CarritoComprasDTO updateCarritoCompras(@PathParam("id") Long id, CarritoComprasDTO carritoComprasDTO) {
        CarritoComprasEntity entity = carritoComprasLogic.obtenerCarritoCompras(id);
        if (entity == null) {
            throw new RuntimeException("El carrito de compras solicitado no existe");
        }
        return new CarritoComprasDTO(carritoComprasLogic.actualizarCarritoCompras(id, carritoComprasDTO.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCarritoCompras(@PathParam("id") Long id) {
        CarritoComprasEntity entity = carritoComprasLogic.obtenerCarritoCompras(id);
        if (entity == null) {
            throw new RuntimeException("El carrito de compras solicitado no existe");
        }
        carritoComprasLogic.eliminarCarritoCompras(id);
    }

}
