package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.ProductosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad productos
 *
 * @author David Cañon
 */
@Stateless
public class ProductosPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla productos
     *
     * @return Lista de datos de la tabla productos
     */
    public List<ProductosEntity> findAll() {
        Query todos = em.createQuery("select e from ProductosEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla productos
     *
     * @param id que se desea buscar
     * @return productos
     */
    public ProductosEntity find(Long id) {
        ProductosEntity productos = em.find(ProductosEntity.class, id);
        return productos;
    }

    /**
     * Creacion de un nuevo productos
     *
     * @param productos
     * @return nuevo productos creado
     */
    public ProductosEntity create(ProductosEntity productos) {
        em.persist(productos);
        return productos;
    }

    /**
     * Actualizacion de una tupla de la tabla productos
     *
     * @param productosActualizar
     * @return productos actualizado
     */
    public ProductosEntity update(ProductosEntity productosActualizar) {
        return em.merge(productosActualizar);
    }

    /**
     * Elimina una tupla productos de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        ProductosEntity productosDelete = em.find(ProductosEntity.class, id);
        em.remove(productosDelete);
    }
}
