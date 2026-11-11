
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.ResultSet;

public class BlanceEnquriy extends JFrame implements ActionListener {

    String pin;
    JButton b1;
    JLabel label2;

    BlanceEnquriy(String pin) {

        this.pin = pin;

        try {
            URL url = new URL("https://media.istockphoto.com/id/1301853612/vector/atm-bank-cash-machine-3d-realistic-front-view-atm-street-kiosk-bankomat-service.jpg?s=170667a&w=0&k=20&c=QqFW_DylM0QHvN54aK7ifwR5kKu8y5QEYCAEdJkBljM=");

            ImageIcon il1 = new ImageIcon(url);

            Image i2 = il1.getImage().getScaledInstance(
                    1200, 630, Image.SCALE_DEFAULT);

            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1200, 630);
            add(image);

            JLabel label1 = new JLabel("Your Current Balance is Rs");
            label1.setFont(new Font("System", Font.BOLD, 16));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 700, 35);
            image.add(label1);

            label2 = new JLabel();
            label2.setFont(new Font("System", Font.BOLD, 16));
            label2.setForeground(Color.WHITE);
            label2.setBounds(350, 280, 400, 35);
            image.add(label2);

            b1 = new JButton("Back");
            b1.setBounds(570, 350, 100, 25);
            b1.setBackground(new Color(65, 125, 128));
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            image.add(b1);

            int balance = 0;

            try {
                con c = new con();

                ResultSet resultSet = c.statement.executeQuery(
                        "SELECT * FROM bank WHERE pin = '" + pin + "'");

                while (resultSet.next()) {

                    if (resultSet.getString("type").equals("Deposit")) {

                        balance += Integer.parseInt(
                                resultSet.getString("amount"));

                    } else if (resultSet.getString("type").equals("Withdrawl")) {

                        balance -= Integer.parseInt(
                                resultSet.getString("amount"));
                    }
                }

                resultSet.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            label2.setText("" + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(1200, 630);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {

        new BlanceEnquriy("");
    }
}

