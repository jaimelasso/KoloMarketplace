package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.FacturaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad factura
 *
 * @author David Cañon
 */
@Stateless
public class FacturaPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla factura
     *
     * @return Lista de datos de la tabla factura
     */
    public List<FacturaEntity> findAll() {
        Query todos = em.createQuery("select e from FacturaEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla factura
     *
     * @param id que se desea buscar
     * @return factura
     */
    public FacturaEntity find(Long id) {
        FacturaEntity factura = em.find(FacturaEntity.class, id);
        return factura;
    }

    /**
     * Creacion de un nuevo factura
     *
     * @param factura
     * @return nuevo factura creado
     */
    public FacturaEntity create(FacturaEntity ciudad) {
        em.persist(ciudad);
        return ciudad;
    }

    /**
     * Actualizacion de una tupla de la tabla factura
     *
     * @param facturaActualizar
     * @return factura actualizado
     */
    public FacturaEntity update(FacturaEntity facturaActualizar) {
        return em.merge(facturaActualizar);
    }

    /**
     * Elimina una tupla factura de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        FacturaEntity facturaDelete = em.find(FacturaEntity.class, id);
        em.remove(facturaDelete);
    }
}
