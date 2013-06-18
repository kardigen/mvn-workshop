package pl.jug.szczecin.workshop;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.jug.szczecin.workshop.UserStorage;
import pl.jug.szczecin.workshop.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kardigen
 * Date: 6/9/13
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class MongoUserStorageTest {

    private UserStorage userStorage;
    private MongoTemplate repository;

    @BeforeTest
    public void setupUserStorage(){
        repository = mock(MongoTemplate.class);
        userStorage = new MongoUserStorage(repository);
    }

    @Test
    public void shouldSaveUser(){
        //given
        User bolek = new User("bolek", "kowal", "bkowal@email.com", "wypas.pl");

        //when
        userStorage.storeUser(bolek);

        //then
        verify(repository,times(1)).save(bolek);
    }

    @Test
    public void shouldFetchUsers(){
        //given
        final User bolek = new User("bolek", "kowal", "bkowal@email.com", "wypas.pl");
        when(repository.findAll(User.class)).thenReturn(new ArrayList<User>(){{ add(bolek);}});

        //when
        List<User> users = userStorage.getUsers();

        //then
        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        assertThat(users.get(0))
                .isNotNull()
                .isSameAs(bolek);

        verify(repository,times(1)).findAll(User.class);

    }

}
