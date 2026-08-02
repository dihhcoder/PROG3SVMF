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
    private JTextArea displayA1;
    private JTextArea displayA2;
    private JTextArea displayA3;
    private JTextArea displayB1;
    private JTextArea displayB2;
    private JTextArea displayB3;
    private JTextArea displayC1;
    private JTextArea displayC2;
    private JTextArea displayC3;

    private VendingMachine vendingMachine;

    private boolean isAdmin = false;
    private boolean inChute = false;
    private double currentCash = 0.0;
    private double currentChange = 0.0;
    private String currentSlot = "";
    private String currentItem = "";
    

    public VendingInterface(){

        vendingmach = new JFrame();
        vendingmach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingmach.setSize(450, 600);
        vendingmach.setLayout(new BorderLayout());
        vendingmach.setLocationRelativeTo(null);
        vendingmach.setResizable(false);

        CardLayout swap = new CardLayout();
        JPanel content = new JPanel(swap);

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
                if (inChute) {
                    JOptionPane.showMessageDialog(vendingmach, "Claimed: " + currentItem + "\nChange: P" + String.format("%.2f", currentChange));
                    inChute = false;
                    currentItem = "";
                    currentChange = 0.0;
                } else {
                    JOptionPane.showMessageDialog(vendingmach, "No item to claim");
                }
            }
        });

        dispDisplay = new JPanel();
        dispDisplay.setBackground(Color.lightGray);
        dispDisplay.setBounds(260, 35, 150, 150);
        dispDisplay.setLayout(null);
        dispDisplay.setVisible(true);

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
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        textDisplay.setHighlighter(null);
        textDisplay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(isAdmin){
                        vendingMachine.generateReceipt();
                        JOptionPane.showMessageDialog(vendingmach, "Audit Receipt successfully generated in folder!");
                    }
                }
            });
        textDisplay.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel a1 = new JLabel();
        a1.setText("A1");
        a1.setBounds(35, 100, 40, 20);
        a1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a1.setForeground(Color.WHITE);

        displayA1 = new JTextArea();
        displayA1.setBounds(10, 10, 60, 80);
        displayA1.setEditable(false);
        displayA1.setLineWrap(true);
        displayA1.setWrapStyleWord(true);
        displayA1.setHighlighter(null);
        displayA1.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel a2 = new JLabel();
        a2.setText("A2");
        a2.setBounds(103, 100, 40, 20);
        a2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a2.setForeground(Color.WHITE);

        displayA2 = new JTextArea();
        displayA2.setBounds(80, 10, 60, 80);
        displayA2.setEditable(false);
        displayA2.setLineWrap(true);
        displayA2.setWrapStyleWord(true);
        displayA2.setHighlighter(null);
        displayA2.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel a3 = new JLabel();
        a3.setText("A3");
        a3.setBounds(172, 100, 40, 20);
        a3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        a3.setForeground(Color.WHITE);

        displayA3 = new JTextArea();
        displayA3.setBounds(150, 10, 60, 80);
        displayA3.setEditable(false);
        displayA3.setLineWrap(true);
        displayA3.setWrapStyleWord(true);
        displayA3.setHighlighter(null);
        displayA3.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel b1 = new JLabel();
        b1.setText("B1");
        b1.setBounds(35, 220, 40, 20);
        b1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b1.setForeground(Color.WHITE);

        displayB1 = new JTextArea();
        displayB1.setBounds(10, 130, 60, 80);
        displayB1.setEditable(false);
        displayB1.setLineWrap(true);
        displayB1.setWrapStyleWord(true);
        displayB1.setHighlighter(null);
        displayB1.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel b2 = new JLabel();
        b2.setText("B2");
        b2.setBounds(103, 220, 40, 20);
        b2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b2.setForeground(Color.WHITE);

        displayB2 = new JTextArea();
        displayB2.setBounds(80, 130, 60, 80);
        displayB2.setEditable(false);
        displayB2.setLineWrap(true);
        displayB2.setWrapStyleWord(true);
        displayB2.setHighlighter(null);
        displayB2.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel b3 = new JLabel();
        b3.setText("B3");
        b3.setBounds(172, 220, 40, 20);
        b3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        b3.setForeground(Color.WHITE);

        displayB3 = new JTextArea();
        displayB3.setBounds(150, 130, 60, 80);
        displayB3.setEditable(false);
        displayB3.setLineWrap(true);
        displayB3.setWrapStyleWord(true);
        displayB3.setHighlighter(null);
        displayB3.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel c1 = new JLabel();
        c1.setText("C1");
        c1.setBounds(35, 340, 40, 20);
        c1.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c1.setForeground(Color.WHITE);

        displayC1 = new JTextArea();
        displayC1.setBounds(10, 250, 60, 80);
        displayC1.setEditable(false);
        displayC1.setLineWrap(true);
        displayC1.setWrapStyleWord(true);
        displayC1.setHighlighter(null);
        displayC1.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel c2 = new JLabel();
        c2.setText("C2");
        c2.setBounds(103, 340, 40, 20);
        c2.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c2.setForeground(Color.WHITE);

        displayC2 = new JTextArea();
        displayC2.setBounds(80, 250, 60, 80);
        displayC2.setEditable(false);
        displayC2.setLineWrap(true);
        displayC2.setWrapStyleWord(true);
        displayC2.setHighlighter(null);
        displayC2.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JLabel c3 = new JLabel();
        c3.setText("C3");
        c3.setBounds(172, 340, 40, 20);
        c3.setFont(new Font("Arial Black", Font.PLAIN, 10));
        c3.setForeground(Color.WHITE);

        displayC3 = new JTextArea();
        displayC3.setBounds(150, 250, 60, 80);
        displayC3.setEditable(false);
        displayC3.setLineWrap(true);
        displayC3.setWrapStyleWord(true);
        displayC3.setHighlighter(null);
        displayC3.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JPanel modifySlot = new JPanel();
        modifySlot.setBackground(new Color(126, 217, 87));
        modifySlot.setPreferredSize(new Dimension(450, 600));
        modifySlot.setLayout(null);
        modifySlot.setVisible(false);

        JPanel modifyVault = new JPanel();
        modifyVault.setBackground(new Color(126, 217, 87));
        modifyVault.setPreferredSize(new Dimension(450, 600));
        modifyVault.setLayout(null);
        modifyVault.setVisible(false);

        content.add(vendingfront, "VendingFront");
        vendingmach.add(content, BorderLayout.CENTER);
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
        slotDisplay.add(displayA1);
        slotDisplay.add(displayA2);
        slotDisplay.add(displayA3);
        slotDisplay.add(displayB1);
        slotDisplay.add(displayB2);
        slotDisplay.add(displayB3);
        slotDisplay.add(displayC1);
        slotDisplay.add(displayC2);
        slotDisplay.add(displayC3);
        dispDisplay.add(textDisplay);

        java.awt.event.ActionListener padListener = e -> {
            JButton btn = (JButton) e.getSource();
            if(currentSlot.length() < 2){
                currentSlot += btn.getText();
                updateScreen(null);
            }
        };

        aButton.addActionListener(padListener);
        bButton.addActionListener(padListener);
        cButton.addActionListener(padListener);
        oneButton.addActionListener(padListener);
        twoButton.addActionListener(padListener);
        threeButton.addActionListener(padListener);

        xButton.addActionListener(e -> {
            currentSlot = "";
            updateScreen(null);
        });

        bSButton.addActionListener(e -> {
            if (currentSlot.length() > 0) {
                currentSlot = currentSlot.substring(0, currentSlot.length() - 1);
                updateScreen(null);
            }
        });

        insert.addActionListener(e -> {
            if (!isAdmin && vendingMachine != null) {
                double val = Double.parseDouble(denomin.getSelectedItem().toString());
                vendingMachine.getUserCash().addCash(new Denomination(val, 1));
                currentCash = vendingMachine.getUserCash().getTotalValue();
                updateScreen(null);
            }
        });



        checkButton.addActionListener(e -> {
            if (!isAdmin && vendingMachine != null) {
                String input = currentSlot;
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
                if (!inChute) {
                    
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
                                    currentCash = 0.00;
                                    currentSlot = "";
                                    vendingMachine.getUserCash().getCashList().clear();
                                    updateScreen("Dispensed: " + dispensed.getName() + "\nChange: P" + String.format("%.2f", change) + "\nPlease claim item and change from the chute.");
                                    inChute = true;
                                    currentItem = dispensed.getName();
                                    currentChange = change;
                                } else {
                                    currentSlot = "";
                                    updateScreen("Not enough change in the machine!");
                                }
                            } else {
                                currentSlot = "";
                                updateScreen("Insufficient funds!");
                            }
                        } else {
                            currentSlot = "";
                            updateScreen("Slot is empty or out of stock!");
                        }
                    } else {
                        currentSlot = "";
                        updateScreen("Invalid Slot Code!");
                    }
                } else {
                    currentSlot = "";
                    updateScreen("Please claim your item first!");
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

    public void updateScreen(String errorMessage){
        StringBuilder sb = new StringBuilder();
        sb.append("Current Cash Total: P").append(String.format("%.2f", currentCash));
        if (errorMessage != null) {
            sb.append("\n").append(errorMessage);
        }
        sb.append("\nEnter Slot Code: \n>").append(currentSlot);
        textDisplay.setText(sb.toString());
    }

    public void testUser(VendingMachine vm, JFrame back){
        this.menuFrame = back;
        this.isAdmin = false;
        this.vendingMachine = vm;
        dispenseDisplay.setToolTipText("Claim Ordered Item");
        slotDisplay.setToolTipText(null);
        textDisplay.setToolTipText(null);
        denomButton.setToolTipText(null);
        displayA1.setText(vm.itemSlots.get(0).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(0).getPrice()) + ")");
        displayA2.setText(vm.itemSlots.get(1).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(1).getPrice()) + ")");
        displayA3.setText(vm.itemSlots.get(2).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(2).getPrice()) + ")");
        displayB1.setText(vm.itemSlots.get(3).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(3).getPrice()) + ")");
        displayB2.setText(vm.itemSlots.get(4).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(4).getPrice()) + ")");
        displayB3.setText(vm.itemSlots.get(5).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(5).getPrice()) + ")");
        displayC1.setText(vm.itemSlots.get(6).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(6).getPrice()) + ")");
        displayC2.setText(vm.itemSlots.get(7).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(7).getPrice()) + ")");
        displayC3.setText(vm.itemSlots.get(8).getItem().getName() + " (P" + String.format("%.2f", vm.itemSlots.get(8).getPrice()) + ")");

        updateScreen(null);
        denomButton.setVisible(false);
        setframeTitle(vm);
        back.setVisible(false);
        vendingmach.setVisible(true);
    }

    public void testAdmin(VendingMachine vm, JFrame back){
        testUser(vm, back);
        this.isAdmin = true;
        slotDisplay.setToolTipText("Manage Items in Slots");
        textDisplay.setToolTipText("Print audit statements");
        denomButton.setToolTipText("Manage Cash Vault");
        
        denomButton.setVisible(true);
    }
}