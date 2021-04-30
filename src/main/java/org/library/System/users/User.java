package org.library.System.users;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    private final UUID userId = UUID.randomUUID();
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserType type;

    public User() {

    }

    public User(String firstName, String lastName, String userName, String password, String type) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUserName(userName);
        this.setPassword(password);
        this.setType(UserType.valueOf(type.toUpperCase()));
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }


    public UUID getID() {
        return userId;
    }
}

