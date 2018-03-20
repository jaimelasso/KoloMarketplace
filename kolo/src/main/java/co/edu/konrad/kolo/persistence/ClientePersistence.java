package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.ClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad Cliente
 *
 * @author David Cañon
 */
@Stateless
public class ClientePersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Cliente
     *
     * @return Lista de datos de la tabla Cliente
     */
    public List<ClienteEntity> findAll() {
        Query todos = em.createQuery("select e from ClienteEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla cliente
     *
     * @param id que se desea buscar
     * @return cliente
     */
    public ClienteEntity find(Long id) {
        ClienteEntity cliente = em.find(ClienteEntity.class, id);
        return cliente;
    }

    /**
     * Creacion de un nuevo cliente
     *
     * @param cliente
     * @return nuevo cliente creado
     */
    public ClienteEntity create(ClienteEntity cliente) {
        em.persist(cliente);
        return cliente;
    }

    /**
     * Actualizacion de una tupla de la tabla cliente
     *
     * @param clienteActualizar
     * @return cliente actualizado
     */
    public ClienteEntity update(ClienteEntity clienteActualizar) {
        return em.merge(clienteActualizar);
    }

    /**
     * Elimina una tupla cliente de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        ClienteEntity clienteDelete = em.find(ClienteEntity.class, id);
        em.remove(clienteDelete);
    }
}
