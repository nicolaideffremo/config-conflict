package ch.ti8m.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greetings")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    private String message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings() {
        return message;
    }
}
