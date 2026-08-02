import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private String A1;
    private String A2;
    private String A3;
    private String B1;
    private String B2;
    private String B3;
    private String C1;
    private String C2;
    private String C3;
    private int current001 = 0;
    private int current005 = 0;
    private int current010 = 0;
    private int current025 = 0;
    private int current100 = 0;
    private int current500 = 0;
    private int current1000 = 0;
    private int current2000 = 0;
    private int current5000 = 0;
    private int current10000 = 0;
    private int current20000 = 0;
    private int current50000 = 0;
    private int current100000 = 0;

    private JTextField denom001Field;
    private JButton denom001Minus;
    private JButton denom001Plus;

    private JTextField denom005Field;
    private JButton denom005Minus;
    private JButton denom005Plus;

    private JTextField denom010Field;
    private JButton denom010Minus;
    private JButton denom010Plus;

    private JTextField denom025Field;
    private JButton denom025Minus;
    private JButton denom025Plus;

    private JTextField denom100Field;
    private JButton denom100Minus;
    private JButton denom100Plus;

    private JTextField denom500Field;
    private JButton denom500Minus;
    private JButton denom500Plus;

    private JTextField denom1000Field;
    private JButton denom1000Minus;
    private JButton denom1000Plus;

    private JTextField denom2000Field;
    private JButton denom2000Minus;
    private JButton denom2000Plus;

    private JTextField denom5000Field;
    private JButton denom5000Minus;
    private JButton denom5000Plus;

    private JTextField denom10000Field;
    private JButton denom10000Minus;
    private JButton denom10000Plus;

    private JTextField denom20000Field;
    private JButton denom20000Minus;
    private JButton denom20000Plus;

    private JTextField denom50000Field;
    private JButton denom50000Minus;
    private JButton denom50000Plus;

    private JTextField denom100000Field;
    private JButton denom100000Minus;
    private JButton denom100000Plus;

    private JLabel manageTitle;
    private JTextField slotA1Field;
    private JTextField slotA2Field;
    private JTextField slotA3Field;
    private JTextField slotB1Field;
    private JTextField slotB2Field;
    private JTextField slotB3Field;
    private JTextField slotC1Field;
    private JTextField slotC2Field;
    private JTextField slotC3Field;

    private JLabel manageItemType;
    private JTextField itemType;
    private JTextField itemName;
    private JTextField itemPrice;
    private JTextField itemCalorie;
    private JTextField itemCount;

    private Slots managingSlot;
    private String currItemName;
    private double currItemPrice;
    private double currItemCalorie;
    private int currItemCount;
    private String currItemType;


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
                    swap.show(content, "ModifySlot");
                    updateSlotNames(vendingMachine);
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
                    swap.show(content, "ModifyVault");
                    updateDenominationFields(vendingMachine);
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

        JPanel modifyVault = new JPanel();
        modifyVault.setBackground(new Color(126, 217, 87));
        modifyVault.setPreferredSize(new Dimension(450, 600));
        modifyVault.setLayout(null);
        modifyVault.setVisible(false);

        JLabel vaultIns = new JLabel();
        vaultIns.setText("Modify Cash Vault");
        vaultIns.setForeground(Color.WHITE);
        vaultIns.setFont(new Font("Arial Black", Font.PLAIN, 20));
        vaultIns.setBounds(40, 10, 250, 30);

        JLabel denom001 = new JLabel();
        denom001.setText("P0.01");
        denom001.setForeground(Color.WHITE);
        denom001.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom001.setBounds(50, 50, 100, 20);

        JLabel denom005 = new JLabel();
        denom005.setText("P0.05");
        denom005.setForeground(Color.WHITE);
        denom005.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom005.setBounds(50, 80, 100, 20);

        JLabel denom010 = new JLabel();
        denom010.setText("P0.10");
        denom010.setForeground(Color.WHITE);
        denom010.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom010.setBounds(50, 110, 100, 20);

        JLabel denom025 = new JLabel();
        denom025.setText("P0.25");
        denom025.setForeground(Color.WHITE);
        denom025.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom025.setBounds(50, 140, 100, 20);

        JLabel denom100 = new JLabel();
        denom100.setText("P1.00");
        denom100.setForeground(Color.WHITE);
        denom100.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom100.setBounds(50, 170, 100, 20);

        JLabel denom500 = new JLabel();
        denom500.setText("P5.00");
        denom500.setForeground(Color.WHITE);
        denom500.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom500.setBounds(50, 200, 100, 20);

        JLabel denom1000 = new JLabel();
        denom1000.setText("P10.00");
        denom1000.setForeground(Color.WHITE);
        denom1000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom1000.setBounds(50, 230, 100, 20);

        JLabel denom2000 = new JLabel();
        denom2000.setText("P20.00");
        denom2000.setForeground(Color.WHITE);
        denom2000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom2000.setBounds(50, 260, 100, 20);

        JLabel denom5000 = new JLabel();
        denom5000.setText("P50.00");
        denom5000.setForeground(Color.WHITE);
        denom5000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom5000.setBounds(50, 290, 100, 20);

        JLabel denom10000 = new JLabel();
        denom10000.setText("P100.00");
        denom10000.setForeground(Color.WHITE);
        denom10000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom10000.setBounds(50, 320, 100, 20);

        JLabel denom20000 = new JLabel();
        denom20000.setText("P200.00");
        denom20000.setForeground(Color.WHITE);
        denom20000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom20000.setBounds(50, 350, 100, 20);

        JLabel denom50000 = new JLabel();
        denom50000.setText("P500.00");
        denom50000.setForeground(Color.WHITE);
        denom50000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom50000.setBounds(50, 380, 100, 20);

        JLabel denom100000 = new JLabel();
        denom100000.setText("P1000.00");
        denom100000.setForeground(Color.WHITE);
        denom100000.setFont(new Font("Arial Black", Font.PLAIN, 12));
        denom100000.setBounds(50, 410, 100, 20);

        denom001Field = new JTextField();
        denom001Field.setBounds(310, 50, 50, 20);
        denom001Field.setEditable(true);
        denom001Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom001Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom001Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom001Field.getText().trim().isEmpty()) {
                    denom001Field.setText("0");
                }
            }
        });

        denom001Minus = new JButton();
        denom001Minus.setText("-");
        denom001Minus.setBounds(250, 50, 50, 20);
        denom001Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom001Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom001Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom001Plus = new JButton();
        denom001Plus.setText("+");
        denom001Plus.setBounds(370, 50, 50, 20);
        denom001Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom001Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom001Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom005Field = new JTextField();
        denom005Field.setBounds(310, 80, 50, 20);
        denom005Field.setEditable(true);
        denom005Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom005Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom005Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom005Field.getText().trim().isEmpty()) {
                    denom005Field.setText("0");
                }
            }
        });

        denom005Minus = new JButton();
        denom005Minus.setText("-");
        denom005Minus.setBounds(250, 80, 50, 20);
        denom005Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom005Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom005Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom005Plus = new JButton();
        denom005Plus.setText("+");
        denom005Plus.setBounds(370, 80, 50, 20);
        denom005Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom005Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom005Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom010Field = new JTextField();
        denom010Field.setBounds(310, 110, 50, 20);
        denom010Field.setEditable(true);
        denom010Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom010Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom010Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom010Field.getText().trim().isEmpty()) {
                    denom010Field.setText("0");
                }
            }
        });

        denom010Minus = new JButton();
        denom010Minus.setText("-");
        denom010Minus.setBounds(250, 110, 50, 20);
        denom010Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom010Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom010Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom010Plus = new JButton();
        denom010Plus.setText("+");
        denom010Plus.setBounds(370, 110, 50, 20);
        denom010Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom010Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom010Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom025Field = new JTextField();
        denom025Field.setBounds(310, 140, 50, 20);
        denom025Field.setEditable(true);
        denom025Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom025Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom025Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom025Field.getText().trim().isEmpty()) {
                    denom025Field.setText("0");
                }
            }
        });

        denom025Minus = new JButton();
        denom025Minus.setText("-");
        denom025Minus.setBounds(250, 140, 50, 20);
        denom025Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom025Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom025Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom025Plus = new JButton();
        denom025Plus.setText("+");
        denom025Plus.setBounds(370, 140, 50, 20);
        denom025Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom025Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom025Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom100Field = new JTextField();
        denom100Field.setBounds(310, 170, 50, 20);
        denom100Field.setEditable(true);
        denom100Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom100Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom100Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom100Field.getText().trim().isEmpty()) {
                    denom100Field.setText("0");
                }
            }
        });

        denom100Minus = new JButton();
        denom100Minus.setText("-");
        denom100Minus.setBounds(250, 170, 50, 20);
        denom100Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom100Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom100Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom100Plus = new JButton();
        denom100Plus.setText("+");
        denom100Plus.setBounds(370, 170, 50, 20);
        denom100Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom100Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom100Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom500Field = new JTextField();
        denom500Field.setBounds(310, 200, 50, 20);
        denom500Field.setEditable(true);
        denom500Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom500Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom500Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom500Field.getText().trim().isEmpty()) {
                    denom500Field.setText("0");
                }
            }
        });

        denom500Minus = new JButton();
        denom500Minus.setText("-");
        denom500Minus.setBounds(250, 200, 50, 20);
        denom500Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom500Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom500Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom500Plus = new JButton();
        denom500Plus.setText("+");
        denom500Plus.setBounds(370, 200, 50, 20);
        denom500Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom500Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom500Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom1000Field = new JTextField();
        denom1000Field.setBounds(310, 230, 50, 20);
        denom1000Field.setEditable(true);
        denom1000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom1000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom1000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom1000Field.getText().trim().isEmpty()) {
                    denom1000Field.setText("0");
                }
            }
        });

        denom1000Minus = new JButton();
        denom1000Minus.setText("-");
        denom1000Minus.setBounds(250, 230, 50, 20);
        denom1000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom1000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom1000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom1000Plus = new JButton();
        denom1000Plus.setText("+");
        denom1000Plus.setBounds(370, 230, 50, 20);
        denom1000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom1000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom1000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom2000Field = new JTextField();
        denom2000Field.setBounds(310, 260, 50, 20);
        denom2000Field.setEditable(true);
        denom2000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom2000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom2000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom2000Field.getText().trim().isEmpty()) {
                    denom2000Field.setText("0");
                }
            }
        });

        denom2000Minus = new JButton();
        denom2000Minus.setText("-");
        denom2000Minus.setBounds(250, 260, 50, 20);
        denom2000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom2000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom2000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom2000Plus = new JButton();
        denom2000Plus.setText("+");
        denom2000Plus.setBounds(370, 260, 50, 20);
        denom2000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom2000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom2000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom5000Field = new JTextField();
        denom5000Field.setBounds(310, 290, 50, 20);
        denom5000Field.setEditable(true);
        denom5000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom5000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom5000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom5000Field.getText().trim().isEmpty()) {
                    denom5000Field.setText("0");
                }
            }
        });

        denom5000Minus = new JButton();
        denom5000Minus.setText("-");
        denom5000Minus.setBounds(250, 290, 50, 20);
        denom5000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom5000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom5000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom5000Plus = new JButton();
        denom5000Plus.setText("+");
        denom5000Plus.setBounds(370, 290, 50, 20);
        denom5000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom5000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom5000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom10000Field = new JTextField();
        denom10000Field.setBounds(310, 320, 50, 20);
        denom10000Field.setEditable(true);
        denom10000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom10000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom10000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom10000Field.getText().trim().isEmpty()) {
                    denom10000Field.setText("0");
                }
            }
        });

        denom10000Minus = new JButton();
        denom10000Minus.setText("-");
        denom10000Minus.setBounds(250, 320, 50, 20);
        denom10000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom10000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom10000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom10000Plus = new JButton();
        denom10000Plus.setText("+");
        denom10000Plus.setBounds(370, 320, 50, 20);
        denom10000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom10000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom10000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom20000Field = new JTextField();
        denom20000Field.setBounds(310, 350, 50, 20);
        denom20000Field.setEditable(true);
        denom20000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom20000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom20000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom20000Field.getText().trim().isEmpty()) {
                    denom20000Field.setText("0");
                }
            }
        });

        denom20000Minus = new JButton();
        denom20000Minus.setText("-");
        denom20000Minus.setBounds(250, 350, 50, 20);
        denom20000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom20000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom20000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom20000Plus = new JButton();
        denom20000Plus.setText("+");
        denom20000Plus.setBounds(370, 350, 50, 20);
        denom20000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom20000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom20000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom50000Field = new JTextField();
        denom50000Field.setBounds(310, 380, 50, 20);
        denom50000Field.setEditable(true);
        denom50000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom50000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom50000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom50000Field.getText().trim().isEmpty()) {
                    denom50000Field.setText("0");
                }
            }
        });

        denom50000Minus = new JButton();
        denom50000Minus.setText("-");
        denom50000Minus.setBounds(250, 380, 50, 20);
        denom50000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom50000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom50000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom50000Plus = new JButton();
        denom50000Plus.setText("+");
        denom50000Plus.setBounds(370, 380, 50, 20);
        denom50000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom50000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom50000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom100000Field = new JTextField();
        denom100000Field.setBounds(310, 410, 50, 20);
        denom100000Field.setEditable(true);
        denom100000Field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || denom100000Field.getText().length() >= 4) {
                    e.consume();
                }
            }
        });
        denom100000Field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (denom100000Field.getText().trim().isEmpty()) {
                    denom100000Field.setText("0");
                }
            }
        });

        denom100000Minus = new JButton();
        denom100000Minus.setText("-");
        denom100000Minus.setBounds(250, 410, 50, 20);
        denom100000Minus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom100000Field.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                denom100000Field.setText(String.valueOf(currentQuantity));
            }
        });

        denom100000Plus = new JButton();
        denom100000Plus.setText("+");
        denom100000Plus.setBounds(370, 410, 50, 20);
        denom100000Plus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(denom100000Field.getText());
            if (currentQuantity < 9999) {
                currentQuantity++;
                denom100000Field.setText(String.valueOf(currentQuantity));
            }
        });


        JButton denomBack = new JButton();
        denomBack.setText("Go Back");
        denomBack.setBounds(295, 475, 90, 40);
        denomBack.addActionListener(e -> {
            if(current001 != Integer.parseInt(denom001Field.getText()) || current005 != Integer.parseInt(denom005Field.getText()) || current010 != Integer.parseInt(denom010Field.getText()) || current025 != Integer.parseInt(denom025Field.getText()) || current100 != Integer.parseInt(denom100Field.getText()) || current500 != Integer.parseInt(denom500Field.getText()) || current1000 != Integer.parseInt(denom1000Field.getText()) || current2000 != Integer.parseInt(denom2000Field.getText()) || current5000 != Integer.parseInt(denom5000Field.getText()) || current10000 != Integer.parseInt(denom10000Field.getText()) || current20000 != Integer.parseInt(denom20000Field.getText()) || current50000 != Integer.parseInt(denom50000Field.getText()) || current100000 != Integer.parseInt(denom100000Field.getText())){
                int result = JOptionPane.showConfirmDialog(vendingmach, "Are you sure you want to go back? Unsaved changes will be lost.", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    swap.show(content, "VendingFront");
                }
            } else {
                swap.show(content, "VendingFront");
            }
        });

        JButton denomUpdate = new JButton();
        denomUpdate.setText("Update");
        denomUpdate.setBounds(45, 475, 90, 40);
        denomUpdate.addActionListener(e -> {

            String typed001 = denom001Field.getText().trim();
            String typed005 = denom005Field.getText().trim();
            String typed010 = denom010Field.getText().trim();
            String typed025 = denom025Field.getText().trim();
            String typed100 = denom100Field.getText().trim();
            String typed500 = denom500Field.getText().trim();
            String typed1000 = denom1000Field.getText().trim();
            String typed2000 = denom2000Field.getText().trim();
            String typed5000 = denom5000Field.getText().trim();
            String typed10000 = denom10000Field.getText().trim();
            String typed20000 = denom20000Field.getText().trim();
            String typed50000 = denom50000Field.getText().trim();
            String typed100000 = denom100000Field.getText().trim();

            String compare001 = typed001.isEmpty() ? "0" : typed001;
            String compare005 = typed005.isEmpty() ? "0" : typed005;
            String compare010 = typed010.isEmpty() ? "0" : typed010;
            String compare025 = typed025.isEmpty() ? "0" : typed025;
            String compare100 = typed100.isEmpty() ? "0" : typed100;
            String compare500 = typed500.isEmpty() ? "0" : typed500;
            String compare1000 = typed1000.isEmpty() ? "0" : typed1000;
            String compare2000 = typed2000.isEmpty() ? "0" : typed2000;
            String compare5000 = typed5000.isEmpty() ? "0" : typed5000;
            String compare10000 = typed10000.isEmpty() ? "0" : typed10000;
            String compare20000 = typed20000.isEmpty() ? "0" : typed20000;
            String compare50000 = typed50000.isEmpty() ? "0" : typed50000;
            String compare100000 = typed100000.isEmpty() ? "0" : typed100000;

            if(!String.valueOf(current001).equals(compare001)){
                vendingMachine.getCashVault().getCashList().get(0).setQuantity(Integer.parseInt(compare001));
                current001 = Integer.parseInt(compare001);
            }
            if(!String.valueOf(current005).equals(compare005)){
                vendingMachine.getCashVault().getCashList().get(1).setQuantity(Integer.parseInt(compare005));
                current005 = Integer.parseInt(compare005);
            }
            if(!String.valueOf(current010).equals(compare010)){
                vendingMachine.getCashVault().getCashList().get(2).setQuantity(Integer.parseInt(compare010));
                current010 = Integer.parseInt(compare010);
            }
            if(!String.valueOf(current025).equals(compare025)){
                vendingMachine.getCashVault().getCashList().get(3).setQuantity(Integer.parseInt(compare025));
                current025 = Integer.parseInt(compare025);
            }
            if(!String.valueOf(current100).equals(compare100)){
                vendingMachine.getCashVault().getCashList().get(4).setQuantity(Integer.parseInt(compare100));
                current100 = Integer.parseInt(compare100);
            }
            if(!String.valueOf(current500).equals(compare500)){
                vendingMachine.getCashVault().getCashList().get(5).setQuantity(Integer.parseInt(compare500));
                current500 = Integer.parseInt(compare500);
            }
            if(!String.valueOf(current1000).equals(compare1000)){
                vendingMachine.getCashVault().getCashList().get(6).setQuantity(Integer.parseInt(compare1000));
                current1000 = Integer.parseInt(compare1000);
            }
            if(!String.valueOf(current2000).equals(compare2000)){
                vendingMachine.getCashVault().getCashList().get(7).setQuantity(Integer.parseInt(compare2000));
                current2000 = Integer.parseInt(compare2000);
            }
            if(!String.valueOf(current5000).equals(compare5000)){
                vendingMachine.getCashVault().getCashList().get(8).setQuantity(Integer.parseInt(compare5000));
                current5000 = Integer.parseInt(compare5000);
            }
            if(!String.valueOf(current10000).equals(compare10000)){
                vendingMachine.getCashVault().getCashList().get(9).setQuantity(Integer.parseInt(compare10000));
                current10000 = Integer.parseInt(compare10000);
            }
            if(!String.valueOf(current20000).equals(compare20000)){
                vendingMachine.getCashVault().getCashList().get(10).setQuantity(Integer.parseInt(compare20000));
                current20000 = Integer.parseInt(compare20000);
            }
            if(!String.valueOf(current50000).equals(compare50000)){
                vendingMachine.getCashVault().getCashList().get(11).setQuantity(Integer.parseInt(compare50000));
                current50000 = Integer.parseInt(compare50000);
            }
            if(!String.valueOf(current100000).equals(compare100000)){
                vendingMachine.getCashVault().getCashList().get(12).setQuantity(Integer.parseInt(compare100000));
                current100000 = Integer.parseInt(compare100000);
            }
        });

        JPanel modifySlot = new JPanel();
        modifySlot.setBackground(new Color(126, 217, 87));
        modifySlot.setPreferredSize(new Dimension(450, 600));
        modifySlot.setLayout(null);
        modifySlot.setVisible(false);

        JButton slotBack = new JButton();
        slotBack.setText("Go Back");
        slotBack.setBounds(295, 475, 90, 40);
        slotBack.addActionListener(e -> {
                swap.show(content, "VendingFront");
        });

        JLabel slotIns = new JLabel();
        slotIns.setText("Modify Slot");
        slotIns.setForeground(Color.WHITE);
        slotIns.setFont(new Font("Arial Black", Font.PLAIN, 20));
        slotIns.setBounds(40, 10, 250, 30);

        JLabel slotNameLabel = new JLabel("Slot:");
        slotNameLabel.setForeground(Color.WHITE);
        slotNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotNameLabel.setBounds(20, 50, 100, 20);

        JLabel slotItemLabel = new JLabel("Item:");
        slotItemLabel.setForeground(Color.WHITE);
        slotItemLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotItemLabel.setBounds(60, 50, 100, 20);

        JLabel slotA1 = new JLabel("A1");
        slotA1.setForeground(Color.WHITE);
        slotA1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotA1.setBounds(20, 80, 100, 20);

        JLabel slotA2 = new JLabel("A2");
        slotA2.setForeground(Color.WHITE);
        slotA2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotA2.setBounds(20, 120, 100, 20);

        JLabel slotA3 = new JLabel("A3");
        slotA3.setForeground(Color.WHITE);
        slotA3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotA3.setBounds(20, 160, 100, 20);

        JLabel slotB1 = new JLabel("B1");
        slotB1.setForeground(Color.WHITE);
        slotB1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotB1.setBounds(20, 200, 100, 20);

        JLabel slotB2 = new JLabel("B2");
        slotB2.setForeground(Color.WHITE);
        slotB2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotB2.setBounds(20, 240, 100, 20);

        JLabel slotB3 = new JLabel("B3");
        slotB3.setForeground(Color.WHITE);
        slotB3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotB3.setBounds(20, 280, 100, 20);

        JLabel slotC1 = new JLabel("C1");
        slotC1.setForeground(Color.WHITE);
        slotC1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotC1.setBounds(20, 320, 100, 20);

        JLabel slotC2 = new JLabel("C2");
        slotC2.setForeground(Color.WHITE);
        slotC2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotC2.setBounds(20, 360, 100, 20);

        JLabel slotC3 = new JLabel("C3");
        slotC3.setForeground(Color.WHITE);
        slotC3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        slotC3.setBounds(20, 400, 100, 20);

        slotA1Field = new JTextField();
        slotA1Field.setBounds(60, 80, 200, 20);
        slotA1Field.setEditable(false);
        slotA1Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotA2Field = new JTextField();
        slotA2Field.setBounds(60, 120, 200, 20);
        slotA2Field.setEditable(false);
        slotA2Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotA3Field = new JTextField();
        slotA3Field.setBounds(60, 160, 200, 20);
        slotA3Field.setEditable(false);
        slotA3Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotB1Field = new JTextField();
        slotB1Field.setBounds(60, 200, 200, 20);
        slotB1Field.setEditable(false);
        slotB1Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotB2Field = new JTextField();
        slotB2Field.setBounds(60, 240, 200, 20);
        slotB2Field.setEditable(false);
        slotB2Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotB3Field = new JTextField();
        slotB3Field.setBounds(60, 280, 200, 20);
        slotB3Field.setEditable(false);
        slotB3Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotC1Field = new JTextField();
        slotC1Field.setBounds(60, 320, 200, 20);
        slotC1Field.setEditable(false);
        slotC1Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotC2Field = new JTextField();
        slotC2Field.setBounds(60, 360, 200, 20);
        slotC2Field.setEditable(false);
        slotC2Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        slotC3Field = new JTextField();
        slotC3Field.setBounds(60, 400, 200, 20);
        slotC3Field.setEditable(false);
        slotC3Field.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void paint(java.awt.Graphics g) {   
                }
            });

        JButton manageA1 = new JButton();
        manageA1.setText("Manage");
        manageA1.setBounds(300, 80, 100, 20);
        manageA1.addActionListener(e -> {
            manageTitle.setText("Manage A1");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(0));
        });

        JButton manageA2 = new JButton();
        manageA2.setText("Manage");
        manageA2.setBounds(300, 120, 100, 20);
        manageA2.addActionListener(e -> {
            manageTitle.setText("Manage A2");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(1));
        });

        JButton manageA3 = new JButton();
        manageA3.setText("Manage");
        manageA3.setBounds(300, 160, 100, 20);
        manageA3.addActionListener(e -> {
            manageTitle.setText("Manage A3");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(2));
        });

        JButton manageB1 = new JButton();
        manageB1.setText("Manage");
        manageB1.setBounds(300, 200, 100, 20);
        manageB1.addActionListener(e -> {
            manageTitle.setText("Manage B1");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(3));
        });

        JButton manageB2 = new JButton();
        manageB2.setText("Manage");
        manageB2.setBounds(300, 240, 100, 20);
        manageB2.addActionListener(e -> {
            manageTitle.setText("Manage B2");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(4));
        });

        JButton manageB3 = new JButton();
        manageB3.setText("Manage");
        manageB3.setBounds(300, 280, 100, 20);
        manageB3.addActionListener(e -> {
            manageTitle.setText("Manage B3");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(5));
        });

        JButton manageC1 = new JButton();
        manageC1.setText("Manage");
        manageC1.setBounds(300, 320, 100, 20);
        manageC1.addActionListener(e -> {
            manageTitle.setText("Manage C1");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(6));
        });

        JButton manageC2 = new JButton();
        manageC2.setText("Manage");
        manageC2.setBounds(300, 360, 100, 20);
        manageC2.addActionListener(e -> {
            manageTitle.setText("Manage C2");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(7));
        });

        JButton manageC3 = new JButton();
        manageC3.setText("Manage");
        manageC3.setBounds(300, 400, 100, 20);
        manageC3.addActionListener(e -> {
            manageTitle.setText("Manage C3");
            swap.show(content, "ManageSlot");
            manageSlot(vendingMachine.itemSlots.get(8));
        });

        JPanel manageSelectedSlot = new JPanel();
        manageSelectedSlot.setBackground(new Color(126, 217, 87));
        manageSelectedSlot.setPreferredSize(new Dimension(450, 600));
        manageSelectedSlot.setLayout(null);
        manageSelectedSlot.setVisible(false);

        manageTitle = new JLabel();
        manageTitle.setFont(new Font("Arial Black", Font.PLAIN, 20));
        manageTitle.setForeground(Color.WHITE);
        manageTitle.setBounds(40, 10, 250, 30);

        JLabel manageItemName = new JLabel("Item Name:");
        manageItemName.setFont(new Font("Arial Black", Font.PLAIN, 18));
        manageItemName.setForeground(Color.WHITE);
        manageItemName.setBounds(50, 50, 250, 30);

        itemName = new JTextField();
        itemName.setBounds(50, 90, 350, 30);

        JLabel manageItemPrice = new JLabel("Price:");
        manageItemPrice.setFont(new Font("Arial Black", Font.PLAIN, 18));
        manageItemPrice.setForeground(Color.WHITE);
        manageItemPrice.setBounds(50, 130, 250, 30);

        itemPrice = new JTextField();
        itemPrice.setBounds(50, 170, 350, 30);
        itemPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (itemPrice.getText().trim().isEmpty()) {
                    itemPrice.setText("0.0");
                }
            }
        });
        itemPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                char c = e.getKeyChar();
                String currentprice = itemPrice.getText();

                int caretPos = itemPrice.getCaretPosition();
                
                if(c == '.'){
                    if(currentprice.contains(".")){
                        e.consume();
                    }
                    return;
                }
                if(Character.isDigit(c)){
                    e.consume();
                }
                if(currentprice.contains(".")){
                    int dotIndex = currentprice.indexOf(".");
                    if(caretPos > dotIndex){
                        String cent = currentprice.substring(dotIndex + 1);
                        if (cent.length()>=2){
                            e.consume();
                        }
                    }
                }
            }
        });

        JLabel manageItemCalorie = new JLabel("Calories:");
        manageItemCalorie.setFont(new Font("Arial Black", Font.PLAIN, 18));
        manageItemCalorie.setForeground(Color.WHITE);
        manageItemCalorie.setBounds(50, 210, 250, 30);

        itemCalorie = new JTextField();
        itemCalorie.setBounds(50, 250, 350, 30);
        itemCalorie.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (itemCalorie.getText().trim().isEmpty()) {
                    itemCalorie.setText("0.0");
                }
            }
        });
        itemCalorie.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                char c = e.getKeyChar();
                String currentprice = itemCalorie.getText();

                int caretPos = itemCalorie.getCaretPosition();
                
                if(c == '.'){
                    if(currentprice.contains(".")){
                        e.consume();
                    }
                    return;
                }
                if(Character.isDigit(c)){
                    e.consume();
                }
                if(currentprice.contains(".")){
                    int dotIndex = currentprice.indexOf(".");
                    if(caretPos > dotIndex){
                        String cent = currentprice.substring(dotIndex + 1);
                        if (cent.length()>=2){
                            e.consume();
                        }
                    }
                }
            }
        });

        JLabel manageItemCount = new JLabel("Quantity:");
        manageItemCount.setFont(new Font("Arial Black", Font.PLAIN, 18));
        manageItemCount.setForeground(Color.WHITE);
        manageItemCount.setBounds(50, 290, 250, 30);

        itemCount = new JTextField();
        itemCount.setBounds(110, 320, 60, 30);
        itemCount.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (itemCount.getText().trim().isEmpty()) {
                    itemCount.setText("0");
                }
            }
        });
        itemCount.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                char c = e.getKeyChar();
                String currString = itemCount.getText();
                if(!Character.isDigit(c)){
                    e.consume();
                    return;
                }
                if(currString.length() >= 2){
                    e.consume();
                    return;
                }
                if(currString.contains("1")){
                    if(c != '0'){
                        e.consume();
                    }
                } else if (!currString.isEmpty() && !currString.contains("1")){
                    e.consume();
                }
            }
        });

        JButton itemMinus = new JButton();
        itemMinus.setText("-");
        itemMinus.setBounds(50, 320, 50, 30);
        itemMinus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(itemCount.getText());
            if (currentQuantity > 0) {
                currentQuantity--;
                itemCount.setText(String.valueOf(currentQuantity));
            }
        });

        JButton itemPlus = new JButton();
        itemPlus.setText("+");
        itemPlus.setBounds(180, 320, 50, 30);
        itemPlus.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(itemCount.getText());
            if (currentQuantity < 10) {
                currentQuantity++;
                itemCount.setText(String.valueOf(currentQuantity));
            }
        });

        manageItemType = new JLabel("Type:");
        manageItemType.setFont(new Font("Arial Black", Font.PLAIN, 18));
        manageItemType.setForeground(Color.WHITE);
        manageItemType.setBounds(250, 290, 250, 30);

        
        itemType = new JTextField();
        itemType.setBounds(250, 320, 100, 30);
        itemType.setEditable(false);

        JButton manageBack = new JButton();
        manageBack.setText("Go Back");
        manageBack.setBounds(295, 475, 90, 40);
        manageBack.addActionListener(e -> {
            boolean isChanged = false;
            if (managingSlot != null) {
                String currNameText = itemName.getText();
                String currPriceText = itemPrice.getText();
                String currCalorieText = itemCalorie.getText();
                String currCountText = itemCount.getText();

                double parsedPrice = currPriceText.isBlank() ? 0.0 : Double.parseDouble(currPriceText);
                double parsedCalorie = currCalorieText.isBlank() ? 0.0 : Double.parseDouble(currCalorieText);
                int parsedCount = currCountText.isBlank() ? 0 : Integer.parseInt(currCountText);

                boolean nameChanged = !currNameText.equalsIgnoreCase(currItemName == null ? "" : currItemName);
                boolean priceChanged = (parsedPrice != currItemPrice);
                boolean calorieChanged = (parsedCalorie != currItemCalorie);
                boolean countChanged = (parsedCount != currItemCount);

                if (nameChanged || priceChanged || calorieChanged || countChanged) {
                    isChanged = true;
                }
            }
            if (isChanged) {
                int response = JOptionPane.showConfirmDialog(manageSelectedSlot, "You have unsaved changes. Are you sure you want to go back and discard them?", "Unsaved Changes", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    this.managingSlot = null;
                    this.currItemName = null;
                    this.currItemPrice = 0.0;
                    this.currItemCalorie = 0.0;
                    this.currItemCount = 0;
                    this.currItemType = null;
                    updateSlotNames(vendingMachine);
                    swap.show(content, "ModifySlot");
                }
            }
            this.managingSlot = null;
            this.currItemName = null;
            this.currItemPrice = 0.0;
            this.currItemCalorie = 0.0;
            this.currItemCount = 0;
            this.currItemType = null;
            updateSlotNames(vendingMachine);
            swap.show(content, "ModifySlot");
        });

        JButton reset = new JButton();
        reset.setText("Reset");
        reset.setBounds(170, 430, 90, 40);
        reset.addActionListener(e -> {
            if (this.managingSlot != null) {
                manageSlot(this.managingSlot);
            }
        });

        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setBounds(170, 475, 90, 40);
        remove.addActionListener(e -> {
            removeIteminSlot();
            JOptionPane.showMessageDialog(manageSelectedSlot, "Slot inventory cleared completely!");
        });


        JButton updateSlot = new JButton();
        updateSlot.setText("Update");
        updateSlot.setBounds(45, 475, 90, 40);
        updateSlot.addActionListener(e -> {
        String typedName = itemName.getText().trim();
        String typedPrice = itemPrice.getText().trim();
        String typedCalorie = itemCalorie.getText().trim();
        String typedCount = itemCount.getText().trim();
        String typedType = itemType.getText().trim();

        String safePrice = typedPrice.isBlank() ? "0.0" : typedPrice;
        String safeCalorie = typedCalorie.isBlank() ? "0.0" : typedCalorie;
        String safeCount = typedCount.isBlank() ? "0" : typedCount;

        double parsedPrice = Double.parseDouble(safePrice);
        double parsedCalorie = Double.parseDouble(safeCalorie);
        int parsedCount = Integer.parseInt(safeCount);
        
        if (typedName.isBlank()) {
            JOptionPane.showMessageDialog(manageSelectedSlot, "Item name must exist! Error!");
        } else {
            Item currItem = managingSlot.getItem();
            if (currItem == null || !typedName.equalsIgnoreCase(currItem.getName())) {    
                currItemName = typedName;
                vendingMachine.generateReceipt(); 
                
                managingSlot.getItemList().clear();
                managingSlot.setBeforeStock(0);
                managingSlot.resetSold();
                managingSlot.setPrice(parsedPrice);

                if (vendingMachine instanceof Regular) {
                    managingSlot.setItem(new Item(typedName, parsedCalorie));
                    for (int i = 0; i < parsedCount; i++) {
                        managingSlot.getItemList().add(new Item(typedName, parsedCalorie));
                    }
                } else if (vendingMachine instanceof Special) {
                    managingSlot.setItem(new Item(typedName, parsedCalorie, typedType));
                    for (int i = 0; i < parsedCount; i++) {
                        managingSlot.getItemList().add(new Item(typedName, parsedCalorie, typedType));
                    }
                }
                currItemPrice = parsedPrice;
                currItemCount = parsedCount;
                currItemCalorie = parsedCalorie;
                if (vendingMachine instanceof Special) currItemType = typedType;

                JOptionPane.showMessageDialog(manageSelectedSlot, "New Item Assigned Successfully!");

            } else if (typedName.equalsIgnoreCase(currItem.getName())) {
                
                managingSlot.setPrice(parsedPrice);
                
                if (vendingMachine instanceof Regular) {
                    managingSlot.setItem(new Item(typedName, parsedCalorie));
                } else if (vendingMachine instanceof Special) {
                    managingSlot.setItem(new Item(typedName, parsedCalorie, typedType));
                }

                managingSlot.getItemList().clear();
                if (vendingMachine instanceof Regular) {
                    for (int i = 0; i < parsedCount; i++) {
                        managingSlot.getItemList().add(new Item(typedName, parsedCalorie));
                    }
                } else if (vendingMachine instanceof Special) {
                    for (int i = 0; i < parsedCount; i++) {
                        managingSlot.getItemList().add(new Item(typedName, parsedCalorie, typedType));
                    }
                }

                managingSlot.setBeforeStock(currItemCount); 
                currItemCount = managingSlot.getCurrentStock();
                currItemPrice = parsedPrice;
                currItemCalorie = parsedCalorie;
                if (vendingMachine instanceof Special) currItemType = typedType;

                JOptionPane.showMessageDialog(manageSelectedSlot, "Item Updated Successfully!");
            }
        }
    });

        
        content.add(vendingfront, "VendingFront");
        content.add(modifySlot, "ModifySlot");
        content.add(modifyVault, "ModifyVault");
        content.add(manageSelectedSlot, "ManageSlot");
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

        modifyVault.add(vaultIns);
        modifyVault.add(denom001);
        modifyVault.add(denom005);
        modifyVault.add(denom010);
        modifyVault.add(denom025);
        modifyVault.add(denom100);
        modifyVault.add(denom500);
        modifyVault.add(denom1000);
        modifyVault.add(denom2000);
        modifyVault.add(denom5000);
        modifyVault.add(denom10000);
        modifyVault.add(denom20000);
        modifyVault.add(denom50000);
        modifyVault.add(denom100000);
        modifyVault.add(denomBack);
        modifyVault.add(denomUpdate);
        modifyVault.add(denom001Field);
        modifyVault.add(denom001Minus);
        modifyVault.add(denom001Plus);
        modifyVault.add(denom005Field);
        modifyVault.add(denom005Minus);
        modifyVault.add(denom005Plus);
        modifyVault.add(denom010Field);
        modifyVault.add(denom010Minus);
        modifyVault.add(denom010Plus);
        modifyVault.add(denom025Field);
        modifyVault.add(denom025Minus);
        modifyVault.add(denom025Plus);
        modifyVault.add(denom100Field);
        modifyVault.add(denom100Minus);
        modifyVault.add(denom100Plus);
        modifyVault.add(denom500Field);
        modifyVault.add(denom500Minus);
        modifyVault.add(denom500Plus);
        modifyVault.add(denom1000Field);
        modifyVault.add(denom1000Minus);
        modifyVault.add(denom1000Plus);
        modifyVault.add(denom2000Field);
        modifyVault.add(denom2000Minus);
        modifyVault.add(denom2000Plus);
        modifyVault.add(denom5000Field);
        modifyVault.add(denom5000Minus);
        modifyVault.add(denom5000Plus);
        modifyVault.add(denom10000Field);
        modifyVault.add(denom10000Minus);
        modifyVault.add(denom10000Plus);
        modifyVault.add(denom20000Field);
        modifyVault.add(denom20000Minus);
        modifyVault.add(denom20000Plus);
        modifyVault.add(denom50000Field);
        modifyVault.add(denom50000Minus);
        modifyVault.add(denom50000Plus);
        modifyVault.add(denom100000Field);
        modifyVault.add(denom100000Minus);
        modifyVault.add(denom100000Plus);

        modifySlot.add(slotIns);
        modifySlot.add(slotBack);
        modifySlot.add(slotNameLabel);
        modifySlot.add(slotItemLabel);
        modifySlot.add(slotA1);
        modifySlot.add(slotA2);
        modifySlot.add(slotA3);
        modifySlot.add(slotB1);
        modifySlot.add(slotB2);
        modifySlot.add(slotB3);
        modifySlot.add(slotC1);
        modifySlot.add(slotC2);
        modifySlot.add(slotC3);
        modifySlot.add(slotA1Field);
        modifySlot.add(slotA2Field);
        modifySlot.add(slotA3Field);
        modifySlot.add(slotB1Field);
        modifySlot.add(slotB2Field);
        modifySlot.add(slotB3Field);
        modifySlot.add(slotC1Field);
        modifySlot.add(slotC2Field);
        modifySlot.add(slotC3Field);
        modifySlot.add(manageA1);
        modifySlot.add(manageA2);
        modifySlot.add(manageA3);
        modifySlot.add(manageB1);
        modifySlot.add(manageB2);
        modifySlot.add(manageB3);
        modifySlot.add(manageC1);
        modifySlot.add(manageC2);
        modifySlot.add(manageC3);

        manageSelectedSlot.add(manageTitle);
        manageSelectedSlot.add(manageItemName);
        manageSelectedSlot.add(itemName);
        manageSelectedSlot.add(itemCalorie);
        manageSelectedSlot.add(manageItemCalorie);
        manageSelectedSlot.add(manageItemPrice);
        manageSelectedSlot.add(itemPrice);
        manageSelectedSlot.add(manageItemType);
        manageSelectedSlot.add(itemType);
        manageSelectedSlot.add(manageBack);
        manageSelectedSlot.add(updateSlot);
        manageSelectedSlot.add(manageItemCount);
        manageSelectedSlot.add(itemCount);
        manageSelectedSlot.add(itemPlus);
        manageSelectedSlot.add(itemMinus);
        manageSelectedSlot.add(remove);
        manageSelectedSlot.add(reset);


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
            if (vendingMachine != null) {
                double val = Double.parseDouble(denomin.getSelectedItem().toString());
                vendingMachine.getUserCash().addCash(new Denomination(val, 1));
                currentCash = vendingMachine.getUserCash().getTotalValue();
                updateScreen(null);
            }
        });

        checkButton.addActionListener(e -> {
            if (vendingMachine != null) {
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

                                    refreshSlotDisplays();
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
        
        refreshSlotDisplays();

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

    public void updateDenominationFields(VendingMachine vm) {

        current001 = vm.getCashVault().getCashList().get(0).getQuantity();
        current005 = vm.getCashVault().getCashList().get(1).getQuantity();
        current010 = vm.getCashVault().getCashList().get(2).getQuantity();
        current025 = vm.getCashVault().getCashList().get(3).getQuantity();
        current100 = vm.getCashVault().getCashList().get(4).getQuantity();
        current500 = vm.getCashVault().getCashList().get(5).getQuantity();
        current1000 = vm.getCashVault().getCashList().get(6).getQuantity();
        current2000 = vm.getCashVault().getCashList().get(7).getQuantity();
        current5000 = vm.getCashVault().getCashList().get(8).getQuantity();
        current10000 = vm.getCashVault().getCashList().get(9).getQuantity();
        current20000 = vm.getCashVault().getCashList().get(10).getQuantity();
        current50000 = vm.getCashVault().getCashList().get(11).getQuantity();
        current100000 = vm.getCashVault().getCashList().get(12).getQuantity();

        denom001Field.setText(String.valueOf(current001));
        denom005Field.setText(String.valueOf(current005));
        denom010Field.setText(String.valueOf(current010));
        denom025Field.setText(String.valueOf(current025));
        denom100Field.setText(String.valueOf(current100));
        denom500Field.setText(String.valueOf(current500));
        denom1000Field.setText(String.valueOf(current1000));
        denom2000Field.setText(String.valueOf(current2000));
        denom5000Field.setText(String.valueOf(current5000));
        denom10000Field.setText(String.valueOf(current10000));
        denom20000Field.setText(String.valueOf(current20000));
        denom50000Field.setText(String.valueOf(current50000));
        denom100000Field.setText(String.valueOf(current100000));
    }

    public void manageSlot(Slots toManage){
        if (vendingMachine instanceof Special){
            manageItemType.setVisible(true);
            itemType.setVisible(true);
        } else {
            manageItemType.setVisible(false);
            itemType.setVisible(false);
        }

        this.managingSlot = toManage;

        if (toManage.getItem() != null) {
            currItemName = toManage.getItem().getName();
            itemName.setText(currItemName);
            currItemPrice = toManage.getPrice();
            itemPrice.setText(String.valueOf(currItemPrice));
            currItemCalorie = toManage.getItem().getCalories();
            itemCalorie.setText(String.valueOf(currItemCalorie));
            currItemCount = toManage.getCurrentStock();
            itemCount.setText(String.valueOf(currItemCount));
            if(toManage.getItem().getType() != null) {
                currItemType = toManage.getItem().getType();
                itemType.setText(currItemType);
            }
        } else {
            currItemName = null;
            currItemPrice = 0.0;
            currItemCalorie = 0.0;
            currItemCount = 0;
            itemName.setText("");
            itemPrice.setText("");
            itemCalorie.setText("");
            itemCount.setText("");
        }
    }

    public void updateSlotNames(VendingMachine vm){
        if(vm.itemSlots.get(0).getItem() != null){
            A1 = vm.itemSlots.get(0).getItem().getName();
            slotA1Field.setText(A1);
        } else {
            slotA1Field.setText("N/A");
            A1 = null;
        }
        if(vm.itemSlots.get(1).getItem() != null){
            A2 = vm.itemSlots.get(1).getItem().getName();
            slotA2Field.setText(A2);
        } else {
            slotA2Field.setText("N/A");
            A2 = null;
        }
        if(vm.itemSlots.get(2).getItem() != null){
            A3 = vm.itemSlots.get(2).getItem().getName();
            slotA3Field.setText(A3);
        } else {
            slotA3Field.setText("N/A");
            A3 = null;
        }
        if(vm.itemSlots.get(3).getItem() != null){
            B1 = vm.itemSlots.get(3).getItem().getName();
            slotB1Field.setText(B1);
        } else {
            slotB1Field.setText("N/A");
            B1 = null;
        } 
        if(vm.itemSlots.get(4).getItem() != null){
            B2 = vm.itemSlots.get(4).getItem().getName();
            slotB2Field.setText(B2);
        } else {
            slotB2Field.setText("N/A");
            B2 = null;
        } 
        if(vm.itemSlots.get(5).getItem() != null){
            B3 = vm.itemSlots.get(5).getItem().getName();
            slotB3Field.setText(B3);
        } else {
            slotB3Field.setText("N/A");
            B3 = null;
        } 
        if(vm.itemSlots.get(6).getItem() != null){
            C1 = vm.itemSlots.get(6).getItem().getName();
            slotC1Field.setText(C1);
        } else {
            slotC1Field.setText("N/A");
            C1 = null;
        } 
        if(vm.itemSlots.get(7).getItem() != null){
            C2 = vm.itemSlots.get(7).getItem().getName();
            slotC2Field.setText(C2);
        } else {
            slotC2Field.setText("N/A");
            C2 = null;
        } 
        if(vm.itemSlots.get(7).getItem() != null){
            C3 = vm.itemSlots.get(8).getItem().getName();
            slotC3Field.setText(C3);
        } else {
            slotC3Field.setText("N/A");
            C3 = null;
        } 
    }

    public void refreshSlotDisplays() {
        
        Slots currentSlot; 
        int i; 
        String name; 
        double price; 
        int stock; 

        if (vendingMachine == null) 
            return;


        JTextArea[] displays = {displayA1, displayA2, displayA3, displayB1, displayB2, displayB3, displayC1, displayC2, displayC3};
        
        for (i = 0; i < 9; i++) {
            currentSlot = vendingMachine.itemSlots.get(i);
            
            if (currentSlot.getItem() != null) {
                name = currentSlot.getItem().getName();
                price = currentSlot.getPrice();
                stock = currentSlot.getCurrentStock();

                displays[i].setText(name + "\n(P" + String.format("%.2f", price) + ")\nQty: " + stock);
            } else {
                displays[i].setText("N/A\n\nQty: 0");
            }
        }
    }


    

    public void applySlotChanges(){
        if(this.managingSlot != null && this.managingSlot.getItem()!= null){
            String newName = itemName.getText().trim();
            double newPrice = Double.parseDouble(itemPrice.getText());
            double newCalorie = Double.parseDouble(itemCalorie.getText());
            int targetStock = Integer.parseInt(itemCount.getText());

            this.managingSlot.getItemList().clear(); 

            this.managingSlot.setPrice(newPrice);
            for (int i = 0; i < targetStock; i++) {
                Item individualItem;
                if (vendingMachine instanceof Special) {
                    individualItem = new Item(newName, newCalorie, this.currItemType);
                } else {
                    individualItem = new Item(newName, newCalorie);
                }
                this.managingSlot.getItemList().add(individualItem);
            }
            this.currItemName = newName;
            this.currItemPrice = newPrice;
            this.currItemCalorie = newCalorie;
            this.currItemCount = targetStock;
        }
    }
    
    public void removeIteminSlot(){
        this.managingSlot.getItemList().clear();
        this.managingSlot.setItem(null);
        this.managingSlot.setPrice(0.0);
        this.managingSlot.setBeforeStock(0);
        this.managingSlot.resetSold();

        this.currItemName = null;
        this.currItemPrice = 0.0;
        this.currItemCalorie = 0.0;
        this.currItemCount = 0;

        itemName.setText("");
        itemPrice.setText("0.0");
        itemCalorie.setText("0.0");
        itemCount.setText("0");
    }
}