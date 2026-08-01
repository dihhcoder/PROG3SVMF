import java.util.ArrayList;

public class Special extends VendingMachine {
    
    public Special() {
        super();
        
        itemSlots.clear();
        
        Slots coneSlot = new Slots(new Item(null, 0, "Cone"), 100);
        Slots creamSlot = new Slots(new Item(null, 0, "Cream"), 50);
        Slots toppingSlot = new Slots(new Item(null, 0, "Topping"), 25);
        
        for (int i = 0; i < 10; i++) {
            coneSlot.addItem();
            creamSlot.addItem();
            toppingSlot.addItem();
        }
        
        itemSlots.add(coneSlot);
        itemSlots.add(creamSlot);
        itemSlots.add(toppingSlot);
    }


    public boolean processCombo(ArrayList<String> comboList) {

        double totalPrice = 0.0;
        double currentCash = checkCash(); 
        boolean itemFoundAndStocked;

        //checks if there are actually items in stock for all items
        for (String targetName : comboList) {
            itemFoundAndStocked = false;


        //note for myself in MP DEMO since I'll legit forget this type of for works by 
        //checking from first to last element of the arraylist, 
            for (Slots slot : itemSlots) {
                if (slot.getItem() != null && slot.getItem().getName().equalsIgnoreCase(targetName)) {
                    
                    if (slot.getCurrentStock() > 0) { 
                        itemFoundAndStocked = true;
                    }
                    break; //slot's been found quit and search the next item
                }
            }

            //If the item wasn't found, or its quantity was 0, cancel the entire combo
            if (!itemFoundAndStocked) {
                System.out.println("Order cancelled: " + targetName + " is currently out of stock!");
                return false;
            }
        }


        //calcualte the total price. 
        for (String targetName : comboList) {
            for (Slots slot : itemSlots) {
                if (slot.getItem() != null && slot.getItem().getName().equalsIgnoreCase(targetName)) {
                    totalPrice += slot.getPrice();
                    break; //I'm grateful this is prog3 and I can use break to exit a loop early 
                }
            }
        }

        //cash check, 
        if (currentCash < totalPrice) {
            System.out.println("Insufficient cash for this combo!");
            return false;
        }

        //checks if the machine can provide change
        double changeNeeded = currentCash - totalPrice;
        if (!checkChangeAvailability(changeNeeded)) { 
            System.out.println("Cannot process order: Insufficient change!");
            return false;
        }

        //dispense each ingredient individually using your inherited method
        for (String targetName : comboList) {
            dispenseItem(targetName); 
        }

        //Gives change
        giveChange(changeNeeded); 
        
        return true;
    }
}