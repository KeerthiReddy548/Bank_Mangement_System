package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton b1, b2, b3, b4, b5, b6, b7;

    FastCash(String pin) {
        this.pin = pin;

        try {
            URL url = new URL(
                    "https://media.istockphoto.com/id/1301853612/vector/atm-bank-cash-machine-3d-realistic-front-view-atm-street-kiosk-bankomat-service.jpg?s=170667a&w=0&k=20&c=QqFW_DylM0QHvN54aK7ifwR5kKu8y5QEYCAEdJkBljM="
            );

            ImageIcon il1 = new ImageIcon(url);
            Image i2 = il1.getImage().getScaledInstance(
                    1200, 630, Image.SCALE_DEFAULT
            );
            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1200, 630);
            add(image);

            JLabel label1 = new JLabel("Select Withdrawal Amount");
            label1.setFont(new Font("System", Font.BOLD, 15));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 700, 35);
            image.add(label1);

            b1 = new JButton("Rs. 100");
            b1.setBounds(310, 297, 100, 20);
            b1.setBackground(new Color(65, 125, 128));
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            image.add(b1);

            b2 = new JButton("Rs. 500");
            b2.setBounds(570, 297, 100, 20);
            b2.setBackground(new Color(65, 125, 128));
            b2.setForeground(Color.WHITE);
            b2.addActionListener(this);
            image.add(b2);

            b3 = new JButton("Rs. 1000");
            b3.setBounds(310, 320, 100, 20);
            b3.setBackground(new Color(65, 125, 128));
            b3.setForeground(Color.WHITE);
            b3.addActionListener(this);
            image.add(b3);

            b4 = new JButton("Rs. 2000");
            b4.setBounds(570, 320, 100, 20);
            b4.setBackground(new Color(65, 125, 128));
            b4.setForeground(Color.WHITE);
            b4.addActionListener(this);
            image.add(b4);

            b5 = new JButton("Rs. 5000");
            b5.setBounds(310, 345, 100, 20);
            b5.setBackground(new Color(65, 125, 128));
            b5.setForeground(Color.WHITE);
            b5.addActionListener(this);
            image.add(b5);

            b6 = new JButton("Rs. 10,000");
            b6.setBounds(570, 345, 100, 20);
            b6.setBackground(new Color(65, 125, 128));
            b6.setForeground(Color.WHITE);
            b6.addActionListener(this);
            image.add(b6);

            b7 = new JButton("Back");
            b7.setBounds(570, 370, 100, 20);
            b7.setBackground(new Color(65, 125, 128));
            b7.setForeground(Color.WHITE);
            b7.addActionListener(this);
            image.add(b7);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(1200, 630);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Back button
        if (e.getSource() == b7) {
            setVisible(false);
            new main_Class(pin);
            return;
        }

        // Get withdrawal amount from button
        String amount = ((JButton) e.getSource())
                .getText()
                .substring(4)
                .replace(",", "");

        int withdrawAmount = Integer.parseInt(amount);

        con c = new con();
        Date date = new Date();

        try {

            // Calculate current balance
            ResultSet resultSet = c.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pin + "'"
            );

            int balance = 0;

            while (resultSet.next()) {

                String type = resultSet.getString("type");

                int amount1 = Integer.parseInt(
                        resultSet.getString("amount")
                );

                if (type.equalsIgnoreCase("Deposit")) {

                    balance += amount1;

                } else if (type.equalsIgnoreCase("Withdrawal")
                        || type.equalsIgnoreCase("withdrawl")) {

                    balance -= amount1;
                }
            }

            // Check insufficient balance


            // Insert withdrawal transaction
            String query =
                    "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    c.connection.prepareStatement(query);

            ps.setString(1, pin);
            ps.setString(2, date.toString());
            ps.setString(3, "Withdrawal");
            ps.setString(4, amount);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Rs. " + amount + " Debited Successfully"
            );

            ps.close();
            resultSet.close();
            c.connection.close();

            setVisible(false);
            new main_Class(pin);

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    null, "Error: " + ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}



