
package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1, r2;
    JTextField textName, FatName, textemail, textadd,
            textcity, textpin, textstate;
    JDateChooser dateChooser;
    JButton next;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {

        super("APPLICATION FORM");

        try {
            URL url = new URL(
                    "https://static.vecteezy.com/system/resources/previews/026/703/428/original/illustration-of-bank-management-icon-in-dark-color-and-white-background-free-vector.jpg"
            );

            ImageIcon il1 = new ImageIcon(url);
            Image i2 = il1.getImage().getScaledInstance(
                    100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(25, 10, 100, 100);
            add(image);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160, 10, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330, 50, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Personal Information");
        label3.setBounds(290, 70, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(100, 140, 100, 30);
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 140, 400, 30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name:");
        labelfName.setBounds(100, 180, 200, 30);
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelfName);

        FatName = new JTextField();
        FatName.setFont(new Font("Raleway", Font.BOLD, 14));
        FatName.setBounds(300, 180, 400, 30);
        add(FatName);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setBounds(100, 220, 200, 30);
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 220, 400, 30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setBounds(100, 260, 200, 30);
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 220));
        r1.setBounds(300, 260, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 220));
        r2.setBounds(450, 260, 90, 30);
        add(r2);

        ButtonGroup button = new ButtonGroup();
        button.add(r1);
        button.add(r2);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 310, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setFont(new Font("Raleway", Font.BOLD, 14));
        textemail.setBounds(300, 310, 400, 30);
        add(textemail);

        JLabel ladd = new JLabel("Address:");
        ladd.setBounds(100, 350, 200, 30);
        ladd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ladd);

        textadd = new JTextField();
        textadd.setFont(new Font("Raleway", Font.BOLD, 14));
        textadd.setBounds(300, 350, 400, 30);
        add(textadd);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 390, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway", Font.BOLD, 14));
        textcity.setBounds(300, 390, 400, 30);
        add(textcity);

        JLabel pin = new JLabel("Pin Code:");
        pin.setBounds(100, 430, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        textpin = new JTextField();
        textpin.setFont(new Font("Raleway", Font.BOLD, 14));
        textpin.setBounds(300, 430, 400, 30);
        add(textpin);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 470, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);

        textstate = new JTextField();
        textstate.setFont(new Font("Raleway", Font.BOLD, 14));
        textstate.setBounds(300, 470, 400, 30);
        add(textstate);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 550, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = FatName.getText();

        String dob = dateChooser.getDate() == null
                ? ""
                : ((JTextField) dateChooser.getDateEditor()
                .getUiComponent()).getText();

        String gender = null;

        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }

        String email = textemail.getText();
        String address = textadd.getText();
        String city = textcity.getText();
        String pincode = textpin.getText();
        String state = textstate.getText();

        try {

            if (name.isEmpty() || fname.isEmpty() ||
                    dob.isEmpty() || gender == null ||
                    email.isEmpty() || address.isEmpty() ||
                    city.isEmpty() || pincode.isEmpty() ||
                    state.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null, "Fill all the fields");

            } else {

                con con1 = new con();

                String q = "insert into signup values('" +
                        formno + "', '" + name + "', '" +
                        fname + "', '" + dob + "', '" +
                        gender + "', '" + email + "', '" +
                        address + "', '" + city + "', '" +
                        pincode + "', '" + state + "')";

                con1.statement.executeUpdate(q);

                new SignUp2(first);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup());
    }
}
