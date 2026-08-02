/**
 * Constructor class for Regular Vending Machine
 * @author Jasper Isiah Geronimo
 * @author John Kendrick Constantino
 */
public class Regular extends VendingMachine {
    /**
     * Creates a regular vending machine
     * Inherits vending machine attributes and methods
     */
    public Regular(){
        super();
        for(int i = 0; i < 9; i++)
            itemSlots.add(new Slots(null, 0));
    } 
}


