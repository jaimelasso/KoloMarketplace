package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.CategoriaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad Categoria
 *
 * @author David Cañon
 */
@Stateless
public class CategoriaPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla CarritoCompras
     *
     * @return Lista de datos de la tabla CarritoCompras
     */
    public List<CategoriaEntity> findAll() {
        Query todos = em.createQuery("select e from CategoriaEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla Categoria
     *
     * @param id que se desea buscar
     * @return categoria
     */
    public CategoriaEntity find(Long id) {
        CategoriaEntity categoria = em.find(CategoriaEntity.class, id);
        return categoria;
    }

    /**
     * Creacion de un nuevo Categoria
     *
     * @param categoria
     * @return nuevo Categoria creado
     */
    public CategoriaEntity create(CategoriaEntity categoria) {
        em.persist(categoria);
        return categoria;
    }

    /**
     * Actualizacion de una tupla de la tabla Categoria
     *
     * @param CategoriaActualizar
     * @return Categoria actualizado
     */
    public CategoriaEntity update(CategoriaEntity CategoriaActualizar) {
        return em.merge(CategoriaActualizar);
    }

    /**
     * Elimina una tupla Categoria de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        CategoriaEntity CategoriaDelete = em.find(CategoriaEntity.class, id);
        em.remove(CategoriaDelete);
    }
}
