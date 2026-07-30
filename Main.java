import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<String> storage = new ArrayList<String>();
        JFrame menuFrame = new JFrame("Vending Machine Factory Simulator");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(450, 450);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);

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

        JLabel createIns = new JLabel();
        createIns.setText("What would you like to create?");
        createIns.setForeground(Color.WHITE);
        createIns.setFont(new Font("Arial Black", Font.PLAIN, 16));
        createIns.setBounds(75, 15, 300, 40);

        JLabel instruction = new JLabel();
        instruction.setText("What would you like to do?");
        instruction.setForeground(Color.WHITE);
        instruction.setFont(new Font("Arial Black", Font.PLAIN, 16));
        instruction.setBounds(95, 15, 300, 40);

        JButton createReg = new JButton();
        createReg.setText("Create a Regular Vending Machine");
        createReg.setBounds(95, 60, 230, 40);
        createReg.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Regular Vending Machine Created.", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            storage.add("Reg");
            swap.show(content, "MainMenu");
        });

        JButton createSpe = new JButton();
        createSpe.setText("Create a Special Vending Machine");
        createSpe.setBounds(95, 150, 230, 40);
        createSpe.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Special Vending Machine Created.",  "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            storage.add("Spe");
            swap.show(content, "MainMenu");
        });

        JButton createBack = new JButton();
        createBack.setText("Go Back To Main Menu");
        createBack.setBounds(95, 240, 230, 40);
        createBack.addActionListener(e -> {
            swap.show(content, "MainMenu");
        });

        JButton create = new JButton();
        create.setText("Create a New Vending Machine");
        create.setBounds(95, 60, 230, 40);
        create.addActionListener(e -> {
            if(storage.isEmpty())
                swap.show(content, "CreateMenu");
            else
                JOptionPane.showMessageDialog(menuFrame, "Current Vending Machine Not Yet Released To Buyer",  "Factory Alert", JOptionPane.OK_CANCEL_OPTION);

        });

        JButton test = new JButton();
        test.setText("Test Your Vending Machine");
        test.setBounds(95, 120, 230, 40);
        test.addActionListener(e -> {
            if (!storage.isEmpty())
                JOptionPane.showMessageDialog(menuFrame, storage.get(0) + " is being tested", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(menuFrame, "Nothing To Test At The Moment", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);

        });

        JButton release = new JButton();
        release.setText("Release Vending Machine");
        release.setBounds(95, 180, 230, 40);
        release.addActionListener(e -> {
            if(!storage.isEmpty()) {
                JOptionPane.showMessageDialog(menuFrame, "Order Recieved!", "Vending Machine Buyer", JOptionPane.INFORMATION_MESSAGE);
                storage.clear();
            }
            else
                JOptionPane.showMessageDialog(menuFrame, "Nothing to release at the moment!", "Factory Alert", JOptionPane.OK_CANCEL_OPTION);

        });

        JButton close = new JButton();
        close.setText("Close Program");
        close.setBounds(95, 240, 230, 40);
        close.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Thank You For Your Service", "Factory Alert", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });


        content.add(background, "MainMenu");
        content.add(createPanel, "CreateMenu");
        menuFrame.add(topPanel, BorderLayout.NORTH);
        menuFrame.add(content, BorderLayout.CENTER);
        topPanel.add(menuSign);
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