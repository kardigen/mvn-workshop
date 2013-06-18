package pl.jug.szczecin.workshop;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pl.jug.szczecin.workshop.entity.User;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/storage")
public class UserStorageRest {

    @POST
    @Path("/store")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void storeUser(
            @Context ServletContext servletContext,
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("email") String email,
            @FormParam("webpage") String webpage) {

        UserStorage userStorage = getUserStorage(servletContext);

        User user = new User(name, surname, email, webpage);
        System.out.println("User to store: " + user);
        userStorage.storeUser(user);
    }

    private UserStorage getUserStorage(ServletContext servletContext) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return webApplicationContext.getBean(UserStorage.class);
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers( @Context ServletContext servletContext ) {
        UserStorage userStorage = getUserStorage(servletContext);
        return userStorage.getUsers();
    }

}
