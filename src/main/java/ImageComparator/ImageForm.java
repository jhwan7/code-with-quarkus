package ImageComparator;

import java.io.File;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import io.smallrye.common.annotation.Blocking;

public class ImageForm {
  @RestForm
    @PartType("text/plain")
    public String myName;

    @RestForm
    @PartType("application/octet-stream")
    public File myImage;

    @RestForm
    @PartType("application/octet-stream")
    public File myImage2;
  
  }
