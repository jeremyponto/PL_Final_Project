package sample;

// Define a class named Kitchenware which inherits the Product abstract class.
// This class contains 5 instance attributes.
// stock, name, quantity and price are inherited from the Product abstract class.
// material is the Kitchenware's material.
// This class has an overloaded constructor which accepts 3 parameters which are name, price and material respectively.
// name and price use the inherited constructor.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from this class.
// Since Kitchenware is a Product, the object's stock, name, quantity and price use the inherited toString method.
public class Kitchenware extends Product {
    private String material;

    public Kitchenware(String name, int price, String material) {
        super(name, price);
        this.material = material;
    }

    public String getMaterial() { return material; }

    public void setMaterial(String material) { this.material = material; }

    @Override
    public String toString() {
        return "Kitchenware{" + super.toString() +
                ", material=" + material +
                '}';
    }
}
