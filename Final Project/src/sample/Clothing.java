package sample;

// Define a class named Clothing which inherits the Product abstract class.
// This class contains 5 instance attributes.
// stock, name, quantity and price are inherited from the Product abstract class.
// color is the Clothing's color.
// This class has an overloaded constructor which accepts 3 parameters which are name, price and color respectively.
// name and price use the inherited constructor.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from this class.
// Since Clothing is a Product, the object's stock, name, quantity and price use the inherited toString method.
public class Clothing extends Product {
    private String color;

    public Clothing(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{" + super.toString() +
                ", color=" + color +
                '}';
    }
}
