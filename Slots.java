import java.util.ArrayDeque;
/**
 * The Constructor Class for the Vending Machine Slots
 * @author Jasper Isiah Geronimo
 * @author John Kendrick Constantino
 */
public class Slots
{
    private Item item;
    private ArrayDeque<Item> ItemList;
    private int capacity;
    private double price;
    private int sold;
    private int beforeStock;

    /**
     * Creates a slot for the vending machine
     * @param item The item to be put in the slot
     * @param price The price of the items in the slot
     */
    public Slots(Item item, double price)
    {
        this.ItemList = new ArrayDeque<Item>();
        this.item = item;
        this.capacity = 10;
        this.price = price;
        this.sold = 0;
        this.beforeStock = 0;
    }

    /**
     * Gets the list of items in the slot
     * @return The list of items in the slot
     */
    public ArrayDeque<Item> getItemList()
    {   
        return ItemList;
    }
     
    /**
     * Gets the capacity of the slot
     * @return The capacity of the slot
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Gets the price of all items in the slot
     * @return The price of the items in the slot
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Gets the item assigned to the slot
     * @return The item on the slot
     */
    public Item getItem()
    {
        return item;
    }
    
    /**
     * Gets the number of sold items on this slot
     * @return The number of sold items
     */
    public int getSold()
    {
        return sold;
    }

    /**
     * Gets the number of items on the slot before restocking
     * @return number of items on the slot before restocking
     */
    public int getBeforeStock()
    {
        return beforeStock;
    }

    /**
     * Gets the amount of stock currently in the slot
     * @return current number of stock in slot
     */
    public int getCurrentStock()
    {
        return ItemList.size();
    }

    /**
     * Sets the item assigned to slot
     * @param item The item to be assigned to slot
     */
    public void setItem(Item item)
    {
        this.item = item;
    }

    /**
     * Sets the price of the items on the slot
     * @param price The new price to be set onto the items
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Sets the number of stock in the slot before the next modifying of stock amounts and auditing
     * @param before the amount of stocks in the slot before the next audit/ modification of stock numbers
     */
    public void setBeforeStock(int before){
        this.beforeStock = before;
    }

    /**
     * Adds an item to the arraylist without going out of bounds with regards to capacity
     */
    public void addItem()
    {
        this.ItemList.add(new Item(getItem().getName(), getItem().getCalories(), getItem().getType()));   
    }

    /**
     * Removes an item from the arraydeque
     */
    public void removeItem()
    {
        this.ItemList.poll();
    }

    /**
     * Increments the sold counter when a transaction has been made
     */
    public void incrementSold()
    {
        this.sold++;
    }

    /**
     * Resets the sold counter after an audit
     */
    public void resetSold(){
        this.sold = 0;
    }
}