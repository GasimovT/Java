

public class TestProduct {
    public static void main(String[] args) {

        //Creating objects (a and b) with default and overloaded constructors
        Product a = new Product();
        Product b = new Product("cOmPuTeR", "Asus Laptop", 5, 10.75);

        //Displaying product information
        System.out.println(a.productInformation(true));
        System.out.println();
        System.out.println(a.productInformation(false));
        System.out.println();
        System.out.println(b.productInformation(true));
        System.out.println();
        System.out.println(b.productInformation(false));
        System.out.println();

        //Testing setProductName with bad parameter
        //Should change cOmPuTeR to Computer
        b.setProductName(b.getProductName());

        //Testing getters
        System.out.println(b.getProductName());
        System.out.println(b.getProductDescription());
        System.out.println(b.getUnitPrice());
        System.out.println(b.getQtyOnHand());

        //Calling productTotalValue method
        System.out.println();
        System.out.println(b.productTotalValue());

        //Calling equalsName method - should return true
        System.out.println();
        System.out.println(b.equalsName("comPuTER"));
        System.out.println();

        //Testing setters

        //Testing setProductName functionality with bad parameter
        //Should return Cleaning instead of cLeaninG
        b.setProductName("cLeaninG");
        b.setProductDescription("Home supplies");
        b.setQtyOnHand(10);
        //Testing bad parameter - should assign 0 to unit price
        b.setUnitPrice(-1);

        //Displaying new information
        System.out.println(b.productInformation(true));
        System.out.println();
        System.out.println(b.productInformation(false));
        System.out.println();
        System.out.println(b.getProductName());
        System.out.println(b.getProductDescription());
        System.out.println(b.getUnitPrice());
        System.out.println(b.getQtyOnHand());
    }
}
