import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Constructor class for Vending machine object
 * @author Jasper Isiah Geronimo
 * @author John Kendrick Constantino
 */
public class VendingMachine {
    
    private CashStorage cashVault;
    private CashStorage userCash;
    protected ArrayList<Slots> itemSlots;

    /**
     * Creates a vending machine object
     */
    public VendingMachine(){
        this.cashVault = new CashStorage();
        this.itemSlots = new ArrayList<Slots>();
        this.userCash = new CashStorage();
    }

    /**
     * Gets the Cash Storage of the Vending Machine
     * @return the Cash Storage of the Vending Machine
     */
    public CashStorage getCashVault(){
        return this.cashVault;
    }

    /**
     * Gets the temporary cash storage of the customers of the vending machine
     * @return the temporary cash storage of the customers of the vending machine
     */
    public CashStorage getUserCash(){
        return this.userCash;
    }

    /**
     * Returns cash to the user and resets the temporary cash storage
     */
    public void returnCash() {
        for (Denomination d : userCash.getCashList()) {
            if (d.getQuantity() > 0) {
                System.out.println("Returning " + d.getQuantity() + " of P" + d.getValue());
            }
        }
        userCash = new CashStorage();
    }

    /**
     * Generates a file that contains audit and transactions of the vending machine since last stocking
     */
    public void generateReceipt() {
        try (FileWriter writter = new FileWriter("Receipt.txt")) { 
            double totalSalesRevenue = 0;
            int i;
            Slots s;
            double itemRevenue, totalVaultBalance, cashTotal;
            
            writter.write("Transaction Summary:\n");
            writter.write("Items Sold:\n");
            writter.write(String.format(" %-4s | %-15s | %-7s | %-12s | %-10s | %-6s | %-9s\n",
                "Slot", "Item Name", "Price", "Starting Stock", "Ending Stock", "Sold", "Revenue"));
            writter.write("---------------------------------------------------------------------------------\n");
            
            for (i = 0; i < itemSlots.size(); i++) { 
                s = itemSlots.get(i);
                if (s.getItem() != null) {
                    itemRevenue = s.getSold() * s.getPrice();
                    totalSalesRevenue += itemRevenue;
                    
                    writter.write(String.format(" [%d]  | %-15s | P%-6.2f | %-14d | %-12d | %-6d | P%.2f\n", 
                        (i + 1), s.getItem().getName(), s.getPrice(), s.getBeforeStock(), 
                        s.getCurrentStock(), s.getSold(), itemRevenue));
                    
                    s.resetSold();
                    s.setBeforeStock(s.getCurrentStock());
                } else {
                    writter.write(String.format(" [%d]  | %-15s | %-7s | %-14s | %-12s | %-6s | %-9s\n", 
                        (i + 1), "N/A", "-", "-", "-", "-", "-"));
                }
            }
            
            writter.write(String.format("Revenue Collected: P%.2f\n", totalSalesRevenue));
            writter.write("Current Cash Audit:\n");
            
            totalVaultBalance = 0;
            
            for (Denomination d : getCashVault().getCashList()) { 
                cashTotal = d.getValue() * d.getQuantity();
                totalVaultBalance += cashTotal;
                if (d.getQuantity() > 0) {
                    writter.write(String.format("  - Denomination: P%-7.2f | Count: %-4d | Subtotal: P%.2f\n", 
                        d.getValue(), d.getQuantity(), cashTotal));
                }
            }
            writter.write(String.format("Total Cash In Machine: P%.2f\n\n", totalVaultBalance));
            
        } catch (IOException e) {
            System.out.println("Could not write file");
        }
    }

    /**
     * Checks the total value of the denominations inserted
     * @return total ammount of cash inserted 
     */
    public double checkCash() {
        double totalCash = 0;
        for (Denomination d : getUserCash().getCashList()) {
            totalCash += d.getValue() * d.getQuantity();
        }
        return totalCash;
    }

    /**
     * checks for change availability by simulating the transaction first
     * @param changeAmount the change needed to be provided by the vending machine
     * @return true if change is available, else false
     */
    public boolean checkChangeAvailability(double changeAmount) {
        int i;
        CashStorage tempCashList;
        Denomination temp;
        
        tempCashList = new CashStorage(); 
        
        for (Denomination d : getCashVault().getCashList()) {
            tempCashList.addCash(new Denomination(d.getValue(), d.getQuantity()));
        }
        for (Denomination d : getUserCash().getCashList()) {
            tempCashList.addCash(new Denomination(d.getValue(), d.getQuantity()));
        }
        for (i = tempCashList.getCashList().size() - 1; i >= 0; i--) {
            temp = tempCashList.getCashList().get(i);
            while (changeAmount >= temp.getValue() && temp.getQuantity() > 0) {
                changeAmount -= temp.getValue();
                changeAmount = Math.round(changeAmount * 100.0) / 100.0;
                tempCashList.removeCash(new Denomination(temp.getValue(), 1));
                temp = tempCashList.getCashList().get(i);
            }
        }
        if (changeAmount == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * dispenses the item chosen to be purchased by the user
     * @param name the name of the Item that is being purchased
     * @return Item to be dispensed if item exists and has stock, else null
     */
    public Item dispenseItem(String name) {
        boolean itemFound = false;
        Item item = null;
        int i;
        Slots selectedItemSlot;
        
        for (i = 0; i < itemSlots.size() && !itemFound; i++) {
            selectedItemSlot = itemSlots.get(i);
            if (selectedItemSlot.getItem() != null
            && selectedItemSlot.getItem().getName().equalsIgnoreCase(name)) {
                itemFound = true;
                if (!selectedItemSlot.getItemList().isEmpty()) {
                    item = selectedItemSlot.getItemList().poll(); 
                    selectedItemSlot.incrementSold();
                    System.out.println("Dispensing item: " + item.getName());
                }
            }
        }
        if (!itemFound) {
            System.out.println("Item not found.");
        } else if (item == null) {
            System.out.println("Item is out of stock.");
        }
        return item;
    }

    /**
     * gives the change to the user after a successful transaction
     * @param changeAmount the change needed to be provided by the vending machine
     */
    public void giveChange(double changeAmount) {
        int i;
        Denomination temp;
        CashStorage changeDispensed;
        System.out.println("Calculating change for P" + changeAmount);
        
        changeDispensed = new CashStorage(); 
        
        for (i = getCashVault().getCashList().size() - 1; i >= 0; i--) {
            temp = getCashVault().getCashList().get(i);
            while (changeAmount >= temp.getValue() && temp.getQuantity() > 0) {
                changeAmount -= temp.getValue();
                changeAmount = Math.round(changeAmount * 100.0) / 100.0;
                getCashVault().removeCash(new Denomination(temp.getValue(), 1));
                changeDispensed.addCash(new Denomination(temp.getValue(), 1));
                temp = getCashVault().getCashList().get(i);
            }
        }
        System.out.println("Change provided successfully.");
        System.out.println("Returning change to customer...");
        for (Denomination d : changeDispensed.getCashList()) {
            if (d.getQuantity() > 0) {
                System.out.println("Returning " + d.getQuantity() 
                + " of P" + d.getValue());
            }
        }
    }
}