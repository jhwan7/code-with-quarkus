package CustomObject;


import static javax.ws.rs.RuntimeType.SERVER;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.acme.ImageResource;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import ImageComparator.ImageForm;
import io.quarkus.logging.Log;

@Provider
@ConstrainedTo(SERVER)
@ApplicationScoped
public class FruitInterceptor implements ContainerRequestFilter {
    private static final Logger LOG = Logger.getLogger(FruitInterceptor.class);

    @Produces
    @RequestScoped
    Fruit fruit;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // TODO Auto-generated method stub
        LOG.info("THIS IS AN INTERCEPTOR");
    }
}
