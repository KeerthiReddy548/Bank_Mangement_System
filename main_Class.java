package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Class(String pin){
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


            JLabel label1 = new JLabel("Please Select Your Trasaction");
            label1.setFont(new Font("System", Font.BOLD, 16));
            label1.setForeground(Color.WHITE);
            label1.setBounds(350, 250, 400, 35);
            image.add(label1);


            b1 = new JButton("Deposit");
            b1.setBounds(310, 297, 100, 20);
            b1.setBackground(new Color(65, 125, 128));
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            image.add(b1);


            b2 = new JButton("CashWithDrawl");
            b2.setBounds(570, 297, 100, 20);
            b2.setBackground(new Color(65, 125, 128));
            b2.setForeground(Color.WHITE);
            b2.addActionListener(this);
            image.add(b2);


            b3 = new JButton("FastCash");
            b3.setBounds(310, 320, 100, 20);
            b3.setBackground(new Color(65, 125, 128));
            b3.setForeground(Color.WHITE);
            b3.addActionListener(this);
            image.add(b3);

            b4 = new JButton("MiniStmt");
            b4.setBounds(570, 320, 100, 20);
            b4.setBackground(new Color(65, 125, 128));
            b4.setForeground(Color.WHITE);
            b4.addActionListener(this);
            image.add(b4);


            b5 = new JButton("PinChange");
            b5.setBounds(310, 345, 100, 20);
            b5.setBackground(new Color(65, 125, 128));
            b5.setForeground(Color.WHITE);
            b5.addActionListener(this);
            image.add(b5);

            b6 = new JButton("Balance Enqiry");
            b6.setBounds(570, 345, 100, 20);
            b6.setBackground(new Color(65, 125, 128));
            b6.setForeground(Color.WHITE);
            b6.addActionListener(this);
            image.add(b6);




            b7 = new JButton("Exit");
            b7.setBounds(570, 370, 100, 20);
            b7.setBackground(new Color(65, 125, 128));
            b7.setForeground(Color.WHITE);
            b7.addActionListener(this);
            image.add(b7);


        }catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(null);
        setSize(1200,630);
        setLocation(0,0);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);

        }else if(e.getSource()==b7){
            System.exit(0);
        }else if(e.getSource()==b2){
            new Withdrawl(pin);
            setVisible(false);
        }else if(e.getSource()==b6){
            new BlanceEnquriy(pin);
            setVisible(false);
        }else if(e.getSource()==b3){
            new FastCash(pin);
            setVisible(false);
        }else if(e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        }else if(e.getSource()==b4){
            new mini(pin);
            setVisible(false);
        }

    }

    public static void main(String[] args){
        new main_Class("");
    }
}
