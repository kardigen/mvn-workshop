package pl.jug.szczecin.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.jug.szczecin.workshop.UserStorage;
import pl.jug.szczecin.workshop.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kardigen
 * Date: 6/9/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MongoUserStorage implements UserStorage{

    @Autowired
    public MongoUserStorage(MongoTemplate mongoRepository){
        this.mongoRepository = mongoRepository;
    }

    private MongoTemplate mongoRepository;

    @Override
    public void storeUser(User user) {
        mongoRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return mongoRepository.findAll(User.class);
    }

    public MongoTemplate getMongoRepository() {
        return mongoRepository;
    }

    public void setMongoRepository(MongoTemplate mongoRepository) {
        this.mongoRepository = mongoRepository;
    }
}
