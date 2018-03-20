package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.CarritoComprasEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad CarritoCompras
 *
 * @author David Cañon
 */
@Stateless
public class CarritoComprasPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla CarritoCompras
     *
     * @return Lista de datos de la tabla CarritoCompras
     */
    public List<CarritoComprasEntity> findAll() {
        Query todos = em.createQuery("select e from carritoComprasEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla CarritoCompras
     *
     * @param id que se desea buscar
     * @return carrito
     */
    public CarritoComprasEntity find(Long id) {
        CarritoComprasEntity carrito = em.find(CarritoComprasEntity.class, id);
        return carrito;
    }

    /**
     * Creacion de un nuevo CarritoCompras
     *
     * @param CarritoCompras
     * @return nuevo CarritoCompras creado
     */
    public CarritoComprasEntity create(CarritoComprasEntity CarritoCompras) {
        em.persist(CarritoCompras);
        return CarritoCompras;
    }

    /**
     * Actualizacion de una tupla de la tabla CarritoCompras
     *
     * @param CarritoComprasActualizar
     * @return CarritoCompras actualizado
     */
    public CarritoComprasEntity update(CarritoComprasEntity CarritoComprasActualizar) {
        return em.merge(CarritoComprasActualizar);
    }

    /**
     * Elimina una tupla CarritoCompras de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        CarritoComprasEntity CarritoComprasDelete = em.find(CarritoComprasEntity.class, id);
        em.remove(CarritoComprasDelete);
    }
}
