
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField2;
    JButton button1, button2, button3;

    login() throws MalformedURLException {

        super("Bank Management System");

        setSize(850, 480);
        setLocation(450, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Image
        URL bgURL = new URL(
                "https://static.vecteezy.com/system/resources/thumbnails/009/873/425/small_2x/abstract-background-blue-and-white-overlap-layer-with-copy-space-background-illustration-vector.jpg"
        );

        ImageIcon bgIcon = new ImageIcon(bgURL);
        Image bgImage = bgIcon.getImage().getScaledInstance(
                850, 480, Image.SCALE_SMOOTH
        );

        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 850, 480);
        background.setLayout(null);
        setContentPane(background);

        // Bank Image
        URL url = new URL(
                "https://static.vecteezy.com/system/resources/previews/026/703/428/original/illustration-of-bank-management-icon-in-dark-color-and-white-background-free-vector.jpg"
        );

        ImageIcon il1 = new ImageIcon(url);
        Image i2 = il1.getImage().getScaledInstance(
                100, 100, Image.SCALE_DEFAULT
        );

        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(450, 10, 100, 100);
        background.add(image);

        // Card Image
        URL url2 = new URL(
                "https://img.freepik.com/premium-vector/bank-credit-card-icon-flat-style-isolated-white-background_96318-37652.jpg"
        );

        ImageIcon ii1 = new ImageIcon(url2);
        Image ii2 = ii1.getImage().getScaledInstance(
                150, 100, Image.SCALE_DEFAULT
        );

        JLabel image2 = new JLabel(new ImageIcon(ii2));
        image2.setBounds(600, 350, 150, 100);
        background.add(image2);

        // Welcome Label
        label1 = new JLabel("Welcome To ATM");
        label1.setFont(new Font("AvantGarde", Font.BOLD, 30));
        label1.setBounds(350, 125, 450, 40);
        background.add(label1);

        // Card Number
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setBounds(350, 190, 125, 30);
        background.add(label2);

        textField1 = new JTextField(15);
        textField1.setBounds(480, 190, 230, 30);
        textField1.setFont(new Font("Arial", Font.BOLD, 14));
        background.add(textField1);

        // PIN
        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setBounds(350, 250, 125, 30);
        background.add(label3);

        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(480, 250, 230, 30);
        passwordField2.setFont(new Font("Arial", Font.BOLD, 14));
        background.add(passwordField2);

        // Sign In Button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBounds(400, 300, 100, 30);
        button1.addActionListener(this);
        background.add(button1);

        // Clear Button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBounds(525, 300, 100, 30);
        button2.addActionListener(this);
        background.add(button2);

        // Sign Up Button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setBounds(650, 300, 100, 30);
        button3.addActionListener(this);
        background.add(button3);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == button1) {

                String cardno = textField1.getText().trim();
                String pin = new String(
                        passwordField2.getPassword()
                );

                if (cardno.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Please enter Card Number and PIN"
                    );
                    return;
                }

                con c = new con();

                String query =
                        "SELECT * FROM login WHERE card_number = ? AND pin = ?";

                PreparedStatement ps =
                        c.connection.prepareStatement(query);

                ps.setString(1, cardno);
                ps.setString(2, pin);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            null, "Login Successful!"
                    );

                    setVisible(false);
                    new main_Class(pin);


                } else {

                    JOptionPane.showMessageDialog(
                            null, "Invalid Card Number or PIN"
                    );
                }

            } else if (e.getSource() == button2) {

                textField1.setText("");
                passwordField2.setText("");

            } else if (e.getSource() == button3) {

                new Signup();
                setVisible(false);

            }

        } catch (Exception E) {
            E.printStackTrace();

            JOptionPane.showMessageDialog(
                    null, "Error: " + E.getMessage()
            );
        }
    }

    public static void main(String[] args)
            throws MalformedURLException {

        new login();
    }
}


