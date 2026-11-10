/**
 * Represents a beverage sold at the campus cafe.
 *
 * @author Kayl Ceniza
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Default constructor.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Parameterized constructor.
     */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes the beverage price based on size.
     * @return final beverage price
     */
    @Override
    public double computePrice() {
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns beverage description.
     * @return description with size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets beverage size.
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets beverage size.
     * @param size S, M, or L
     */
    public void setSize(String size) {
        if (size != null) {
            if (size.equals("S") || size.equals("M")
                    || size.equals("L")) {
                this.size = size;
            }
        }
    }
}