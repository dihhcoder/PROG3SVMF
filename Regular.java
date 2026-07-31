public class Regular extends VendingMachine {
    public Regular(){
        super();
        for(int i = 0; i < 9; i++)
        itemSlots.add(new Slots(null, 0));
    }
}