package pl.jug.szczecin.workshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String email;
    private String webpage;

    public User() {
    }

    public User(String name, String surname, String email, String webpage) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.webpage = webpage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getWebpage() {
        return webpage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", webpage='" + webpage + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }
}
