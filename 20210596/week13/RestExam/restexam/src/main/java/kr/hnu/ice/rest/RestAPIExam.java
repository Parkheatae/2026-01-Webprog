package kr.hnu.ice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/restapi")
public class RestAPIExam {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "안녕하세요.";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response postMessage(@QueryParam("msg") String msg) {
        if (msg == null || msg.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("msg 쿼리 파라미터를 전달해야 합니다.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        return Response.ok(msg + " API Service", MediaType.TEXT_PLAIN).build();
    }
}
