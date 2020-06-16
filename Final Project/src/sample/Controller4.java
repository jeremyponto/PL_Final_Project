package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// Define a class named Controller4 which implements the Initializable interface and takes the Products class as its own instance attribute.
// This class is necessary for controlling the receipt scene (sample4.fxml) controls.
// The interface must be implemented in order to override the initialize method for setting up necessary controls in the receipt scene (sample4.fxml) on the start of the scene.
// The class contains all necessary controls and instance attributes for the receipt scene (sample4.fxml).
// Labels are for displaying the products' name, quantity and price, subtotal, tax, total, the shopper's money and change.
// btnBack is for going back to calculate new transaction.
// products is for getting the products' transaction for receipt printing.
// This class has a custom method for btnBack.
// back is for going back to calculate new transaction when the staff clicks btnBack.
// back must throw Exception in order to change scene to the product counting and price calculation scene (sample.fxml).
public class Controller4 implements Initializable {
    public Label lblProduct, lblProduct2, lblProduct3, lblProduct4, lblProduct5, lblProduct6, lblProductPrice, lblProductPrice2, lblProductPrice3, lblProductPrice4, lblProductPrice5, lblProductPrice6, lblSubtotal, lblTax, lblTotal, lblMoney, lblChange;
    public Button btnBack;

    public Products products;

    // When the staff clicks btnBack, this method will be called.
    // The staff can go back to calculate further transactions after changing scene to the product counting and price calculation scene (sample.fxml).
    public void back() throws Exception {
        Stage primaryStage;
        Parent root;

        primaryStage = (Stage) btnBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // When the scene of this controller (sample4.fxml) is shown, this method will be called automatically.
    // This method will display all products' name, quantity and price, subtotal, tax, total, the shopper's money paid for the transaction and change for the receipt.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblProduct.setText(products.gettShirt().getName() + " x " + products.gettShirt().getQuantity());
        lblProduct2.setText(products.getSmartphone().getName() + " x " + products.getSmartphone().getQuantity());
        lblProduct3.setText(products.getPlate().getName() + " x " + products.getPlate().getQuantity());
        lblProduct4.setText(products.getLaptop().getName() + " x " + products.getLaptop().getQuantity());
        lblProduct5.setText(products.getBowl().getName() + " x " + products.getBowl().getQuantity());
        lblProduct6.setText(products.getSweater().getName() + " x " + products.getSweater().getQuantity());
        lblProductPrice.setText("Rp" + (products.gettShirt().getQuantity() * products.gettShirt().getPrice()));
        lblProductPrice2.setText("Rp" + (products.getSmartphone().getQuantity() * products.getSmartphone().getPrice()));
        lblProductPrice3.setText("Rp" + (products.getPlate().getQuantity() * products.getPlate().getPrice()));
        lblProductPrice4.setText("Rp" + (products.getLaptop().getQuantity() * products.getLaptop().getPrice()));
        lblProductPrice5.setText("Rp" + (products.getBowl().getQuantity() * products.getBowl().getPrice()));
        lblProductPrice6.setText("Rp" + (products.getSweater().getQuantity() * products.getSweater().getPrice()));
        lblSubtotal.setText("Rp" + products.getSubtotal());
        lblTax.setText("Rp" + products.getTax());
        lblTotal.setText("Rp" + products.getTotal());
        lblMoney.setText("Rp" + products.getMoney());
        lblChange.setText("Rp" + products.getChange());
    }
}
