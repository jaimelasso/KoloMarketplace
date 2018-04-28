package co.edu.konrad.kolo.resources;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Martin Cortes
 */

@ApplicationPath("/api")
public class ApplicationConfig  extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
            Set <Class<?>> resources = new java.util.HashSet<>();
            addRestResourceClasses(resources);
            return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(co.edu.konrad.kolo.resources.CarritoComprasResource.class);
        resources.add(co.edu.konrad.kolo.resources.CategoriaResource.class);
        resources.add(co.edu.konrad.kolo.resources.CiudadResource.class);
        resources.add(co.edu.konrad.kolo.resources.ClienteResource.class);
        resources.add(co.edu.konrad.kolo.resources.FacturaResource.class);
        resources.add(co.edu.konrad.kolo.resources.InfoCreditoResource.class);
        resources.add(co.edu.konrad.kolo.resources.InfoDebitoResource.class);
        resources.add(co.edu.konrad.kolo.resources.PaisResource.class);
        resources.add(co.edu.konrad.kolo.resources.ProductosResource.class);
        resources.add(co.edu.konrad.kolo.resources.ProveedorResource.class);
        resources.add(co.edu.konrad.kolo.resources.TipoDocumentoResource.class);
        resources.add(co.edu.konrad.kolo.resources.TipoPagoResource.class);
    }
}
