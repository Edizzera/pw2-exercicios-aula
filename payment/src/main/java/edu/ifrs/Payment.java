package edu.ifrs;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/payment")
public class Payment {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("User")
    @Transactional
    public Invoice confirmPayment(
        @FormParam("cardNumber") String cardNumber,    
        @FormParam("value") String value) {
            Invoice invoice = new Invoice(cardNumber, value, true);
            // Persist the invoice method
            invoice.persist();
            return invoice;
    }

}