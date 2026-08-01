public class Regular extends VendingMachine {


    //the actual constructor that needs admin features to be made 
    /* 
    public Regular(){
        super();
        for(int i = 0; i < 9; i++)
            itemSlots.add(new Slots(null, 0));
    } */


    // temp constructor to test the functionality of the Regular Vending Machine

    public Regular(){
        super();
        
        // 1. Create the slots with placeholder Items (Name, Calories, Type) and Prices
        Slots a1 = new Slots(new Item("Nova", 120, "Snack"), 35);
        Slots a2 = new Slots(new Item("Coke", 140, "Beverage"), 40);
        Slots a3 = new Slots(new Item("Water", 0, "Beverage"), 20);
        
        Slots b1 = new Slots(new Item("Snickers", 250, "Candy"), 50);
        Slots b2 = new Slots(new Item("Lays", 150, "Snack"), 45);
        Slots b3 = new Slots(new Item("Oreo", 160, "Snack"), 40);
        
        Slots c1 = new Slots(new Item("Iced Tea", 90, "Beverage"), 30);
        Slots c2 = new Slots(new Item("Cup Noodles", 350, "Food"), 60);
        Slots c3 = new Slots(new Item("Mentos", 10, "Candy"), 15);

        // Put them in an array for easy looping
        Slots[] initialSlots = {a1, a2, a3, b1, b2, b3, c1, c2, c3};

        // 2. Add stock to each slot and push it to the vending machine's inventory
        for (Slots slot : initialSlots) {
            for (int i = 0; i < 10; i++) {
                slot.addItem();
            }
            itemSlots.add(slot);
        }

        // 3. NEW ADDITION: Stock the Cash Vault with starting change for testing!
        for (Denomination d : getCashVault().getCashList()) {
            d.setQuantity(20); 
        }
    }
}


