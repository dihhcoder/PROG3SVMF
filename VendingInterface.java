import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendingInterface {
    public static void testVM(VendingMachine vm, JFrame back){
        JFrame vendingmach = new JFrame();
        vendingmach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingmach.setSize(450, 600);
        vendingmach.setLayout(new BorderLayout());
        vendingmach.setLocationRelativeTo(null);
        vendingmach.setResizable(false);

        JPanel vendingfront = new JPanel();
        vendingfront.setBackground(new Color(126, 217, 87));
        vendingfront.setPreferredSize(new Dimension(450, 600));
        vendingfront.setLayout(null);
        vendingfront.setVisible(true);

        JPanel slotDisplay = new JPanel();
        slotDisplay.setBackground(Color.BLUE);
        slotDisplay.setBounds(40, 35, 200, 400);
        slotDisplay.setLayout(null);
        slotDisplay.setVisible(true);

        JPanel dispenseDisplay = new JPanel();
        dispenseDisplay.setBackground(Color.lightGray);
        dispenseDisplay.setBounds(40, 475, 200, 50);
        dispenseDisplay.setLayout(null);
        dispenseDisplay.setVisible(true);

        JPanel dispDisplay = new JPanel();
        dispDisplay.setBackground(Color.lightGray);
        dispDisplay.setBounds(260, 35, 150, 150);
        dispDisplay.setLayout(null);
        dispDisplay.setVisible(true);

        JButton aButton = new JButton();
        aButton.setText("A");
        aButton.setBounds(265, 200, 45, 40);
        aButton.addActionListener(e -> {
            
        });

        JButton bButton = new JButton();
        bButton.setText("B");
        bButton.setBounds(315, 200, 45, 40);
        bButton.addActionListener(e -> {
            
        });

        JButton cButton = new JButton();
        cButton.setText("C");
        cButton.setBounds(365, 200, 45, 40);
        cButton.addActionListener(e -> {
            
        });

        JButton oneButton = new JButton();
        oneButton.setText("1");
        oneButton.setBounds(265, 250, 45, 40);
        oneButton.addActionListener(e -> {
            
        });

        JButton twoButton = new JButton();
        twoButton.setText("2");
        twoButton.setBounds(315, 250, 45, 40);
        twoButton.addActionListener(e -> {
            
        });

        JButton threeButton = new JButton();
        threeButton.setText("3");
        threeButton.setBounds(365, 250, 45, 40);
        threeButton.addActionListener(e -> {
            
        });

        JButton backButton = new JButton();
        backButton.setText("<-");
        backButton.setBounds(265, 300, 45, 40);
        backButton.addActionListener(e -> {
            vendingmach.setVisible(false);
            back.setVisible(true);
        });

        JButton xButton = new JButton();
        xButton.setText("X");
        xButton.setBounds(315, 300, 45, 40);
        xButton.addActionListener(e -> {
            
        });

        JButton checkButton = new JButton();
        checkButton.setText("/");
        checkButton.setBounds(365, 300, 45, 40);
        checkButton.addActionListener(e -> {
            
        });

        String[] moneyList = {"0.01", "0.05", "0.10", "0.25", "1.00", "5.00", "10.00", "20.00", "50.00", "100.00", "200.00", "500.00", "1000.00"};
        JComboBox denomin = new JComboBox<>(moneyList);
        denomin.setBounds(290, 360, 100, 20);

        JButton insert = new JButton();
        insert.setText("Insert");
        insert.setBounds(295, 400, 90, 40);
        insert.addActionListener(e -> {
            int choose = denomin.getSelectedIndex();

            switch (choose) {
                case 0:
                    
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                default:
                    break;
            }
        });


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
        vendingfront.add(backButton);
        vendingfront.add(xButton);
        vendingfront.add(denomin);
        vendingfront.add(insert);



        back.setVisible(false);
        vendingmach.setVisible(true);
    }

    public static void testAdmin(VendingMachine vm, JFrame back){
        JFrame vendingmach = new JFrame();
        vendingmach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingmach.setSize(450, 600);
        vendingmach.setLayout(new BorderLayout());
        vendingmach.setLocationRelativeTo(null);
        vendingmach.setResizable(false);

        JPanel vendingback = new JPanel();
        vendingback.setBackground(new Color(126, 217, 87));
        vendingback.setPreferredSize(new Dimension(450, 600));
        vendingback.setLayout(null);
        vendingback.setVisible(true);

        JPanel slotBack = new JPanel();
        slotBack.setBackground(new Color(0, 0, 0));
        slotBack.setBounds(300, 200, 100, 200);
        slotBack.setLayout(null);
        slotBack.setVisible(true);
        slotBack.setToolTipText("Manage Items in Slots");
        slotBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(vendingmach, "Editing item slots");
            }
        });

        
    }
}
