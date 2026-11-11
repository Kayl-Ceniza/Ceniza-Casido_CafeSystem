/**
 * Represents a customer's cafe order.
 *
 * @author Kayl Ceniza/Rowel Casido
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates a new order.
     * @param orderId order identification
     * @param customer customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds a menu item to the order.
     * @param item menu item
     * @return true if added successfully
     */
    public boolean addItem(MenuItem item) {

        if (item == null) {
            System.out.println("Invalid menu item.");
            return false;
        }

        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + ".");
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    /**
     * Computes subtotal using polymorphism.
     * @return subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Computes total with student discount.
     * @return final total
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            subtotal = subtotal - (subtotal * 0.10);
        }

        return Math.max(0, subtotal);
    }

    /**
     * Computes total after applying a voucher.
     * @param voucher voucher amount
     * @return final total
     */
    public double computeTotal(double voucher) {

        double total = computeTotal();

        if (voucher < 0) {
            System.out.println("Invalid voucher amount.");
            return total;
        }

        total -= voucher;

        return Math.max(0, total);
    }

    /**
     * Prints the order receipt and updates loyalty points.
     */
    public void printReceipt() {

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        if (customer.isStudent()) {
            System.out.printf("Subtotal: %.2f%n", computeSubtotal());
            System.out.printf("Student discount (10%%): -%.2f%n",
                    computeSubtotal() * 0.10);
        } else {
            System.out.printf("Subtotal: %.2f%n", computeSubtotal());
        }

        System.out.printf("TOTAL: %.2f%n", computeTotal());

        customer.addPoints(computeTotal());

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }

    /**
     * Prints receipt with voucher.
     * @param voucher voucher amount
     */
    public void printReceipt(double voucher) {

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-35s %8.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n",
                    computeSubtotal() * 0.10);
        }

        double totalBeforeVoucher = computeTotal();
        double validVoucher = Math.max(0, voucher);

        if (voucher < 0) {
            System.out.println("Invalid voucher amount.");
            validVoucher = 0;
        }

        System.out.printf("Voucher: -%.2f%n", validVoucher);

        double finalTotal = Math.max(0,
                totalBeforeVoucher - validVoucher);

        System.out.printf("TOTAL: %.2f%n", finalTotal);

        customer.addPoints(finalTotal);

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }
}
