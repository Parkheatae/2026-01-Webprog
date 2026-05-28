package kr.hnu.ice.productrest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductRestAPI {
    private static ProductService service = new ProductService();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Product> list() {
        return service.findAll();
    }

    @GET
    @Path("/list/{pid}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Object info(@PathParam("pid") String pid) {
        Product product = service.find(pid);

        if (product == null) {
            return "오류: 해당 상품이 없습니다. pid=" + pid;
        }

        return product;
    }

    @DELETE
    @Path("/{pid}")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String delete(@PathParam("pid") String pid) {
        boolean result = service.delete(pid);

        if (result) {
            return "삭제 완료: " + pid;
        } else {
            return "오류: 해당 상품이 없습니다. pid=" + pid;
        }
    }
}
