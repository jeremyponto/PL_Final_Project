package sample;

import java.io.Serializable;

// Define a class named Person which implements the Serializable interface and takes the Account class as its own instance attribute.
// The interface must be implemented in order to serialize the object into a stream so that it can be saved in a file.
// This class contains 3 instance attributes.
// firstName is the Person's first name.
// lastName is the Person's last name.
// account is the Person's account.
// This class has an overloaded constructor which accepts 3 parameters which are firstName, lastName and account respectively.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from this class.
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Account account;

    public Person(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", account=" + account +
                '}';
    }
}
