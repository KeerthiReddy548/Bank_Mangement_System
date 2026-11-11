
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignUp3(String formno) {
        this.formno = formno;

        try {
            URL url = new URL(
                    "https://static.vecteezy.com/system/resources/previews/026/703/428/original/illustration-of-bank-management-icon-in-dark-color-and-white-background-free-vector.jpg"
            );

            ImageIcon il1 = new ImageIcon(url);

            Image i2 = il1.getImage().getScaledInstance(
                    100, 100, Image.SCALE_DEFAULT
            );

            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(150, 5, 100, 100);
            add(image);

            JLabel l1 = new JLabel("Page 3:");
            l1.setBounds(280, 40, 400, 40);
            l1.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l1);

            JLabel l2 = new JLabel("Account Details");
            l2.setBounds(280, 70, 400, 40);
            l2.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l2);

            JLabel l3 = new JLabel("Account Type");
            l3.setBounds(100, 130, 200, 30);
            l3.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l3);

            r1 = new JRadioButton("Saving Account");
            r1.setFont(new Font("Raleway", Font.BOLD, 14));
            r1.setBackground(new Color(215, 252, 252));
            r1.setBounds(100, 170, 150, 30);
            add(r1);

            r2 = new JRadioButton("Fixed Deposit Account");
            r2.setFont(new Font("Raleway", Font.BOLD, 14));
            r2.setBackground(new Color(215, 252, 252));
            r2.setBounds(350, 170, 300, 30);
            add(r2);

            r3 = new JRadioButton("Current Account");
            r3.setFont(new Font("Raleway", Font.BOLD, 14));
            r3.setBackground(new Color(215, 252, 252));
            r3.setBounds(100, 210, 250, 30);
            add(r3);

            r4 = new JRadioButton("Recurring Deposit Account");
            r4.setFont(new Font("Raleway", Font.BOLD, 14));
            r4.setBackground(new Color(215, 252, 252));
            r4.setBounds(350, 210, 250, 30);
            add(r4);

            ButtonGroup button = new ButtonGroup();
            button.add(r1);
            button.add(r2);
            button.add(r3);
            button.add(r4);

            JLabel l4 = new JLabel("Card Number");
            l4.setBounds(100, 260, 200, 30);
            l4.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l4);

            JLabel l5 = new JLabel("(Your 16-digit Card Number)");
            l5.setBounds(100, 280, 200, 20);
            l5.setFont(new Font("Raleway", Font.BOLD, 12));
            add(l5);

            JLabel l6 = new JLabel("xxxx-xxxx-xxxx-4832");
            l6.setBounds(330, 260, 250, 30);
            l6.setFont(new Font("Raleway", Font.BOLD, 12));
            add(l6);

            JLabel l7 = new JLabel(
                    "(It would appear on ATM card/cheque Book and Statements)"
            );
            l7.setBounds(330, 280, 500, 20);
            l7.setFont(new Font("Raleway", Font.BOLD, 12));
            add(l7);

            JLabel l8 = new JLabel("PIN:");
            l8.setBounds(100, 320, 200, 30);
            l8.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l8);

            JLabel l9 = new JLabel("xxxx");
            l9.setBounds(330, 320, 200, 30);
            l9.setFont(new Font("Raleway", Font.BOLD, 12));
            add(l9);

            JLabel l10 = new JLabel("(4-digit Password)");
            l10.setBounds(100, 340, 200, 20);
            l10.setFont(new Font("Raleway", Font.BOLD, 12));
            add(l10);

            JLabel l11 = new JLabel("Service Required");
            l11.setBounds(100, 370, 200, 30);
            l11.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l11);

            c1 = new JCheckBox("ATM CARD");
            c1.setFont(new Font("Raleway", Font.BOLD, 16));
            c1.setBackground(new Color(215, 252, 252));
            c1.setBounds(100, 400, 200, 30);
            add(c1);

            c2 = new JCheckBox("Internet Banking");
            c2.setFont(new Font("Raleway", Font.BOLD, 16));
            c2.setBackground(new Color(215, 252, 252));
            c2.setBounds(350, 400, 200, 30);
            add(c2);

            c3 = new JCheckBox("Mobile Banking");
            c3.setFont(new Font("Raleway", Font.BOLD, 16));
            c3.setBackground(new Color(215, 252, 252));
            c3.setBounds(100, 440, 200, 30);
            add(c3);

            c4 = new JCheckBox("Email Alert");
            c4.setFont(new Font("Raleway", Font.BOLD, 16));
            c4.setBackground(new Color(215, 252, 252));
            c4.setBounds(350, 440, 200, 30);
            add(c4);

            c5 = new JCheckBox("Cheque Book");
            c5.setFont(new Font("Raleway", Font.BOLD, 16));
            c5.setBackground(new Color(215, 252, 252));
            c5.setBounds(100, 480, 200, 30);
            add(c5);

            c6 = new JCheckBox("E-Statement");
            c6.setFont(new Font("Raleway", Font.BOLD, 16));
            c6.setBackground(new Color(215, 252, 252));
            c6.setBounds(350, 480, 200, 30);
            add(c6);

            c7 = new JCheckBox(
                    "I hereby declare that the above entered details are correct"
            );
            c7.setFont(new Font("Raleway", Font.BOLD, 12));
            c7.setBackground(new Color(215, 252, 252));
            c7.setBounds(100, 540, 650, 30);
            add(c7);

            submit = new JButton("Submit");
            submit.setFont(new Font("Raleway", Font.BOLD, 14));
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            submit.setBounds(220, 620, 100, 30);
            add(submit);

            cancel = new JButton("Cancel");
            cancel.setFont(new Font("Raleway", Font.BOLD, 14));
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.setBounds(420, 620, 100, 30);
            add(cancel);

            submit.addActionListener(this);
            cancel.addActionListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(215, 252, 252));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancel) {
            System.exit(0);
        }

        if (e.getSource() == submit) {

            String atype = null;

            if (r1.isSelected()) {
                atype = "Saving Account";
            } else if (r2.isSelected()) {
                atype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                atype = "Current Account";
            } else if (r4.isSelected()) {
                atype = "Recurring Deposit Account";
            }

            if (atype == null) {
                JOptionPane.showMessageDialog(
                        null, "Please select Account Type"
                );
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(
                        null, "Please accept the declaration"
                );
                return;
            }

            Random ran = new Random();

            long first7 = Math.abs(ran.nextLong() % 90000000L)
                    + 1409963000000000L;

            String cardno = String.valueOf(first7);

            long first3 = Math.abs(ran.nextLong() % 9000L) + 1000L;

            String pin = String.valueOf(first3);

            StringBuilder fac = new StringBuilder();

            if (c1.isSelected()) {
                fac.append("ATM CARD, ");
            }

            if (c2.isSelected()) {
                fac.append("Internet Banking, ");
            }

            if (c3.isSelected()) {
                fac.append("Mobile Banking, ");
            }

            if (c4.isSelected()) {
                fac.append("Email Alerts, ");
            }

            if (c5.isSelected()) {
                fac.append("Cheque Book, ");
            }

            if (c6.isSelected()) {
                fac.append("E-Statement, ");
            }

            String facilities = fac.toString();

            if (facilities.isEmpty()) {
                facilities = "None";
            }

            try {

                con c = new con();

                String q1 = "INSERT INTO signupthree VALUES('" +
                        formno + "', '" +
                        atype + "', '" +
                        cardno + "', '" +
                        pin + "', '" +
                        facilities + "')";

                String q2 = "INSERT INTO login VALUES('" +
                        formno + "', '" +
                        cardno + "', '" +
                        pin + "')";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(
                        null,
                        "Card Number : " + cardno +
                                "\nPIN : " + pin
                );
                new Deposit(pin);
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null, "Database Error: " + ex.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
