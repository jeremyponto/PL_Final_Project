package sample;

import java.io.Serializable;

// Define a class named Account which implements the Serializable interface.
// The interface must be implemented in order to serialize the object into a stream so that it can be saved in a file.
// This class contains 3 instance attributes.
// username is the Account's username.
// email is the Account's email.
// password is the Account's password.
// This class has an overloaded constructor which accepts 3 parameters which are username, email and password respectively.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from this class.
public class Account implements Serializable {
    private String username;
    private String email;
    private String password;

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username=" + username +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
