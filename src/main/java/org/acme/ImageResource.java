package org.acme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.reactive.MultipartForm;

import ImageComparator.ImageComparator;
import ImageComparator.ImageForm;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

@Path("/images")
public class ImageResource {

        @POST
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        public ImageForm uploadImage(@MultipartForm ImageForm form) {
            Log.error(form.myName);
            Log.error(form.myImage.getName());
            Log.error(form.myImage2.getName());
            ImageComparator.compareImages(form.myImage, form.myImage2);

            return null;
            // code to compare the two images goes here
        }


}
