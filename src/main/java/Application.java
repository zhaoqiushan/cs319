import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import properties.DefaultProperties;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Qiushan on 2018/1/17.
 */
public class Application {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = DefaultProperties.getInstance().getProperty("baseURL");

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example.rest package
        final ResourceConfig rc = new ResourceConfig().packages("resource");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Server Listening at: %s", BASE_URI));
    }
}
