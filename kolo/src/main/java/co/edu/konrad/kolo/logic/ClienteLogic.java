/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.logic;

import co.edu.konrad.kolo.entities.ClienteEntity;
import co.edu.konrad.kolo.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase que contiene la logica del Cliente
 * @author David C.
 */
@Stateless
public class ClienteLogic {
    /**
     * Inyección del persistence de cliente
     */
    @Inject 
    private ClientePersistence clientePersistence;
    
    /**
     * Obtener todos los clientes
     * @return Lista Cliente
     */
    public List<ClienteEntity> obtenerClientes(){
        List<ClienteEntity> clientes = clientePersistence.findAll();
        return clientes;
    }
    
    /**
     * Obtener un cliente a partir del id
     * @param id
     * @return cliente encontrado
     */
    public ClienteEntity obtenerCliente(Long id){
        ClienteEntity cliente = clientePersistence.find(id);
        if(cliente == null){
            throw new IllegalArgumentException("Cliente solicitado no existe.");
        }
        return cliente;
    }
    
    /**
     * Crear un nuevo cliente
     * @param cliEntity
     * @return cliEntity
     */
    public ClienteEntity crearCliente(ClienteEntity cliEntity){
        clientePersistence.create(cliEntity);
        return cliEntity;
    }
    
    /**
     * Actualiza un cliente - Pilas cn el parametro id O-O
     * @param cliEntity
     * @param id
     * @return cliente actualizado
     */
    public ClienteEntity actualizarCliente(Long id, ClienteEntity cliEntity){
        ClienteEntity cliente = clientePersistence.update(cliEntity);
        return cliente;
    }
    
    /**
     * Elimina un cliente
     * @param id 
     */
    public void eliminarCliente(Long id){
        clientePersistence.delete(id);
    }
}
