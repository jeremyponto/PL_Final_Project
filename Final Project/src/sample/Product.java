package sample;

// Define an abstract class named Product as a template for more specific products.
// This class contains 4 instance attributes.
// stock is for counting how many items left for the corresponding product.
// name is for the Product's name.
// quantity is for counting how many items are bought for each transaction.
// price is for the Product's price.
// This class has an overloaded constructor which accepts 2 parameters which are name and price respectively.
// Each instance attribute has its own mutator and accessor for setting and getting the value of each one.
// This class has an overridden toString method which returns the information of the object instantiated from the inheritors of this class.
public abstract class Product {
    private int stock;
    private String name;
    private int quantity;
    private int price;

    public Product(String name, int price) {
        this.stock = 100;
        this.name = name;
        this.quantity = 0;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stock=" + stock +
                ", name=" + name +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
