package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    String pin,card;
    JButton submit,cancel,clear;
    withdrawal(String card,String pin){
        this.pin = pin;
        this.card=card;
        setLayout(null);
        setSize(800,800);
        setLocation(350,20);
        setTitle("Withdraw");
        //atm image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        //text above image
        JLabel text = new JLabel("Enter amount you want to withdraw");
        text.setBounds(140,250,700,35);
        text.setForeground(constants.textLabelColor);
        text.setFont(new Font("System",Font.BOLD,18));
        //to add text above image and not just add to frame
        image.add(text);

        //amount text field
        amount=new JTextField();
        amount.setBounds(200,300,180,30);
        amount.setFont(new Font("Raleway",Font.BOLD,28));
        image.add(amount);

        //submit
        submit = new JButton("Submit");
        submit.setBounds(300,369,150,25);
        image.add(submit);
        submit.addActionListener(this);
        //clear
        clear = new JButton("Clear");
        clear.setBounds(120,400,150,25);
        image.add(clear);
        clear.addActionListener(this);

        //cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(120,369,150,25);
        image.add(cancel);
        cancel.addActionListener(this);

        setUndecorated(true);   // doesn't displays frame box
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear)
            amount.setText("");
        if(e.getSource()==cancel){
            new Transactions(card, pin);
            this.dispose();
        }
        if(e.getSource()==submit){
            Date date=new Date();

            if(amount.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"please enter amount to withdraw");
            }else {
                try(connectionDB c = new connectionDB()){
                    //String query = "insert into bank values('"+ pin +"','"+date.toString()+"','Deposit','"+amount.getText()+"')";
                    String tableName = "bank_"+card;
                    //System.out.println(tableName);
                    String query = "Select balance from "+tableName+" ORDER BY id DESC LIMIT 1";
                    ResultSet rs=c.s.executeQuery(query);
                    String balance = null;
                    if(rs.next()){
                        balance=rs.getString("balance");
                        if (balance == null|| balance.equals("null")) {
                            // If balance is null, initialize it to 0.0
                            balance = "0.0";
                        }
                        double bal=Double.parseDouble(balance);
                        double newbal = bal - Double.parseDouble(amount.getText());

                        if(newbal<=0.0){
                            JOptionPane.showMessageDialog(null,"Not Enough Balance");
                            return;
                        }
                        balance = Double.toString(newbal);
                    }
                    //String query2 = "insert into bank values('"+ card +"','"+pin+"','"+date.toString()+"','Deposit','"+amount.getText()+"','"+balance+"')";
                    String query2 = "INSERT INTO " + tableName + " (cardNumber, date, type, amount, balance) VALUES ('" + card + "', '" + date.toString() + "', 'withdraw', '" + amount.getText() + "', '" + balance + "')";

                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Rs "+amount.getText()+" Withdrawn successfully");
                    this.setVisible(false);
                    new Transactions(card,pin).setVisible(true);
                }catch (Exception a){
                    a.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Unable to connect to server");
                }
            }
        }
    }
    public static void main(String[] args) {
        new withdrawal("504050446240243","4729");
    }
}
