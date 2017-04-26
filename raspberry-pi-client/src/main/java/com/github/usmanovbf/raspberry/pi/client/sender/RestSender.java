package com.github.usmanovbf.raspberry.pi.client.sender;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestSender {
    public void sender() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target( "http://foo.com/resource" );
        Response response = target.request().get();
        String value = response.readEntity( String.class );
        response.close();  // You should close connections!

    }

}
