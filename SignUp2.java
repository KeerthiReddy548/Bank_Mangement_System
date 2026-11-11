
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;

    JComboBox<String> comboBox, comboBox2, comboBox3,
            comboBox4, comboBox5;

    JButton next;

    JTextField textPan, textad;

    String formno;

    SignUp2(String first) {

        super("Application Form");

        this.formno = first;

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

            JLabel l1 = new JLabel("Page 2");
            l1.setBounds(300, 30, 600, 40);
            l1.setFont(new Font("Raleway", Font.BOLD, 20));
            add(l1);

            JLabel l2 = new JLabel("Additional Details");
            l2.setBounds(300, 60, 600, 40);
            l2.setFont(new Font("Raleway", Font.BOLD, 20));
            add(l2);

            // Religion

            JLabel l3 = new JLabel("Religion");
            l3.setBounds(100, 120, 100, 30);
            l3.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l3);

            String religion[] = {
                    "Hindu", "Muslim", "Sikh", "Christian", "Other"
            };

            comboBox = new JComboBox<>(religion);
            comboBox.setBackground(new Color(252, 208, 76));
            comboBox.setBounds(350, 120, 320, 30);
            add(comboBox);

            // Category

            JLabel l4 = new JLabel("Category");
            l4.setBounds(100, 170, 100, 30);
            l4.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l4);

            String category[] = {
                    "General", "OBC", "SC", "ST", "Other"
            };

            comboBox2 = new JComboBox<>(category);
            comboBox2.setBackground(new Color(252, 208, 76));
            comboBox2.setBounds(350, 170, 320, 30);
            add(comboBox2);

            // Income

            JLabel l5 = new JLabel("Income");
            l5.setBounds(100, 220, 100, 30);
            l5.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l5);

            String income[] = {
                    "Null", "<1,50,000", "<2,50,000",
                    "<5,00,000", "UPTO 10,00,000",
                    "Above 10,00,000"
            };

            comboBox3 = new JComboBox<>(income);
            comboBox3.setBackground(new Color(252, 208, 76));
            comboBox3.setBounds(350, 220, 320, 30);
            add(comboBox3);

            // Education

            JLabel l6 = new JLabel("Education");
            l6.setBounds(100, 270, 150, 30);
            l6.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l6);

            String educational[] = {
                    "Non-Graduate", "Graduate",
                    "Post-Graduate", "Doctorate", "Others"
            };

            comboBox4 = new JComboBox<>(educational);
            comboBox4.setBackground(new Color(252, 208, 76));
            comboBox4.setBounds(350, 270, 320, 30);
            add(comboBox4);

            // Occupation

            JLabel l7 = new JLabel("Occupation");
            l7.setBounds(100, 320, 320, 30);
            l7.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l7);

            String occupation[] = {
                    "Salaried", "Self-Employed",
                    "Business", "Student", "Retired", "Other"
            };

            comboBox5 = new JComboBox<>(occupation);
            comboBox5.setBackground(new Color(252, 208, 76));
            comboBox5.setBounds(350, 320, 320, 30);
            add(comboBox5);

            // PAN Number

            JLabel l8 = new JLabel("PAN Number");
            l8.setBounds(100, 370, 150, 30);
            l8.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l8);

            textPan = new JTextField();
            textPan.setFont(new Font("Raleway", Font.BOLD, 18));
            textPan.setBounds(350, 370, 320, 30);
            add(textPan);

            // Aadhaar Number

            JLabel l9 = new JLabel("Aadhaar Number");
            l9.setBounds(100, 420, 200, 30);
            l9.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l9);

            textad = new JTextField();
            textad.setFont(new Font("Raleway", Font.BOLD, 18));
            textad.setBounds(350, 420, 320, 30);
            add(textad);

            // Senior Citizen

            JLabel l10 = new JLabel("Senior Citizen");
            l10.setBounds(100, 470, 180, 30);
            l10.setFont(new Font("Raleway", Font.BOLD, 20));
            add(l10);

            r1 = new JRadioButton("NO");
            r1.setFont(new Font("Raleway", Font.BOLD, 14));
            r1.setBackground(new Color(252, 208, 76));
            r1.setBounds(350, 470, 100, 30);
            add(r1);

            r2 = new JRadioButton("YES");
            r2.setFont(new Font("Raleway", Font.BOLD, 14));
            r2.setBackground(new Color(252, 208, 76));
            r2.setBounds(460, 470, 100, 30);
            add(r2);

            ButtonGroup button = new ButtonGroup();
            button.add(r1);
            button.add(r2);

            // Existing Account

            JLabel l11 = new JLabel("Existing Account");
            l11.setBounds(100, 520, 180, 30);
            l11.setFont(new Font("Raleway", Font.BOLD, 20));
            add(l11);

            r3 = new JRadioButton("NO");
            r3.setFont(new Font("Raleway", Font.BOLD, 14));
            r3.setBackground(new Color(252, 208, 76));
            r3.setBounds(350, 520, 100, 30);
            add(r3);

            r4 = new JRadioButton("YES");
            r4.setFont(new Font("Raleway", Font.BOLD, 14));
            r4.setBackground(new Color(252, 208, 76));
            r4.setBounds(460, 520, 100, 30);
            add(r4);

            ButtonGroup b2 = new ButtonGroup();
            b2.add(r3);
            b2.add(r4);

            // Form Number

            JLabel l12 = new JLabel("Form No:");
            l12.setBounds(700, 10, 100, 30);
            l12.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l12);

            JLabel l13 = new JLabel(first);
            l13.setBounds(770, 10, 60, 30);
            l13.setFont(new Font("Raleway", Font.BOLD, 18));
            add(l13);

            // Next Button

            next = new JButton("Next");
            next.setFont(new Font("Raleway", Font.BOLD, 14));
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(620, 550, 80, 30);
            next.addActionListener(this);
            add(next);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(252, 208, 76));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == next) {

            String rel = (String) comboBox.getSelectedItem();
            String cat = (String) comboBox2.getSelectedItem();
            String inc = (String) comboBox3.getSelectedItem();
            String edu = (String) comboBox4.getSelectedItem();
            String occ = (String) comboBox5.getSelectedItem();

            String pan = textPan.getText().trim();
            String adhar = textad.getText().trim();

            String citizen = "";
            String eacc = "";

            // Senior Citizen Validation

            if (r1.isSelected()) {
                citizen = "No";
            } else if (r2.isSelected()) {
                citizen = "Yes";
            } else {
                JOptionPane.showMessageDialog(
                        null, "Please select Senior Citizen"
                );
                return;
            }

            // Existing Account Validation

            if (r3.isSelected()) {
                eacc = "No";
            } else if (r4.isSelected()) {
                eacc = "Yes";
            } else {
                JOptionPane.showMessageDialog(
                        null, "Please select Existing Account"
                );
                return;
            }

            // PAN and Aadhaar Validation

            if (pan.isEmpty() || adhar.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null, "Please fill all the fields"
                );

                return;
            }

            // PAN Validation

            if (!pan.matches("[A-Za-z]{5}[0-9]{4}[A-Za-z]")) {

                JOptionPane.showMessageDialog(
                        null, "Please enter a valid PAN Number"
                );

                return;
            }

            // Aadhaar Validation

            if (!adhar.matches("[0-9]{12}")) {

                JOptionPane.showMessageDialog(
                        null, "Please enter a valid 12-digit Aadhaar Number"
                );

                return;
            }

            try {

                con c = new con();

                if (c.connection == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed!");
                    return;
                }


                String q ="INSERT INTO signuptwo VALUES(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps =
                        c.connection.prepareStatement(q);

                ps.setString(1, formno);
                ps.setString(2, rel);
                ps.setString(3, cat);
                ps.setString(4, inc);
                ps.setString(5, edu);
                ps.setString(6, occ);
                ps.setString(7, pan);
                ps.setString(8, adhar);
                ps.setString(9, citizen);
                ps.setString(10, eacc);

                ps.executeUpdate();

                new SignUp3(formno);

                setVisible(false);

            } catch (Exception E) {

                E.printStackTrace();

                JOptionPane.showMessageDialog(
                        null, E.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {

        new SignUp2("");
    }
}
