package CustomObject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

public class Fruit {
    private String name;
    private String id;

    private static final Logger LOG = Logger.getLogger(Fruit.class);

    public Fruit(String name, String id) {
        LOG.info("called with name=" + name + ", id=" + id);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}
