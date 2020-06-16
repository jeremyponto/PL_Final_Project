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

// Define a class named Controller3 which takes the PersonData class as its own instance attribute.
// This class is necessary for controlling the sign up scene (sample3.fxml) controls.
// The class contains all necessary controls and instance attributes for the sign up scene (sample3.fxml).
// tfFirstName is for inputting the new staff's first name.
// tfLastName is for inputting the new staff's last name.
// tfUsername is for inputting the new staff's username.
// tfEmail is for inputting the new staff's email.
// pfPassword is for inputting the new staff's password.
// btnSignUp is for signing up a new account for a new staff.
// btnSignIn is for signing in to the application.
// personData is for getting signedUp and setting signedIn to the staff's account when the staff signs in to the application.
// invalidSignUp is for checking whether first name, last name, username, email or password input is invalid.
// This class has 2 custom methods for each button.
// signUp is for signing up a new account for a new staff when the staff clicks btnSignUp.
// signIn is for signing in to the application when the staff clicks btnSignIn.
// signIn must throw Exception in order to change scene to the sign in scene (sample2.fxml).
public class Controller3 implements ButtonActions {
    public TextField tfFirstName, tfLastName, tfUsername, tfEmail;
    public PasswordField pfPassword;
    public Button btnSignUp, btnSignIn;

    public PersonData personData;

    public boolean invalidSignUp;

    // When the staff clicks btnSignUp, this method will be called.
    // A new staff have a chance to sign up for a new account for logging in to the application.
    // If one of the text fields are empty, a warning will appear that all text fields must be filled.
    // If there is no email domain or email name, a warning will appear that the inputted email is invalid.
    // If the inputted password contains less than 8 characters, a warning will appear that the password must contain at least 8 characters.
    // If the inputted password doesn't contain at least a lowercase letter, an uppercase letter and a digit, a warning will appear that the inputted password must contain at least a lowercase letter, an uppercase letter and a digit.
    // If the inputted username is the same as one of the existing accounts' username, a warning will appear that the inputted username has been taken.
    @Override
    public void signUp() {
        invalidSignUp = false;

        File file = new File("signedUpAccounts.txt");

        if(file.length() != 0) {
            personData.readSignedUp();
        }

        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String username = tfUsername.getText();
        String email = tfEmail.getText();
        String password = pfPassword.getText();

        if(firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("All data must be filled!");
            a.show();
            invalidSignUp = true;
        } else if(!email.endsWith("@gmail.com") && !email.endsWith("@yahoo.com") || email.length() <= 10) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Invalid email!");
            a.show();
            invalidSignUp = true;
        } else if(password.length() < 8) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Password must contain at least 8 characters!");
            a.show();
            invalidSignUp = true;
        } else if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Password must contain at least a lowercase letter, an uppercase letter and a digit!");
            a.show();
            invalidSignUp = true;
        } else {
            for (Person person : personData.getSignedUp()) {
                if (person.getAccount().getUsername().equals(username)) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning");
                    a.setContentText("Username has been taken!");
                    a.show();
                    invalidSignUp = true;
                    break;
                }
            }
        }

        if(invalidSignUp) {
            return;
        }

        personData.addSignedUp(firstName, lastName, username, email, password);

        personData.writeSignedUp();

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information");
        a.setContentText("Sign Up Successful!");
        a.show();
    }

    // When the staff clicks btnSignIn, this method will be called.
    // The staff can log in to the application with an existing account after changing scene to the sign in scene (sample2.fxml).
    @Override
    public void signIn() throws Exception {
        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnSignIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
