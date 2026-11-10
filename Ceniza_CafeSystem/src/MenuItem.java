/**
 * Represents the parent class of all cafe menu items.
 *
 * @author Kayl Ceniza
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the price of the menu item.
     * @return computed price
     */
    public abstract double computePrice();

    /**
     * Returns the item description.
     * @return item name and code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the item name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name.
     * @param name new item name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Gets the base price.
     * @return base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     * @param basePrice new price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /**
     * Gets the item code.
     * @return item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code.
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        }
    }
}