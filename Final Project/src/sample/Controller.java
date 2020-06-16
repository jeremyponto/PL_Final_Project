package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Define a class named Controller which implements the Initializable interface and takes the Products and PersonData class as its own instance attribute.
// This class is necessary for controlling the product counting and price calculation scene (sample.fxml) controls.
// The interface must be implemented in order to override the initialize method for setting up necessary controls in the product counting and price calculation scene (sample.fxml) on the start of the scene.
// The class contains all necessary controls and instance attributes for the product counting and price calculation scene (sample.fxml).
// products is for setting up the products for display.
// btnSignOut is for signing out from the application.
// btnCalculateTotal is for calculating the subtotal, tax and total of bought products.
// btnCalculateChange is for calculating the change if the shopper pays greater than the total.
// btnPrintReceipt is for printing the receipt.
// Labels are for displaying the staff's username, products' name and price for each item, subtotal, tax, total and change.
// tfMoney is for getting the amount of money the shopper pays.
// FileInputStreams are for obtaining files from the project's folder.
// Images are for storing files as images.
// ImageViews are for displaying products' images.
// Spinners are for counting the number of products the shopper bought.
// SpinnerValueFactories are for setting the Spinners' values.
// personData is for getting the staff's username when the staff signs in to and signs out from the application.
// This class has 4 custom methods for each button.
// signOut is for signing out from the application when the staff clicks btnSignOut.
// signOut must throw Exception in order to change scene to the sign in scene (sample2.fxml).
// calculateTotal is for calculating the subtotal, tax and total of bought products when the staff clicks btnCalculateTotal.
// calculateChange is for calculating the change if the shopper pays greater than the total when the staff clicks btnCalculateChange.
// printReceipt is for printing the receipt when the staff clicks btnPrintReceipt.
// printReceipt must throw Exception in order to change scene to the receipt scene (sample4.fxml).
public class Controller implements Initializable {
    public Products products;

