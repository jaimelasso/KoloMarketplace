package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.PaisEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad Pais
 *
 * @author David Cañon
 */
@Stateless
public class PaisPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Pais
     *
     * @return Lista de datos de la tabla Pais
     */
    public List<PaisEntity> findAll() {
        Query todos = em.createQuery("select e from PaisEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Pais
     *
     * @param id que se desea buscar
     * @return Pais
     */
    public PaisEntity find(Long id) {
        PaisEntity pais = em.find(PaisEntity.class, id);
        return pais;
    }

    /**
     * Creacion de un nuevo Pais
     *
     * @param Pais
     * @return nuevo Pais creado
     */
    public PaisEntity create(PaisEntity pais) {
        em.persist(pais);
        return pais;
    }

    /**
     * Actualizacion de una tupla de la tabla Pais
     *
     * @param PaisActualizar
     * @return Pais actualizado
     */
    public PaisEntity update(PaisEntity paisActualizar) {
        return em.merge(paisActualizar);
    }

    /**
     * Elimina una tupla Pais de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        PaisEntity paisDelete = em.find(PaisEntity.class, id);
        em.remove(paisDelete);
    }
}
