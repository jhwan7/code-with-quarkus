package org.acme;

import org.jboss.resteasy.reactive.PartType;

public class MultipartBody {
    @PartType("text/plain")
    public String name;

    @PartType("application/octet-stream")
    public byte[] image;
}
