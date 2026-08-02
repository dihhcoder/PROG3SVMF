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
            if(current001 != Integer.parseInt(denom001Field.getText())){
                vendingMachine.getCashVault().getCashList().get(0).setQuantity(Integer.parseInt(denom001Field.getText()));
                current001 = Integer.parseInt(denom001Field.getText());
            }
            if(current005 != Integer.parseInt(denom005Field.getText())){
                vendingMachine.getCashVault().getCashList().get(1).setQuantity(Integer.parseInt(denom005Field.getText()));
                current005 = Integer.parseInt(denom005Field.getText());
            }
            if(current010 != Integer.parseInt(denom010Field.getText())){
                vendingMachine.getCashVault().getCashList().get(2).setQuantity(Integer.parseInt(denom010Field.getText()));
                current010 = Integer.parseInt(denom010Field.getText());
            }
            if(current025 != Integer.parseInt(denom025Field.getText())){
                vendingMachine.getCashVault().getCashList().get(3).setQuantity(Integer.parseInt(denom025Field.getText()));
                current025 = Integer.parseInt(denom025Field.getText());
            }
            if(current100 != Integer.parseInt(denom100Field.getText())){
                vendingMachine.getCashVault().getCashList().get(4).setQuantity(Integer.parseInt(denom100Field.getText()));
                current100 = Integer.parseInt(denom100Field.getText());
            }
            if(current500 != Integer.parseInt(denom500Field.getText())){
                vendingMachine.getCashVault().getCashList().get(5).setQuantity(Integer.parseInt(denom500Field.getText()));
                current500 = Integer.parseInt(denom500Field.getText());
            }
            if(current1000 != Integer.parseInt(denom1000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(6).setQuantity(Integer.parseInt(denom1000Field.getText()));
                current1000 = Integer.parseInt(denom1000Field.getText());
            }
            if(current2000 != Integer.parseInt(denom2000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(7).setQuantity(Integer.parseInt(denom2000Field.getText()));
                current2000 = Integer.parseInt(denom2000Field.getText());
            }
            if(current5000 != Integer.parseInt(denom5000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(8).setQuantity(Integer.parseInt(denom5000Field.getText()));
                current5000 = Integer.parseInt(denom5000Field.getText());
            }
            if(current10000 != Integer.parseInt(denom10000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(9).setQuantity(Integer.parseInt(denom10000Field.getText()));
                current10000 = Integer.parseInt(denom10000Field.getText());
            }
            if(current20000 != Integer.parseInt(denom20000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(10).setQuantity(Integer.parseInt(denom20000Field.getText()));
                current20000 = Integer.parseInt(denom20000Field.getText());
            }
            if(current50000 != Integer.parseInt(denom50000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(11).setQuantity(Integer.parseInt(denom50000Field.getText()));
                current50000 = Integer.parseInt(denom50000Field.getText());
            }
            if(current100000 != Integer.parseInt(denom100000Field.getText())){
                vendingMachine.getCashVault().getCashList().get(12).setQuantity(Integer.parseInt(denom100000Field.getText()));
                current100000 = Integer.parseInt(denom100000Field.getText());
            }
        });



        content.add(vendingfront, "VendingFront");
        content.add(modifySlot, "ModifySlot");
        content.add(modifyVault, "ModifyVault");
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
}