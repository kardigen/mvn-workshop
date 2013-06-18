package pl.jug.szczecin.workshop;

import org.testng.annotations.Test;
import pl.jug.szczecin.workshop.entity.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStorageTest {

    public static final String NAME = "Paweł";
    public static final String SURENAME = "Stawicki";
    public static final String EMAIL = "pawelstawicki@gmail.com";
    public static final String WEBPAGE = "pawelstawicki.blogspot.com";
    public static final String NAME_2 = "Filip";
    public static final String SURENAME_2 = "Pająk";
    public static final String WEBPAGE_2 = "pacykarz.blogspot.com";

    @Test
    public void shouldStoreUser() {
        // Given
        UserStorageInMemory storage = new UserStorageInMemory();

        // When
        storage.storeUser(new User(NAME, SURENAME, EMAIL, WEBPAGE));

        // Then
        List<User> users = storage.getUsers();
        assertThat(users).hasSize(1);

        User user = users.get(0);
        assertThat(user.getName()).isEqualTo(NAME);
        assertThat(user.getSurname()).isEqualTo(SURENAME);
        assertThat(user.getEmail()).isEqualTo(EMAIL);
        assertThat(user.getWebpage()).isEqualTo(WEBPAGE);
    }

    @Test
    public void shouldStoreUsers() {
        // Given
        UserStorageInMemory storage = new UserStorageInMemory();

        // When
        storage.storeUser(new User(NAME, SURENAME, EMAIL, WEBPAGE));
        storage.storeUser(new User(NAME_2, SURENAME_2, null, WEBPAGE_2));

        // Then
        List<User> users = storage.getUsers();
        assertThat(users).hasSize(2);
        assertThat(users).extracting("name").containsOnly(NAME, NAME_2);
        assertThat(users).extracting("surname").containsOnly(SURENAME, SURENAME_2);
        assertThat(users).extracting("email").containsOnly(EMAIL, null);
        assertThat(users).extracting("webpage").containsOnly(WEBPAGE, WEBPAGE_2);
    }

}
