import java.awt.*;
import java.util.ArrayDeque;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));
        ArrayDeque<VendingMachine> storage = new ArrayDeque<VendingMachine>();
        JFrame menuFrame = new JFrame("Vending Machine Factory Simulator");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(450, 450);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);

        VendingInterface vendingUX = new VendingInterface();

        JLabel menuSign = new JLabel();
        menuSign.setText("Vending Machine Factory Simulator");
        menuSign.setForeground(Color.WHITE);
        menuSign.setFont(new Font("Arial Black", Font.PLAIN, 18));
        menuSign.setBounds(40, 15, 400, 40);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(245, 73, 39));
        topPanel.setPreferredSize(new Dimension(450, 75));
        topPanel.setLayout(null);
        
        CardLayout swap = new CardLayout();
        JPanel content = new JPanel(swap);

        JPanel background = new JPanel();
        background.setBackground(new Color(126, 217, 87));
        background.setPreferredSize(new Dimension(450, 450));
        background.setLayout(null);
        background.setVisible(true);

        JPanel createPanel = new JPanel();
        createPanel.setBackground(new Color(126, 217, 87));
        createPanel.setPreferredSize(new Dimension(450, 450));
        createPanel.setLayout(null);
        createPanel.setVisible(false);

        JPanel testMenu = new JPanel();
        testMenu.setBackground(new Color(126, 217, 87));
        testMenu.setPreferredSize(new Dimension(450, 450));
        testMenu.setLayout(null);
        testMenu.setVisible(false);

        JLabel createIns = new JLabel();
        createIns.setText("What would you like to create?");
        createIns.setForeground(Color.WHITE);
        createIns.setFont(new Font("Arial Black", Font.PLAIN, 16));
        createIns.setBounds(80, 15, 300, 40);

        JLabel instruction = new JLabel();
        instruction.setText("What would you like to do?");
        instruction.setForeground(Color.WHITE);
        instruction.setFont(new Font("Arial Black", Font.PLAIN, 16));
        instruction.setBounds(100, 15, 300, 40);

        JLabel testIns = new JLabel();
        testIns.setText("What would you like to do?");
        testIns.setForeground(Color.WHITE);
        testIns.setFont(new Font("Arial Black", Font.PLAIN, 16));
        testIns.setBounds(100, 15, 300, 40);

        JButton createReg = new JButton();
        createReg.setText("Create a Regular Vending Machine");
        createReg.setBounds(75, 60, 280, 40);
        createReg.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Regular Vending Machine Created.", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            storage.add(new Regular());
            swap.show(content, "MainMenu");
        });

        JButton createSpe = new JButton();
        createSpe.setText("Create a Special Vending Machine");
        createSpe.setBounds(75, 150, 280, 40);
        createSpe.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Special Vending Machine Created.",  "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            storage.add(new Special());
            swap.show(content, "MainMenu");
        });

        JButton createBack = new JButton();
        createBack.setText("Go Back To Main Menu");
        createBack.setBounds(75, 240, 280, 40);
        createBack.addActionListener(e -> {
            swap.show(content, "MainMenu");
        });

        JButton testUser = new JButton();
        testUser.setText("Test Current Vending Machine as User");
        testUser.setBounds(75, 60, 280, 40);
        testUser.addActionListener(e -> {
           vendingUX.testUser(storage.peek(), menuFrame);
        });

        JButton testAdmin = new JButton();
        testAdmin.setText("Test Current Vending Machine as Admin");
        testAdmin.setBounds(75, 150, 280, 40);
        testAdmin.addActionListener(e -> {
            vendingUX.testAdmin(storage.peek(), menuFrame);
        });

        JButton testBack = new JButton();
        testBack.setText("Go Back To Main Menu");
        testBack.setBounds(75, 240, 280, 40);
        testBack.addActionListener(e -> {
            swap.show(content, "MainMenu");
        });

        JButton create = new JButton();
        create.setText("Create a New Vending Machine");
        create.setBounds(100, 60, 230, 40);
        create.addActionListener(e -> {
            if(storage.isEmpty())
                swap.show(content, "CreateMenu");
            else
                JOptionPane.showMessageDialog(menuFrame, "Current Vending Machine Not Yet Released To Buyer",  "Factory Alert", JOptionPane.OK_CANCEL_OPTION);
        });

        JButton test = new JButton();
        test.setText("Test Your Vending Machine");
        test.setBounds(100, 120, 230, 40);
        test.addActionListener(e -> {
            if (!storage.isEmpty()){
                    swap.show(content, "testMenu");
            }
            else
                JOptionPane.showMessageDialog(menuFrame, "Nothing To Test At The Moment", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);

        });

        JButton release = new JButton();
        release.setText("Release Vending Machine");
        release.setBounds(100, 180, 230, 40);
        release.addActionListener(e -> {
            if(!storage.isEmpty()) {
                JOptionPane.showMessageDialog(menuFrame, "Order Recieved!", "Vending Machine Buyer", JOptionPane.INFORMATION_MESSAGE);
                storage.poll();
            }
            else
                JOptionPane.showMessageDialog(menuFrame, "Nothing to release at the moment!", "Factory Alert", JOptionPane.OK_CANCEL_OPTION);

        });

        JButton close = new JButton();
        close.setText("Close Program");
        close.setBounds(100, 240, 230, 40);
        close.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Thank You For Your Service", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });


        content.add(background, "MainMenu");
        content.add(createPanel, "CreateMenu");
        content.add(testMenu, "testMenu");
        menuFrame.add(topPanel, BorderLayout.NORTH);
        menuFrame.add(content, BorderLayout.CENTER);
        topPanel.add(menuSign);
        testMenu.add(testIns);
        testMenu.add(testUser);
        testMenu.add(testAdmin);
        testMenu.add(testBack);
        background.add(instruction);
        background.add(create);
        background.add(test);
        background.add(release);
        background.add(close);
        createPanel.add(createIns);
        createPanel.add(createReg);
        createPanel.add(createSpe);
        createPanel.add(createBack);
        
        menuFrame.setVisible(true);
    }
}