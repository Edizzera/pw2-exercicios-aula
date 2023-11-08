package edu.ifrs;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://localhost:8444/")
@AccessToken
public interface IPayment {
    
    @POST
    @Path("/payment")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice confirmPayment(
        @FormParam("cardNumber") String cardnumber,    
        @FormParam("value") String value);

    @GET
    @Path("payment/invoices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invoice> list();
    


}
