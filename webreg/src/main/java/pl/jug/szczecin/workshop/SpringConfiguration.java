package pl.jug.szczecin.workshop;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: kardigen
 * Date: 6/9/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SpringConfiguration {

    public @Bean  @Scope("singleton")
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new MongoClient("127.0.0.1"),"webreg");
    }

}
