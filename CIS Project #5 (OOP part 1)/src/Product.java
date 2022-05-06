import java.text.NumberFormat;

public class Product {

    //Instance variables
    private String productName;
    private String productDescription;
    private int qtyOnHand;
    private double unitPrice;

    //Default constructor
    public Product() {
        this("PRODUCT", "DESCRIPTION", 0, 0);
    }

    //Overloaded constructor
    public Product(String productName, String productDescription, int qtyOnHand, double unitPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
    }

    //Getters
    public String getProductName() {
        return this.productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public int getQtyOnHand() {
        return this.qtyOnHand;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    //Setters
    public void setProductName(String name) {
        this.productName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public void setProductDescription(String description) {
        this.productDescription = description;
    }

    public void setQtyOnHand(int qty) {
        if (qty >= 0) {
            this.qtyOnHand = qty;
        } else {
            this.qtyOnHand = 0;
        }
    }

    public void setUnitPrice(double price) {
        if (price >= 0) {
            this.unitPrice = price;
        } else {
            this.unitPrice = 0;
        }
    }

    //Returns total value of the product
    public double productTotalValue() {
        return this.unitPrice * this.qtyOnHand;
    }

    //Tests to see if parameter’s value is equal to the value of the product’s name
    public boolean equalsName(String name) {
        //Ignores the difference between parameter and current object's name
        // ex: Product names: cOmPuTeR and parameter: Computer will be considered true
        if (this.productName.equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }

    //Returns a String which contains the information of a Product instance
    public String productInformation(boolean isFullData) {
        //Formatting productTotalValue output
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);

        if (isFullData) {
            return "Product name: " + this.productName + "\nProduct Description: " + this.productDescription +
                    "\nQuantity on hand: " + this.qtyOnHand + "\nUnit price: $"
                    + this.unitPrice + "\nTotal product value: $" + format.format(productTotalValue());
        }
        return this.productName;
    }


}
