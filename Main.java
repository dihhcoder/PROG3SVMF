import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        JFrame menuFrame = new JFrame("Vending Machine Factory Simulator");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(450, 450);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
        
        JPanel background = new JPanel();
        background.setBackground(new Color(24, 183, 83));
        background.setPreferredSize(new Dimension(450, 450));
        background.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(220, 22, 22));
        topPanel.setPreferredSize(new Dimension(450, 75));
        topPanel.setLayout(null);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(450, 50));

        JLabel menuSign = new JLabel();
        menuSign.setText("Vending Machine Factory Simulator");
        menuSign.setForeground(Color.WHITE);
        menuSign.setFont(new Font("Arial Black", Font.PLAIN, 18));
        menuSign.setBounds(40, 15, 400, 40);

        JLabel instruction = new JLabel();
        instruction.setText("What would you like to do?");
        instruction.setForeground(Color.WHITE);
        instruction.setFont(new Font("Arial Black", Font.PLAIN, 16));
        instruction.setBounds(50, 15, 300, 40);

        String[] options = {"Create a New Vending Machine", "Test Your Vending Machine", "Release Vending Machine", "Close Program"};
        JComboBox<String> choice = new JComboBox<>(options);
        choice.setBounds(90, 70, 250, 30);
        choice.setFont(new Font("Arial Black", Font.PLAIN, 12));

        JButton select = new JButton();
        select.setText("Select");
        select.setBounds(160, 130, 100, 40);
        select.setFont(new Font("Arial Black", Font.PLAIN, 14));

        JLabel warning = new JLabel();
        warning.setBounds(0, 200, 422, 40);
        warning.setFont(new Font("Arial Black", Font.PLAIN, 14));
        warning.setForeground(Color.WHITE);
        warning.setText("No issues yet");
        warning.setHorizontalAlignment(SwingConstants.CENTER);
        warning.setVisible(false);

        select.addActionListener(e -> {
            String selected = (String)choice.getSelectedItem();
            if(selected.equals("Create a New Vending Machine")){
                warning.setText("Creating a new vending machine");
                warning.setVisible(true);
            } else if(selected.equals("Test Your Vending Machine")) {
                warning.setText("Testing new vending machine");
                warning.setVisible(true);
            } else if(selected.equals("Release Vending Machine")) {
                warning.setText("Vending Machine Shipped");
                warning.setVisible(true);
            } else if(selected.equals("Close Program")) {
                System.exit(0);
            } 
        });
        
        menuFrame.add(topPanel, BorderLayout.NORTH);
        menuFrame.add(bottomPanel, BorderLayout.SOUTH);
        menuFrame.add(background, BorderLayout.CENTER);
        topPanel.add(menuSign);
        background.add(instruction);
        background.add(choice);
        background.add(select);
        background.add(warning);

        menuFrame.setVisible(true);
    }
}