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
        resources.add(co.edu.konrad.kolo.resources.ClienteResource.class);
    }
}
