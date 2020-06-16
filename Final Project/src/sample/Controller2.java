package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

// Define a class named Controller2 which takes the PersonData class as its own instance attribute.
// This class is necessary for controlling the sign in scene (sample2.fxml) controls.
// The class contains all necessary controls and instance attributes for the sign in scene (sample2.fxml).
// tfUsername is for inputting the staff's username.
// pfPassword is for inputting the staff's password.
// btnSignIn is for signing in to the application.
// btnSignUp is for signing up a new account for a new staff.
// personData is for getting signedUp and setting signedIn to the staff's account when the staff signs in to the application.
// invalidSignIn is for checking whether username or password input is invalid.
// This class has 2 custom methods for each button.
// signIn is for signing in to the application when the staff clicks btnSignIn.
// signIn must throw Exception in order to change scene to the product counting and price calculation scene (sample.fxml).
// signUp is for signing up a new account for a new staff when the staff clicks btnSignUp.
// signUp must throw Exception in order to change scene to the sign up scene (sample3.fxml).
public class Controller2 implements ButtonActions {
    public TextField tfUsername;
    public PasswordField pfPassword;
    public Button btnSignIn, btnSignUp;

    public PersonData personData;

    public boolean invalidSignIn;

    // When the staff clicks btnSignIn, this method will be called.
    // The staff will be signed in to the application after signing in using the staff's existing account.
    // If one of the text fields are empty, a warning will appear that all text fields must be filled.
    // If there is no existing account, a warning will appear that the staff must sign up for a new account.
    // If there are text fields which has invalid input, a warning will appear depending on which fields are invalid.
    @Override
    public void signIn() throws Exception {
        invalidSignIn = false;

        File file = new File("signedUpAccounts.txt");

        if(file.length() != 0) {
            personData.readSignedUp();
        }

        String username = tfUsername.getText();
        String password = pfPassword.getText();

        if(username.isEmpty() || password.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("All data must be filled!");
            a.show();
            invalidSignIn = true;
        } else if(personData.getSignedUp().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("A new account must be signed up!");
            a.show();
            invalidSignIn = true;
        } else {
            for(Person person : personData.getSignedUp()) {
                if (!person.getAccount().getUsername().equals(username) && !person.getAccount().getPassword().equals(password)) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning");
                    a.setContentText("Invalid username and password!");
                    a.show();
                    invalidSignIn = true;
                    break;
                } else if(!person.getAccount().getUsername().equals(username)) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning");
                    a.setContentText("Invalid username!");
                    a.show();
                    invalidSignIn = true;
                    break;
                } else if(!person.getAccount().getPassword().equals(password)) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning");
                    a.setContentText("Invalid password!");
                    a.show();
                    invalidSignIn = true;
                    break;
                }
            }
        }

        if(invalidSignIn) {
            return;
        }

        for(Person person : personData.getSignedUp()) {
            if(person.getAccount().getUsername().equals(username) && person.getAccount().getPassword().equals(password)) {
                personData.setSignedIn(person);
            }
        }

        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnSignIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // When the staff clicks btnSignUp, this method will be called.
    // The staff can sign up for a new account after changing scene to the sign up scene (sample3.fxml).
    @Override
    public void signUp() throws Exception {
        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnSignUp.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample3.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
