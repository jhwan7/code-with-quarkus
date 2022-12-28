package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import CustomObject.AffectFruit;
import CustomObject.Fruit;

@ApplicationScoped
public class TestProducer {
    private static final Logger LOG = Logger.getLogger(TestProducer.class);

    private Fruit fruit;

    public Fruit getFruit() {
        return this.fruit;
    }

    @Inject
    public TestProducer (Fruit fruit) {
        LOG.info("Test producer is created");
        LOG.info("this fruit is " + fruit.getName());
        this.fruit = fruit;
    }

    @Produces
    @RequestScoped
    @Named("Affected Fruit")
    public AffectFruit Resolve(Fruit fruit) {
        LOG.info("this is a producer");

        return new AffectFruit(fruit.getName());
    }

    @Produces
    @RequestScoped
    @Named("Alternative Affected Fruit")
    public AffectFruit ResolveA(Fruit fruit) {
        LOG.info("Alternative Affected Fruit");

        return new AffectFruit(fruit.getName() + "#!@#!@#");
    }
    
    public void randomString() {
        LOG.info("This method is being called");
    }
  
}
