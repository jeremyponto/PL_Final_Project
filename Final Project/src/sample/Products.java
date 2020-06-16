package sample;

// Define a class named Products which takes the Product abstract class as its own class attribute for printing receipts.
// This class contains 11 class attributes.
// tShirt, smartphone, plate, laptop, bowl and sweater are Products which contain quantity and price to be calculated.
// subtotal is for calculating the total price before tax calculation.
// tax is for calculating the total price's tax.
// total is for calculating the total price with tax included.
// money is for the amount of money the shopper pays.
// change is for the excess amount of money if the shopper pays greater than the total.
// This class has a default constructor which accepts no parameters.
// Each class attribute has its own mutator and accessor for setting and getting the value of each one.
public class Products {
    private static Product tShirt = new Clothing("T-shirt", 50000, "white");
    private static Product smartphone = new Electronics("Smartphone", 5000000, 40);
    private static Product plate = new Kitchenware("Plate", 150000, "ceramic");
    private static Product laptop = new Electronics("Laptop", 10000000, 120);
    private static Product bowl = new Kitchenware("Pot", 250000, "stainless steel");
    private static Product sweater = new Clothing("Sweater", 150000, "red");
    private static int subtotal = 0;
    private static int tax = 0;
    private static int total = 0;
    private static int money = 0;
    private static int change = 0;

    public Products() {
    }

    public static Product gettShirt() {
        return tShirt;
    }

    public static void settShirt(Product tShirt) {
        Products.tShirt = tShirt;
    }

    public static Product getSmartphone() {
        return smartphone;
    }

    public static void setSmartphone(Product smartphone) {
        Products.smartphone = smartphone;
    }

    public static Product getPlate() {
        return plate;
    }

    public static void setPlate(Product plate) {
        Products.plate = plate;
    }

    public static Product getLaptop() {
        return laptop;
    }

    public static void setLaptop(Product laptop) { Products.laptop = laptop; }

    public static Product getBowl() {
        return bowl;
    }

    public static void setBowl(Product bowl) {
        Products.bowl = bowl;
    }

    public static Product getSweater() {
        return sweater;
    }

    public static void setSweater(Product sweater) {
        Products.sweater = sweater;
    }

    public static int getSubtotal() {
        return subtotal;
    }

    public static void setSubtotal(int subtotal) {
        Products.subtotal = subtotal;
    }

    public static int getTax() {
        return tax;
    }

    public static void setTax(int tax) {
        Products.tax = tax;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Products.total = total;
    }

    public static int getMoney() { return money; }

    public static void setMoney(int money) { Products.money = money; }

    public static int getChange() {
        return change;
    }

    public static void setChange(int change) {
        Products.change = change;
    }
}
