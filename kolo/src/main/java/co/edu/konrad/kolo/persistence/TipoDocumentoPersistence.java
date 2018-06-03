 package co.edu.konrad.kolo.persistence;

import co.edu.konrad.kolo.entities.TipoDocumentoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador de la entidad tipoDocumento
 *
 * @author David Cañon
 */
@Stateless
public class TipoDocumentoPersistence {

    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla tipoDocumento
     *
     * @return Lista de datos de la tabla tipoDocumento
     */
    public List<TipoDocumentoEntity> findAll() {
        Query todos = em.createQuery("select e from TipoDocumentoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla tipoDocumento
     *
     * @param id que se desea buscar
     * @return tipoDocumento
     */
    public TipoDocumentoEntity find(Long id) {
        TipoDocumentoEntity tipoDocumento = em.find(TipoDocumentoEntity.class, id);
        return tipoDocumento;
    }

    /**
     * Creacion de un nuevo tipoDocumento
     *
     * @param tipoDocumento
     * @return nuevo tipoDocumento creado
     */
    public TipoDocumentoEntity create(TipoDocumentoEntity tipoDocumento) {
        em.persist(tipoDocumento);
        return tipoDocumento;
    }

    /**
     * Actualizacion de una tupla de la tabla tipoDocumento
     *
     * @param tipoDocumentoActualizar
     * @return tipoDocumento actualizado
     */
    public TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumentoActualizar) {
        return em.merge(tipoDocumentoActualizar);
    }

    /**
     * Elimina una tupla tipoDocumento de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        TipoDocumentoEntity tipoDocumentoDelete = em.find(TipoDocumentoEntity.class, id);
        em.remove(tipoDocumentoDelete);
    }
}
