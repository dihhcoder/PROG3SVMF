/**
 * Constructor class for item (products)
 * @author Jasper Isiah Geronimo
 * @author John Kendrick Constantino
 */
public class Item
{
    private String name;
    private double calories;
    private String type;

    /**
     * Creates an item object
     * <p>
     * This is the product/s of the vending machine
     * @param name The name of the item to be sold
     * @param calories The amount of calories the item has
     */
    public Item(String name, double calories, String type) 
    {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }
    
    public Item(String name, double calories) 
    {
        this.name = name;
        this.calories = calories;
    }

    /**
     * Gets the product name
     * @return The product's name
     */
    public String getName() 
    {
        return this.name;
    }

    /**
     * Gets the calories of the product
     * @return The amount of calories on the product
     */
    public double getCalories() 
    {
        return this.calories;
    }

    /**
     * Gets the type of the product
     * @return The type of product that the item is
     */
    public String getType(){
        return this.type;
    }
}