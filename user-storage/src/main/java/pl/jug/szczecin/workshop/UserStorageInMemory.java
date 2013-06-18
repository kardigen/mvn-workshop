package pl.jug.szczecin.workshop;

import pl.jug.szczecin.workshop.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorageInMemory implements UserStorage {

    private List<User> users = new ArrayList<User>();

    @Override
    public void storeUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
