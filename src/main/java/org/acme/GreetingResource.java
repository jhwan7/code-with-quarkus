package org.acme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import CustomObject.AffectFruit;

@Path("/hello")
@RequestScoped
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    private TestProducer testProducer;

    @Inject
    private @Named("Alternative Affected Fruit") AffectFruit affectFruit;
    
    @Inject
    private @Named("Affected Fruit") AffectFruit affectFruit2;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        LOG.info(testProducer.getFruit().getName());
        // return testProducer.getFruit();

        LOG.info(affectFruit.getName());
        LOG.info(affectFruit2.getName());
        
        return "here";
    }
}