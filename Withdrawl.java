package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1, b2;
    Withdrawl(String pin){
        this.pin=pin;
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
                    "MAXIMUM WITHDRAWAL IS RS.10,000:"
            );
            label1.setFont(new Font("System", Font.BOLD, 10));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 400, 35);
            image.add(label1);

            JLabel label2 = new JLabel(
                    "PLEASE ENTER YOUR AMOUNT"
            );
            label2.setFont(new Font("System", Font.BOLD, 10));
            label2.setForeground(Color.WHITE);
            label2.setBounds(350, 270, 400, 35);
            image.add(label2);

            textField = new TextField();
            textField.setBackground(new Color(65, 125, 128));
            textField.setForeground(Color.WHITE);
            textField.setFont(new Font("Raleway", Font.BOLD, 20));
            textField.setBounds(350, 300, 270, 25);
            image.add(textField);

            b1 = new JButton("WithDraw");
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

public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1) {
           try {
               String amount = textField.getText();
               Date date = new Date();

               if (textField.getText().equals("")) {
                   JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");

               } else {
                   con c = new con();
                   ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '" + pin + "'");
                   int balance = 0;
                   while (resultSet.next()) {
                       if (resultSet.getString("type").equals("Deposit")) {
                           balance += Integer.parseInt(resultSet.getString("amount"));
                       } else {
                           balance -= Integer.parseInt(resultSet.getString("amount"));
                       }
                   }
                   if (balance < Integer.parseInt(amount)) {
                       JOptionPane.showMessageDialog(null, "Insuffient Blance");
                       return;
                   }
                   c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "','withdrawl','" + amount + "')");
                   JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                   setVisible(false);
                   new main_Class(pin);
               }

           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }else if(e.getSource()==b2){
           setVisible(false);
           new main_Class(pin);
       }
}




    public static void main(String args[]){
        new Withdrawl("");
    }

}
