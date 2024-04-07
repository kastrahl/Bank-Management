package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,balanceEnquiry,exit,miniStatement, withdrawal,pinChange,fast;
    String pinNumber;
    Transactions(String pinNumber){
        //this.formnum=formNumber;
        setLayout(null);

        //atm image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        //text above image
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(150,250,700,35);
        text.setForeground(constants.textLabelColor);
        text.setFont(new Font("System",Font.BOLD,18));
        //to add text above image and not just add to frame
        image.add(text);

        setSize(800,800);
        setLocation(350,20);
        setTitle("Transactions");
        //getContentPane().setBackground(constants.backGroundColor);


        //buttons
        //deposit
        deposit=new JButton("Deposit");
        deposit.setBounds(120,369,150,25);
        image.add(deposit);
        deposit.addActionListener(this);
        //withdrawl
        withdrawal =new JButton("Cash Withdrawl");
        withdrawal.setBounds(300,369,150,25);
        image.add(withdrawal);
        withdrawal.addActionListener(this);
        //fast cash
        fast=new JButton("Fast cash");
        fast.setBounds(120,402,150,25);
        image.add(fast);
        fast.addActionListener(this);
        //mini statement
        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(300,402,150,25);
        image.add(miniStatement);
        miniStatement.addActionListener(this);
        //pin change
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(120,436,150,25);
        image.add(pinChange);
        pinChange.addActionListener(this);
        //balance enquiry
        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(300,436,150,25);
        image.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);
        //exit to ogin
        exit=new JButton("Exit");
        exit.setBounds(300,470,150,25);
        image.add(exit);
        exit.addActionListener(this);


        setUndecorated(true);   // doesn't displays frame box
        setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("123123");
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getSource()==exit){
            new Login().setVisible(true);
            this.dispose();
        }
        if(a.getSource()==deposit){

        }
        if(a.getSource()==miniStatement){

        }
        if(a.getSource()==pinChange){

        }
        if(a.getSource()==fast){

        }
        if(a.getSource()==withdrawal){

        }
        if(a.getSource()==balanceEnquiry){

        }
    }
}
