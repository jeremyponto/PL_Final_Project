package sample;

// Define a class named Electronics which inherits the Product abstract class.
// This class contains 5 instance attributes.
// stock, name, quantity and price are inherited from the Product abstract class.
// wattage is the Electronics' wattage.
// This class has an overloaded constructor which accepts 3 parameters which are name, price and wattage respectively.
// name and price use the inherited constructor.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from this class.
// Since Electronics is a Product, the object's stock, name, quantity and price use the inherited toString method.
public class Electronics extends Product {
    private int wattage;

    public Electronics(String name, int price, int wattage) {
        super(name, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Electronics{" + super.toString() +
                ", wattage=" + wattage +
                '}';
    }
}
