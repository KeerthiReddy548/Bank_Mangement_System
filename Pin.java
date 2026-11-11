package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class Pin extends JFrame implements ActionListener {

    String pin;
    JPasswordField passwordField,passwordField1;
    JButton b1, b2;

    Pin(String pin) {

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

            JLabel label1 = new JLabel("CHANGE YOUR PIN");
            label1.setFont(new Font("System", Font.BOLD, 15));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 700, 35);
            image.add(label1);


            JLabel label2 = new JLabel("NEW PIN: ");
            label2.setFont(new Font("System", Font.BOLD, 15));
            label2.setForeground(Color.WHITE);
            label2.setBounds(330, 280, 700, 20);
            image.add(label2);


            passwordField = new JPasswordField();
            passwordField.setBackground(new Color(65, 125, 128));
            passwordField.setForeground(Color.WHITE);
            passwordField.setFont(new Font("Raleway", Font.BOLD, 20));
            passwordField.setBounds(470, 280, 180, 20);
            image.add(passwordField);


            JLabel label3 = new JLabel("Re-Enter New PIN: ");
            label3.setFont(new Font("System", Font.BOLD, 15));
            label3.setForeground(Color.WHITE);
            label3.setBounds(330, 305, 700, 20);
            image.add(label3);


            passwordField1 = new JPasswordField();
            passwordField1.setBackground(new Color(65, 125, 128));
            passwordField1.setForeground(Color.WHITE);
            passwordField1.setFont(new Font("Raleway", Font.BOLD, 20));
            passwordField1.setBounds(470, 305, 180, 20);
            image.add(passwordField1);



            b1 = new JButton("CHANGE");
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

        try{
            String pin1 = passwordField.getText();
            String pin2 = passwordField1.getText();





            if(e.getSource()==b1){
                if(pin1.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if(pin2.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                con c1 = new con();
                String q1 = "update bank set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin ='"+pin1+"' where pin = '"+pin+"'";


                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_Class(pin);


            }else if(e.getSource()==b2){
                new main_Class(pin);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
            new Pin("");
    }
}