    public Button btnSignOut, btnCalculateTotal, btnCalculateChange, btnPrintReceipt;
    public Label lblUsername, lblProduct, lblProduct2, lblProduct3, lblProduct4, lblProduct5, lblProduct6, lblSubtotal, lblTax, lblTotal, lblChange;
    public TextField tfMoney;
    public FileInputStream fisProduct, fisProduct2, fisProduct3, fisProduct4, fisProduct5, fisProduct6;
    public Image iProduct, iProduct2, iProduct3, iProduct4, iProduct5, iProduct6;
    public ImageView ivProduct, ivProduct2, ivProduct3, ivProduct4, ivProduct5, ivProduct6;
    public Spinner<Integer> spProduct = new Spinner();
    public Spinner<Integer> spProduct2 = new Spinner();
    public Spinner<Integer> spProduct3 = new Spinner();
    public Spinner<Integer> spProduct4 = new Spinner();
    public Spinner<Integer> spProduct5 = new Spinner();
    public Spinner<Integer> spProduct6 = new Spinner();
    public SpinnerValueFactory<Integer> spvfProduct = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.gettShirt().getStock(), 0);
    public SpinnerValueFactory<Integer> spvfProduct2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.getSmartphone().getStock(), 0);
    public SpinnerValueFactory<Integer> spvfProduct3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.getPlate().getStock(), 0);
    public SpinnerValueFactory<Integer> spvfProduct4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.getLaptop().getStock(), 0);
    public SpinnerValueFactory<Integer> spvfProduct5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.getBowl().getStock(), 0);
    public SpinnerValueFactory<Integer> spvfProduct6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, products.getSweater().getStock(), 0);

    public PersonData personData;

    // When the staff clicks btnSignOut, this method will be called.
    // The staff will be signed out from the application and the scene will change to sample2.fxml.
    public void signOut() throws Exception {
        personData.setSignedIn(new Person("", "", new Account("", "", "")));

        lblUsername.setText(personData.getSignedIn().getAccount().getUsername());

        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnSignOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // When the staff clicks btnCalculateTotal, this method will be called.
    // The staff will get the subtotal, tax and total.
    // If no product is counted, a warning will appear that the staff must count the number of products the shopper bought.
    // btnCalculateTotal must be clicked first in order to set tfMoney enabled and btnCalculateChange visible.
    // The reason is that because the subtotal, tax and total must be calculated first before inputting the shopper's money and calculating the change.
    public void calculateTotal() {
        products.gettShirt().setQuantity(spProduct.getValue());
        products.getSmartphone().setQuantity(spProduct2.getValue());
        products.getPlate().setQuantity(spProduct3.getValue());
        products.getLaptop().setQuantity(spProduct4.getValue());
        products.getBowl().setQuantity(spProduct5.getValue());
        products.getSweater().setQuantity(spProduct6.getValue());

        products.setSubtotal(spProduct.getValue() * products.gettShirt().getPrice() + spProduct2.getValue() * products.getSmartphone().getPrice() + spProduct3.getValue() * products.getPlate().getPrice() + spProduct4.getValue() * products.getLaptop().getPrice() + spProduct5.getValue() * products.getBowl().getPrice() + spProduct6.getValue() * products.getSweater().getPrice());

        if(products.getSubtotal() == 0) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Please count products to calculate subtotal!");
            a.show();
            return;
        }

        products.setTax(products.getSubtotal() / 10);
        products.setTotal(products.getSubtotal() + products.getTax());

        lblSubtotal.setText("Subtotal: Rp" + products.getSubtotal());
        lblTax.setText("Tax (10%): Rp" + products.getTax());
        lblTotal.setText("Total: Rp" + products.getTotal());

        tfMoney.setDisable(false);

        btnCalculateChange.setVisible(true);
    }

    // When the staff clicks btnCalculateChange, this method will be called.
    // The staff will get the change after the staff inputs the amount of money the shopper pays.
    // If there is no input, a warning will appear that the staff must input an amount of money the shopper pays.
    // If the input contains other than numeric, a warning will appear that the staff must input a valid amount of money which is only numeric.
    // If the amount of money inputted is smaller than the total, a warning will appear that the staff must input an amount of money greater than the total.
    // btnCalculateChange must be clicked first in order to set btnPrintReceipt visible.
    // The reason is because the change must be calculated first before printing the receipt.
    public void calculateChange() {
        if(tfMoney.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Please input an amount of money!");
            a.show();
            return;
        } else if(!tfMoney.getText().matches("[0-9]+")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Please input a valid amount of money!");
            a.show();
            return;
        } else if(Integer.parseInt(tfMoney.getText()) - products.getTotal() < 0) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setContentText("Please input a sufficient amount of money!");
            a.show();
            return;
        }

        products.setMoney(Integer.parseInt(tfMoney.getText()));
        products.setChange(products.getMoney() - products.getTotal());

        lblChange.setText("Total: Rp" + products.getChange());

        btnPrintReceipt.setVisible(true);
    }

    // When the staff clicks btnPrintReceipt, this method will be called.
    // The staff will get the complete information of the shopper's transaction which will change the scene to sample4.fxml.
    public void printReceipt() throws Exception {
        products.gettShirt().setStock(products.gettShirt().getStock() - spProduct.getValue());
        products.getSmartphone().setStock(products.getSmartphone().getStock() - spProduct2.getValue());
        products.getPlate().setStock(products.getPlate().getStock() - spProduct3.getValue());
        products.getLaptop().setStock(products.getLaptop().getStock() - spProduct4.getValue());
        products.getBowl().setStock(products.getBowl().getStock() - spProduct5.getValue());
        products.getSweater().setStock(products.getSweater().getStock() - spProduct6.getValue());

        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnPrintReceipt.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample4.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // When the scene of this controller (sample.fxml) is shown, this method will be called automatically.
    // This method will display the staff's username, all products' image, name, price and quantity which will be shown by all products' spinners.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUsername.setText(personData.getSignedIn().getAccount().getUsername());
        try {
            fisProduct = new FileInputStream("tShirt.jpg");
            fisProduct2 = new FileInputStream("smartphone.jpg");
            fisProduct3 = new FileInputStream("plate.jpg");
            fisProduct4 = new FileInputStream("laptop.jpg");
            fisProduct5 = new FileInputStream("bowl.jpg");
            fisProduct6 = new FileInputStream("sweater.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        iProduct = new Image(fisProduct);
        iProduct2 = new Image(fisProduct2);
        iProduct3 = new Image(fisProduct3);
        iProduct4 = new Image(fisProduct4);
        iProduct5 = new Image(fisProduct5);
        iProduct6 = new Image(fisProduct6);
        ivProduct.setImage(iProduct);
        ivProduct2.setImage(iProduct2);
        ivProduct3.setImage(iProduct3);
        ivProduct4.setImage(iProduct4);
        ivProduct5.setImage(iProduct5);
        ivProduct6.setImage(iProduct6);
        lblProduct.setText(products.gettShirt().getName() + " @ Rp" + products.gettShirt().getPrice());
        lblProduct2.setText(products.getSmartphone().getName() + " @ Rp" + products.getSmartphone().getPrice());
        lblProduct3.setText(products.getPlate().getName() + " @ Rp" + products.getPlate().getPrice());
        lblProduct4.setText(products.getLaptop().getName() + " @ Rp" + products.getLaptop().getPrice());
        lblProduct5.setText(products.getBowl().getName() + " @ Rp" + products.getBowl().getPrice());
        lblProduct6.setText(products.getSweater().getName() + " @ Rp" + products.getSweater().getPrice());
        spProduct.setValueFactory(spvfProduct);
        spProduct2.setValueFactory(spvfProduct2);
        spProduct3.setValueFactory(spvfProduct3);
        spProduct4.setValueFactory(spvfProduct4);
        spProduct5.setValueFactory(spvfProduct5);
        spProduct6.setValueFactory(spvfProduct6);
    }
}
