

/**
 * Represents a customer placing a cafe order.
 *
 * @author Kayl Ceniza/Rowel Casido
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        name = "Unknown Customer";
        student = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with customer name.
     *
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
        student = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with name and student status.
     *
     * @param name    customer name
     * @param student student status
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds one point for every 50 pesos spent.
     *
     * @param amountSpent amount spent
     */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    /**
     * Gets customer name.
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer name.
     *
     * @param name new name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Checks student status.
     *
     * @return true if student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets student status.
     *
     * @param student student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets loyalty points.
     *
     * @return loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets loyalty points.
     *
     * @param loyaltyPoints new points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
