package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    String pin,card;
    JLabel balance;
    JButton exit;
    balanceEnquiry(String card,String pin){
        this.pin = pin;
        this.card=card;
        setLayout(null);
        //atm image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        setSize(800,800);
        setLocation(350,20);
        setTitle("Balance Enquiry");

        JLabel balanceT = new JLabel("Current Account Balance is:");
        balanceT.setBounds(120,300,250,20);
        balanceT.setFont(new Font("System",Font.BOLD,17));
        balanceT.setForeground(constants.textLabelColor);
        image.add(balanceT);
            //display balance
        balance = new JLabel("");
        balance.setBounds(200,350,250,20);
        balance.setFont(new Font("System",Font.BOLD,15));
        balance.setForeground(constants.textLabelColor);
        image.add(balance);

        try(connectionDB con =new connectionDB()){
            String tablename="bank_"+card;
            String balancequery="SELECT * FROM "+tablename+" ORDER BY id DESC LIMIT 1";
            try(ResultSet rs=con.s.executeQuery(balancequery)){
                if(rs.next()){
                    String balanceDB=rs.getString("balance");
                    balance.setText("Rs "+balanceDB);
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Unable to connect to server","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            new Login().setVisible(true);
            this.dispose();
        }

        exit=new JButton("Exit");
        exit.setBounds(300,470,150,25);
        image.add(exit);
        exit.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            new Login().setVisible(true);
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new balanceEnquiry("504050446240243","4729");
    }
}
