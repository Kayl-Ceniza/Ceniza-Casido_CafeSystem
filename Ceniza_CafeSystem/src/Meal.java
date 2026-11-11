/**
 * Represents a rice meal sold at the campus cafe.
 *
 * @author Kayl Ceniza/Rowel Casido
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Parameterized constructor.
     */
    public Meal(String name, double basePrice,
                String itemCode, boolean upsized,
                int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes meal price.
     * @return final meal price
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += 12 * extraSides;

        return price;
    }

    /**
     * Returns meal description.
     * @return meal description
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();

        if (upsized) {
            description += " (Upsized)";
        }

        description += ", " + extraSides + " side(s)";

        return description;
    }

    /**
     * Gets upsized status.
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets upsized status.
     * @param upsized new status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets extra sides.
     * @return number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets extra sides.
     * @param extraSides number of sides
     */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
