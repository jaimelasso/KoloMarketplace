package co.edu.konrad.kolo.resources;

import java.util.Set;
import javax.ws.rs.Path;
import javafx.application.Application;

/**
 *
 * @author Martin Cortes
 */

@Path("/api")
public class ApplicationConfig  extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
            Set <Class<?>> resources = new java.util.HashSet<>();
            addRestResourceClasses(resources);
            return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(co.edu.konrad.kolo.resources.CarritoComprasResource);
        resources.add(co.edu.konrad.kolo.resources.CategoriaResource);
        resources.add(co.edu.konrad.kolo.resources.CiudadResource);
        resources.add(co.edu.konrad.kolo.resources.ClienteResource);
        resources.add(co.edu.konrad.kolo.resources.FacturaResource);
        resources.add(co.edu.konrad.kolo.resources.InfoCreditoResource);
        resources.add(co.edu.konrad.kolo.resources.InfoDebitoResource);
        resources.add(co.edu.konrad.kolo.resources.PaisResource);
        resources.add(co.edu.konrad.kolo.resources.ProductosResource);
        resources.add(co.edu.konrad.kolo.resources.ProveedorResource);
        resources.add(co.edu.konrad.kolo.resources.TipoDocumentoResource);
        resources.add(co.edu.konrad.kolo.resources.TipoPagoResource);
    }
}
