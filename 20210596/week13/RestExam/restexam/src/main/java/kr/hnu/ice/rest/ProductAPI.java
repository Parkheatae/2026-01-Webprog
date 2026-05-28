package kr.hnu.ice.rest;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductAPI {

    private static final ProductService service = new ProductService();

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String listProducts() {
        return service.findAll().stream()
                .map(ProductAPI::formatProductLine)
                .collect(Collectors.joining("\n"));
    }

    @GET
    @Path("/list/{pid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getProduct(@PathParam("pid") String pid) {
        Product product = service.find(pid);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("요청하신 상품을 찾을 수 없습니다.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        return Response.ok(formatProductDetail(product), MediaType.TEXT_PLAIN).build();
    }

    @DELETE
    @Path("/{pid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteProduct(@PathParam("pid") String pid) {
        if (service.delete(pid)) {
            return Response.ok("상품이 삭제되었습니다.", MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("삭제할 상품을 찾을 수 없습니다.")
                .type(MediaType.TEXT_PLAIN)
                .build();
    }

    private static String formatProductLine(Product product) {
        return String.format("%s | %s | %s | %s | %s",
                product.getId(),
                product.getName(),
                product.getMaker(),
                NumberFormat.getNumberInstance(Locale.KOREA).format(product.getPrice()) + "원",
                product.getDate());
    }

    private static String formatProductDetail(Product product) {
        return String.join("\n",
                "상품 코드: " + product.getId(),
                "상품명: " + product.getName(),
                "제조사: " + product.getMaker(),
                "가격: " + NumberFormat.getNumberInstance(Locale.KOREA).format(product.getPrice()) + "원",
                "등록일: " + product.getDate());
    }
}
