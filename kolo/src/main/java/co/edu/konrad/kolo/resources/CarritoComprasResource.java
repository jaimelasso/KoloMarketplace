/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.resources;

import co.edu.konrad.kolo.dto.CarritoComprasDTO;
import co.edu.konrad.kolo.entities.CarritoComprasEntity;

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
