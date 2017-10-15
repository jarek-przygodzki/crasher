package io.github.jarekprzygodzki.crasher.rs;

import javax.json.Json;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.dropwizard.util.Size;
import io.github.jarekprzygodzki.crasher.HeapMemory;
import io.github.jarekprzygodzki.crasher.JvmCrasher;

@Path("/")
public class Resource {

    /**
     * JVM crash
     */
    @POST
    @Path("/jvm-crash")
    public Response jvmCrash(){
        JvmCrasher.crashJvm();
        return Response.noContent()
                       .build();
    }

    /**
     * Trigger OOM
     */
    @POST
    @Path("/oom")
    public Response triggerOOM() {
        HeapMemory.triggerOOM();
        return Response.noContent()
                       .build();
    }

    /**
     * Allocate heap memory
     */
    @POST
    @Path("/allocate")
    public Response allocate(@QueryParam("size") String size) {
        HeapMemory.allocate(Size.parse(size));
        return Response.ok(Json.createObjectBuilder()
                               .add("totalAllocatedBytes", HeapMemory.totalAllocatedBytes())
                               .build())
                       .build();
    }

    /**
     * Free heap memory
     */
    @POST
    @Path("/free")
    public Response free(@QueryParam("bytes") int bytes) {
        HeapMemory.free();
        return Response.noContent()
                       .build();
    }
}
