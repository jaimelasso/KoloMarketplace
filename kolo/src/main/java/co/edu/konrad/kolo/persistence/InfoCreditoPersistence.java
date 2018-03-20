package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.InfoCreditoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad InfoCredito
 *
 * @author David Cañon
 */
@Stateless
public class InfoCreditoPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla InfoCredito
     *
     * @return Lista de datos de la tabla InfoCredito
     */
    public List<InfoCreditoEntity> findAll() {
        Query todos = em.createQuery("select e from InfoCreditoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla InfoCredito
     *
     * @param id que se desea buscar
     * @return InfoCredito
     */
    public InfoCreditoEntity find(Long id) {
        InfoCreditoEntity InfoCredito = em.find(InfoCreditoEntity.class, id);
        return InfoCredito;
    }

    /**
     * Creacion de un nuevo InfoCredito
     *
     * @param InfoCredito
     * @return nuevo InfoCredito creado
     */
    public InfoCreditoEntity create(InfoCreditoEntity InfoCredito) {
        em.persist(InfoCredito);
        return InfoCredito;
    }

    /**
     * Actualizacion de una tupla de la tabla InfoCredito
     *
     * @param InfoCreditoActualizar
     * @return InfoCredito actualizado
     */
    public InfoCreditoEntity update(InfoCreditoEntity InfoCreditoActualizar) {
        return em.merge(InfoCreditoActualizar);
    }

    /**
     * Elimina una tupla InfoCredito de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        InfoCreditoEntity InfoCreditoDelete = em.find(InfoCreditoEntity.class, id);
        em.remove(InfoCreditoDelete);
    }
}
