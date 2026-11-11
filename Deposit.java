
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;
import java.sql.PreparedStatement;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1, b2;

    Deposit(String pin) {
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

            JLabel label1 = new JLabel(
                    "Enter Amount You Want To Deposit :"
            );
            label1.setFont(new Font("System", Font.BOLD, 16));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 400, 35);
            image.add(label1);

            textField = new TextField();
            textField.setBackground(new Color(65, 125, 128));
            textField.setForeground(Color.WHITE);
            textField.setFont(new Font("Raleway", Font.BOLD, 20));
            textField.setBounds(350, 280, 280, 25);
            image.add(textField);

            b1 = new JButton("Deposit");
            b1.setBounds(570, 330, 100, 25);
            b1.setBackground(new Color(65, 125, 128));
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            image.add(b1);

            b2 = new JButton("Back");
            b2.setBounds(570, 360, 100, 25);
            b2.setBackground(new Color(65, 125, 128));
            b2.setForeground(Color.WHITE);
            b2.addActionListener(this);
            image.add(b2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == b1) {

                String amount = textField.getText().trim();
                Date date = new Date();

                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter the Amount you want to Deposit"
                    );
                    return;
                }

                double depositAmount;

                try {
                    depositAmount = Double.parseDouble(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null, "Please enter a valid amount"
                    );
                    return;
                }

                if (depositAmount <= 0) {
                    JOptionPane.showMessageDialog(
                            null, "Amount must be greater than zero"
                    );
                    return;
                }

                con c1 = new con();

                if (c1.connection == null) {
                    JOptionPane.showMessageDialog(
                            null, "Database connection failed"
                    );
                    return;
                }

                c1.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");

                JOptionPane.showMessageDialog(
                        null, "Rs. " + amount + " Deposited Successfully"
                );

                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Error: " + ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
