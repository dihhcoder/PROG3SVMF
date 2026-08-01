import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendingInterface {

    private JFrame vendingmach;
    private JFrame menuFrame;
    private JPanel vendingfront;
    private JPanel slotDisplay;
    private JPanel dispenseDisplay;
    private JPanel dispDisplay;
    private JButton backButton;
    private JButton insert;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton bSButton;
    private JButton xButton;
    private JButton checkButton;
    private JButton denomButton;
    private JComboBox<String> denomin;
    private JTextArea textDisplay;
    private boolean isAdmin = false;

    private VendingMachine vendingMachine;

    public VendingInterface(){

        vendingmach = new JFrame();
        vendingmach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingmach.setSize(450, 600);
        vendingmach.setLayout(new BorderLayout());
        vendingmach.setLocationRelativeTo(null);
        vendingmach.setResizable(false);

        vendingfront = new JPanel();
        vendingfront.setBackground(new Color(126, 217, 87));
        vendingfront.setPreferredSize(new Dimension(450, 600));
        vendingfront.setLayout(null);
        vendingfront.setVisible(true);

        slotDisplay = new JPanel();
        slotDisplay.setBackground(Color.BLUE);
        slotDisplay.setBounds(25, 35, 220, 400);
        slotDisplay.setLayout(null);
        slotDisplay.setVisible(true);
        slotDisplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(isAdmin){
                    JOptionPane.showMessageDialog(vendingmach, "Editing Slots");
                }
            }
        });

        dispenseDisplay = new JPanel();
        dispenseDisplay.setBackground(Color.lightGray);
        dispenseDisplay.setBounds(35, 470, 200, 50);
        dispenseDisplay.setLayout(null);
        dispenseDisplay.setVisible(true);
        dispenseDisplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(vendingmach, "Claimed Item");
            }
        });

        dispDisplay = new JPanel();
        dispDisplay.setBackground(Color.lightGray);
        dispDisplay.setBounds(260, 35, 150, 150);
        dispDisplay.setLayout(null);
        dispDisplay.setVisible(true);
        dispDisplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(isAdmin){
                        vendingMachine.generateReceipt();
                        JOptionPane.showMessageDialog(vendingmach, "Audit Receipt successfully generated in folder!");
                    }
                }
            }
        );

        aButton = new JButton();
        aButton.setText("A");
        aButton.setBounds(265, 200, 45, 40);

        bButton = new JButton();
        bButton.setText("B");
        bButton.setBounds(315, 200, 45, 40);

        cButton = new JButton();
        cButton.setText("C");
        cButton.setBounds(365, 200, 45, 40);

        oneButton = new JButton();
        oneButton.setText("1");
        oneButton.setBounds(265, 250, 45, 40);

        twoButton = new JButton();
        twoButton.setText("2");
        twoButton.setBounds(315, 250, 45, 40);

        threeButton = new JButton();
        threeButton.setText("3");
        threeButton.setBounds(365, 250, 45, 40);

        xButton = new JButton();
        xButton.setText("X");
        xButton.setBounds(265, 300, 45, 40);
        xButton.setToolTipText("Cancel");

        bSButton = new JButton();
        bSButton.setText("<-");
        bSButton.setBounds(315, 300, 45, 40);
        bSButton.setToolTipText("Backspace");

        checkButton = new JButton();
        checkButton.setText("/");
        checkButton.setBounds(365, 300, 45, 40);
        checkButton.setToolTipText("Confirm");

        String[] moneyList = {"0.01", "0.05", "0.10", "0.25", "1.00", "5.00", "10.00", "20.00", "50.00", "100.00", "200.00", "500.00", "1000.00"};
        denomin = new JComboBox<>(moneyList);
        denomin.setBounds(290, 360, 100, 20);
        denomin.setFocusable(false);

        insert = new JButton();
        insert.setText("Insert");
        insert.setBounds(295, 400, 90, 40);

        denomButton = new JButton();
        denomButton.setText(null);
        denomButton.setBounds(400, 360 , 20, 20);
        denomButton.setVisible(false);
        denomButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(isAdmin){
                    JOptionPane.showMessageDialog(vendingmach, "Editing Cash Vault");
                }
            }
        });
        
        backButton = new JButton();
        backButton.setText("Go Back");
        backButton.setBounds(295, 475, 90, 40);
        backButton.addActionListener(e -> {
            vendingmach.setVisible(false);
            menuFrame.setVisible(true);
        });

        textDisplay = new JTextArea();
        textDisplay.setBounds(10, 10, 130, 130);
        textDisplay.setEditable(false);
        textDisplay.getCaret().setVisible(false);

        JLabel a1 = new JLabel();
        a1.setText("A1");
        a1.setBounds(35, 100, 40, 20);
        a1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a1.setForeground(Color.WHITE);

        JLabel a2 = new JLabel();
        a2.setText("A2");
        a2.setBounds(100, 100, 40, 20);
        a2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a2.setForeground(Color.WHITE);

        JLabel a3 = new JLabel();
        a3.setText("A3");
        a3.setBounds(165, 100, 40, 20);
        a3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a3.setForeground(Color.WHITE);

        JLabel b1 = new JLabel();
        b1.setText("B1");
        b1.setBounds(35, 220, 40, 20);
        b1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b1.setForeground(Color.WHITE);

        JLabel b2 = new JLabel();
        b2.setText("B2");
        b2.setBounds(100, 220, 40, 20);
        b2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b2.setForeground(Color.WHITE);

        JLabel b3 = new JLabel();
        b3.setText("B3");
        b3.setBounds(165, 220, 40, 20);
        b3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b3.setForeground(Color.WHITE);

        JLabel c1 = new JLabel();
        c1.setText("C1");
        c1.setBounds(35, 340, 40, 20);
        c1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c1.setForeground(Color.WHITE);

        JLabel c2 = new JLabel();
        c2.setText("C2");
        c2.setBounds(100, 340, 40, 20);
        c2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c2.setForeground(Color.WHITE);

        JLabel c3 = new JLabel();
        c3.setText("C3");
        c3.setBounds(165, 340, 40, 20);
        c3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c3.setForeground(Color.WHITE);

        vendingmach.add(vendingfront);
        vendingfront.add(slotDisplay);
        vendingfront.add(dispenseDisplay);
        vendingfront.add(dispDisplay);
        vendingfront.add(aButton);
        vendingfront.add(bButton);
        vendingfront.add(cButton);
        vendingfront.add(oneButton);
        vendingfront.add(twoButton);
        vendingfront.add(threeButton);
        vendingfront.add(checkButton);
        vendingfront.add(bSButton);
        vendingfront.add(xButton);
        vendingfront.add(denomin);
        vendingfront.add(insert);
        vendingfront.add(backButton);
        vendingfront.add(denomButton);
        slotDisplay.add(a1);
        slotDisplay.add(a2);
        slotDisplay.add(a3);
        slotDisplay.add(b1);
        slotDisplay.add(b2);
        slotDisplay.add(b3);
        slotDisplay.add(c1);
        slotDisplay.add(c2);
        slotDisplay.add(c3);
        dispDisplay.add(textDisplay);

        java.awt.event.ActionListener padListener = e -> {
            JButton btn = (JButton) e.getSource();
            textDisplay.append(btn.getText());
        };

        aButton.addActionListener(padListener);
        bButton.addActionListener(padListener);
        cButton.addActionListener(padListener);
        oneButton.addActionListener(padListener);
        twoButton.addActionListener(padListener);
        threeButton.addActionListener(padListener);

        xButton.addActionListener(e -> textDisplay.setText(""));

        bSButton.addActionListener(e -> {
            String currentText = textDisplay.getText();
            if (currentText.length() > 0) {
                textDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        insert.addActionListener(e -> {
            if (!isAdmin && vendingMachine != null) {
                double val = Double.parseDouble(denomin.getSelectedItem().toString());
                vendingMachine.getUserCash().addCash(new Denomination(val, 1));
                JOptionPane.showMessageDialog(vendingmach, 
                    "Inserted: P" + val + "\nTotal Inserted: P" + vendingMachine.checkCash());
            }
        });

        checkButton.addActionListener(e -> {
            if (!isAdmin && vendingMachine != null) {
                String input = textDisplay.getText();
                int slotIndex = -1;
                
                switch(input) {
                    case "A1": slotIndex = 0; break;
                    case "A2": slotIndex = 1; break;
                    case "A3": slotIndex = 2; break;
                    case "B1": slotIndex = 3; break;
                    case "B2": slotIndex = 4; break;
                    case "B3": slotIndex = 5; break;
                    case "C1": slotIndex = 6; break;
                    case "C2": slotIndex = 7; break;
                    case "C3": slotIndex = 8; break;
                }

                if (slotIndex != -1 && slotIndex < vendingMachine.itemSlots.size()) {
                    Slots selectedSlot = vendingMachine.itemSlots.get(slotIndex);
                    
                    if (selectedSlot.getItem() != null && selectedSlot.getCurrentStock() > 0) {
                        double price = selectedSlot.getPrice();
                        double userCash = vendingMachine.checkCash();
                        
                        if (userCash >= price) {
                            double change = userCash - price;
                            
                            if (vendingMachine.checkChangeAvailability(change)) {
                                Item dispensed = vendingMachine.dispenseItem(selectedSlot.getItem().getName());
                                vendingMachine.giveChange(change);
                                JOptionPane.showMessageDialog(vendingmach, 
                                    "Dispensed: " + dispensed.getName() + "\nChange: P" + change);
                                textDisplay.setText("");
                                vendingMachine.getUserCash().getCashList().clear();
                            } else {
                                JOptionPane.showMessageDialog(vendingmach, "Not enough change in the machine!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(vendingmach, "Insufficient funds! Price is P" + price);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vendingmach, "That slot is empty or out of stock!");
                    }
                } else {
                    JOptionPane.showMessageDialog(vendingmach, "Invalid Slot Code!");
                    textDisplay.setText("");
                }
            }
        });
    }

    public void setframeTitle(VendingMachine vm){
        String vmType = null;

        if(vm instanceof Regular){
            vmType = "Regular Vending Machine";
        } else if (vm instanceof Special) {
            vmType = "Special Vending Machine";
        }
        vendingmach.setTitle(vmType);
    }

    public void testUser(VendingMachine vm, JFrame back){
        this.menuFrame = back;
        this.isAdmin = false;
        this.vendingMachine = vm;
        dispenseDisplay.setToolTipText("Claim Ordered Item");
        slotDisplay.setToolTipText(null);
        dispDisplay.setToolTipText(null);
        denomButton.setToolTipText(null);
        
        denomButton.setVisible(false);
        setframeTitle(vm);
        back.setVisible(false);
        vendingmach.setVisible(true);
    }

    public void testAdmin(VendingMachine vm, JFrame back){
        testUser(vm, back);
        this.isAdmin = true;
        slotDisplay.setToolTipText("Manage Items in Slots");
        dispDisplay.setToolTipText("Print audit statements");
        denomButton.setToolTipText("Manage Cash Vault");
        
        denomButton.setVisible(true);
    }
}