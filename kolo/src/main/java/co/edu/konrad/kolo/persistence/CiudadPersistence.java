package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.CiudadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad Ciudad
 *
 * @author David Cañon
 */
@Stateless
public class CiudadPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Ciudad
     *
     * @return Lista de datos de la tabla Ciudad
     */
    public List<CiudadEntity> findAll() {
        Query todos = em.createQuery("select e from CiudadEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla ciudad
     *
     * @param id que se desea buscar
     * @return ciudad
     */
    public CiudadEntity find(Long id) {
        CiudadEntity ciudad = em.find(CiudadEntity.class, id);
        return ciudad;
    }

    /**
     * Creacion de un nuevo ciudad
     *
     * @param ciudad
     * @return nuevo ciudad creado
     */
    public CiudadEntity create(CiudadEntity ciudad) {
        em.persist(ciudad);
        return ciudad;
    }

    /**
     * Actualizacion de una tupla de la tabla ciudad
     *
     * @param ciudadActualizar
     * @return ciudad actualizado
     */
    public CiudadEntity update(CiudadEntity ciudadActualizar) {
        return em.merge(ciudadActualizar);
    }

    /**
     * Elimina una tupla ciudad de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        CiudadEntity ciudadDelete = em.find(CiudadEntity.class, id);
        em.remove(ciudadDelete);
    }
}
