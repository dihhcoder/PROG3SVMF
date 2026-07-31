import java.util.*;
public class VendingMachine {
    
    private CashStorage cashVault;
    private CashStorage userCash;
    protected ArrayList<Slots> itemSlots;
    public VendingMachine(){
        this.cashVault = new CashStorage();
        this.itemSlots = new ArrayList<Slots>();
        this.userCash = new CashStorage();
    }

    public CashStorage getCashVault(){
        return this.cashVault;
    }
}