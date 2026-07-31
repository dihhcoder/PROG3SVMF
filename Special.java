public class Special extends VendingMachine {
    public Special(){
        super();
        for (int i = 0; i < 3; i++){
            itemSlots.add(new Slots(new Item(null, 0, "Cone"), 0));
            itemSlots.add(new Slots(new Item(null, 0, "Cream"), 0));
            itemSlots.add(new Slots(new Item(null, 0, "Topping"), 0));
        }
    }
}