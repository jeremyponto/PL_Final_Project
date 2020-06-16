package sample;

import java.io.*;
import java.util.ArrayList;

// Define a class named PersonData for storing signed up Person's accounts and currently signed in Person's account.
// This class contains 2 class attributes.
// signedUp is for storing signed up Person's accounts.
// signedIn is for storing currently signed in Person's account.
// This class has a default constructor which accepts no parameters.
// Each class attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has 3 custom methods.
// addSignedUp is for adding a new Person's account into signedUp.
// writeSignedUp is to write signedUp to a file so signed up Person's accounts so they can be used later to sign in to the application.
// readSignedUp is to read signed up Person's accounts from a file so they can be stored again in signedUp and used to sign in to the application.
public class PersonData {
    private static ArrayList<Person> signedUp = new ArrayList<>();
    private static Person signedIn;

    public PersonData() {
    }

    public static ArrayList<Person> getSignedUp() {
        return signedUp;
    }

    public static void setSignedUp(ArrayList<Person> signedUp) {
        PersonData.signedUp = signedUp;
    }

    public static void addSignedUp(String firstName, String lastName, String username, String email, String password) {
        signedUp.add(new Person(firstName, lastName, new Account(username, email, password)));
    }

    public static void writeSignedUp() {
        try {
            FileOutputStream fos = new FileOutputStream("signedUpAccounts.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(signedUp);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSignedUp() {
        try {
            FileInputStream fis = new FileInputStream("signedUpAccounts.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            signedUp = (ArrayList<Person>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Person getSignedIn() {
        return signedIn;
    }

    public static void setSignedIn(Person signedIn) {
        PersonData.signedIn = signedIn;
    }
}
