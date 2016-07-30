package br.com.leonardoterrao.rest;

import br.com.leonardoterrao.model.Product;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("/")
public class ProductRest {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(Product.builder().id(1L).description("Product 1").build());
        products.add(Product.builder().id(2L).description("Product 2").build());
        products.add(Product.builder().id(3L).description("Product 3").build());
        products.add(Product.builder().id(4L).description("Product 4").build());
        products.add(Product.builder().id(5L).description("Product 5").build());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return products;
    }

    @GET
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@QueryParam("id") Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
