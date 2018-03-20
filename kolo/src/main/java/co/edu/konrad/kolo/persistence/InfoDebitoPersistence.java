package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.InfoDebitoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad InfoDebito
 *
 * @author David Cañon
 */
@Stateless
public class InfoDebitoPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla InfoDebito
     *
     * @return Lista de datos de la tabla InfoDebito
     */
    public List<InfoDebitoEntity> findAll() {
        Query todos = em.createQuery("select e from InfoDebitoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla InfoDebito
     *
     * @param id que se desea buscar
     * @return InfoDebito
     */
    public InfoDebitoEntity find(Long id) {
        InfoDebitoEntity InfoDebito = em.find(InfoDebitoEntity.class, id);
        return InfoDebito;
    }

    /**
     * Creacion de un nuevo InfoDebito
     *
     * @param InfoDebito
     * @return nuevo InfoDebito creado
     */
    public InfoDebitoEntity create(InfoDebitoEntity InfoDebito) {
        em.persist(InfoDebito);
        return InfoDebito;
    }

    /**
     * Actualizacion de una tupla de la tabla InfoDebito
     *
     * @param InfoDebitoActualizar
     * @return InfoDebito actualizado
     */
    public InfoDebitoEntity update(InfoDebitoEntity InfoDebitoActualizar) {
        return em.merge(InfoDebitoActualizar);
    }

    /**
     * Elimina una tupla InfoDebito de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        InfoDebitoEntity InfoDebitoDelete = em.find(InfoDebitoEntity.class, id);
        em.remove(InfoDebitoDelete);
    }
}
