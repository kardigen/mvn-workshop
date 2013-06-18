package pl.jug.szczecin.workshop;

import pl.jug.szczecin.workshop.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kardigen
 * Date: 6/9/13
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserStorage {
    void storeUser(User user);

    List<User> getUsers();
}
