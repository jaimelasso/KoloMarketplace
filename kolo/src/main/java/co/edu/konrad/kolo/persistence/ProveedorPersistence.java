package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.ProveedorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad proveedor
 *
 * @author David Cañon
 */
@Stateless
public class ProveedorPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla proveedor
     *
     * @return Lista de datos de la tabla proveedor
     */
    public List<ProveedorEntity> findAll() {
        Query todos = em.createQuery("select e from ProveedorEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla proveedor
     *
     * @param id que se desea buscar
     * @return proveedor
     */
    public ProveedorEntity find(Long id) {
        ProveedorEntity proveedor = em.find(ProveedorEntity.class,id);
        return proveedor;
    }

    /**
     * Creacion de un nuevo proveedor
     *
     * @param proveedor
     * @return nuevo proveedor creado
     */
    public ProveedorEntity create(ProveedorEntity proveedor) {
        em.persist(proveedor);
        return proveedor;
    }

    /**
     * Actualizacion de una tupla de la tabla proveedor
     *
     * @param proveedorActualizar
     * @return proveedor actualizado
     */
    public ProveedorEntity update(ProveedorEntity proveedorActualizar) {
        return em.merge(proveedorActualizar);
    }

    /**
     * Elimina una tupla proveedor de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        ProveedorEntity proveedorDelete = em.find(ProveedorEntity.class, id);
        em.remove(proveedorDelete);
    }
}
