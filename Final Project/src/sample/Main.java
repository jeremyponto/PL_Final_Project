package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Define a class name Main which inherits the Application abstract class.
// This class is necessary to run the application.
// The application shows the sign in scene (sample2.fxml) as the first scene on stage since signing in is necessary to use the application.
public class Main extends Application {

    // This method will be called automatically when the staff runs the application.
    // The application shows the sign in scene (sample2.fxml) as the first scene on stage since signing in is necessary to use the application.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        primaryStage.setTitle("Cashie");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // This method will be called automatically when the staff runs the application.
    // The application will launch if the staff runs the application.
    public static void main(String[] args) {
        launch(args);
    }
}
