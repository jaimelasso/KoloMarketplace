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
public class CarritoComprasResource {
    
    @EJB
    private CarritoComprasLogic carritoComprasLogic;
    
    @GET
    @Path("{id: \\d+}")
    public CarritoComprasDTO getCarritoCompras(@PathParam("id") Long id){
        CarritoComprasEntity carrito = carritoComprasLogic.obtenerCarritoCompras(id);
        if(carrito == null){
            throw new RuntimeException("El cliente solicitado no existe");
        }
        return new CarritoComprasDTO(carrito);
    }
    
}
