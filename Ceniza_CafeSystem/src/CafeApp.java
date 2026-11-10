/**
 * This is the main class for the Campus Cafe Ordering System.
 *
 * @author Kayl Ceniza/Rowel Casido
 * @version 1.0
 */
public class CafeApp {

    /**
     * This is the Main method that runs the cafe ordering system.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("     CAMPUS CAFE ORDERING SYSTEM");
        System.out.println("==================================");

        // Create customers using different constructors.
        Customer customer1 = new Customer("Rowel Casido", true);
        Customer customer2 = new Customer("Kayl Ceniza");

        // Create Beverage using default constructor.
        Beverage latte = new Beverage();
        latte.setName("Iced Latte");
        latte.setBasePrice(120);
        latte.setItemCode("B-01");
        latte.setSize("S");

        // Create Beverage using parameterized constructor.
        Beverage chocolate = new Beverage(
                "Hot Chocolate", 80, "B-02", "M");

        // Demonstrate invalid price validation.
        chocolate.setBasePrice(-5);
        chocolate.setBasePrice(80);

        // Create Pastry using parameterized constructor.
        Pastry ensaymada = new Pastry(
                "Ensaymada", 45, "P-01", true);

        // Create Pastry using default constructor.
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(35);
        cookie.setItemCode("P-02");
        cookie.setWarmed(false);

        // Create Meal using parameterized constructor.
        Meal chicken = new Meal(
                "Chicken Adobo", 110, "M-01", true, 1);

        // Create Meal using default constructor.
        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        // FIRST ORDER
        System.out.println("\n========== FIRST ORDER ==========");

        Order order1 = new Order("#1001", customer1);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(chicken);

        // Try adding a fourth item.
        order1.addItem(cookie);

        // Print first receipt.
        order1.printReceipt();

        // SECOND ORDER
        System.out.println("\n========== SECOND ORDER ==========");

        Order order2 = new Order("#1002", customer2);

        order2.addItem(chocolate);
        order2.addItem(beefTapa);

        // Demonstrate overloaded total with voucher.
        System.out.printf("Total with voucher: %.2f%n",
                order2.computeTotal(20));

        // Print second receipt with voucher.
        order2.printReceipt(20);

        System.out.println("\n==================================");
        System.out.println("      THANK YOU FOR ORDERING!");
        System.out.println("==================================");
    }
}
