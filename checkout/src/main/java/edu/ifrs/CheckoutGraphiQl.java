package edu.ifrs;

import java.util.List;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@GraphQLApi
@ApplicationScoped
public class CheckoutGraphiQl {

    @Inject
    @RestClient
    IPayment service;

    @Query("listInvoices")
    @Description("Get all Invoices")
    public List<Invoice> list() {
        return service.list();        
    }
    
}
