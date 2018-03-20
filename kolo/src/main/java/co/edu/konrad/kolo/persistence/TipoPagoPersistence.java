package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.TipoPagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad tipoPago
 *
 * @author David Cañon
 */
@Stateless
public class TipoPagoPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla tipoPago
     *
     * @return Lista de datos de la tabla tipoPago
     */
    public List<TipoPagoEntity> findAll() {
        Query todos = em.createQuery("select e from TipoPagoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla tipoPago
     *
     * @param id que se desea buscar
     * @return tipoPago
     */
    public TipoPagoEntity find(Long id) {
        TipoPagoEntity tipoPago = em.find(TipoPagoEntity.class, id);
        return tipoPago;
    }

    /**
     * Creacion de un nuevo tipoPago
     *
     * @param tipoPago
     * @return nuevo tipoPago creado
     */
    public TipoPagoEntity create(TipoPagoEntity tipoPago) {
        em.persist(tipoPago);
        return tipoPago;
    }

    /**
     * Actualizacion de una tupla de la tabla tipoPago
     *
     * @param tipoPagoActualizar
     * @return tipoPago actualizado
     */
    public TipoPagoEntity update(TipoPagoEntity tipoPagoActualizar) {
        return em.merge(tipoPagoActualizar);
    }

    /**
     * Elimina una tupla tipoPago de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        TipoPagoEntity tipoPagoDelete = em.find(TipoPagoEntity.class, id);
        em.remove(tipoPagoDelete);
    }
}
