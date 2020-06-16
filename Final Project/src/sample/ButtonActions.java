package sample;

// Define an interface name ButtonActions as a function template for signing in and up at sample2.fxml and sample3.fxml.
// This interface has 2 custom functions which will be overridden in classes Controller2 and Controller3, the controller classes for each of the scene mentioned above respectively.
// signIn is for signing in to application from sign in scene (sample2.fxml) to product counting and price calculation scene (sample.fxml) in the Controller2 class.
// signIn is also for changing scene from sign up scene (sample3.fxml) to sign in scene (sample2.fxml) if a new staff has created a new account in the Controller3 class.
// Changing scene is the reason why signIn must throw Exception.
// signUp is for signing up a new account for a new staff in the Controller3 class.
// signUp is also for changing scene from sign in scene (sample2.fxml) to sign up scene (sample3.fxml) if a new staff has not created a new account in the Controller2 class.
// Changing scene is the reason why signUp must throw Exception.
public interface ButtonActions {
    public void signIn() throws Exception;

    public void signUp() throws Exception;
}
