package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;


public class fastCash extends JFrame implements ActionListener {

    JButton fc1,fc2,exit,fc3, fc4,fc5,fc6;
    String cardNumber,pinNumber;
    ButtonGroup buttonGroup;
    fastCash(String cardNumber,String pinNumber){
        this.cardNumber=cardNumber;
        this.pinNumber=pinNumber;

        setLayout(null);

        //atm image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        //text above image
        JLabel text = new JLabel("Select withdraw amount");
        text.setBounds(150,250,700,35);
        text.setForeground(constants.textLabelColor);
        text.setFont(new Font("System",Font.BOLD,18));
        //to add text above image and not just add to frame
        image.add(text);

        setSize(800,800);
        setLocation(350,20);
        setTitle("Fast Cash");
        //getContentPane().setBackground(constants.backGroundColor);


        //buttons
        buttonGroup = new ButtonGroup();
        //deposit
        fc1=new JButton("Rs 100");
        fc1.setBounds(120,369,150,25);
        image.add(fc1);
        fc1.addActionListener(this);
        buttonGroup.add(fc1);
        //withdrawl
        fc2 =new JButton("Rs 500");
        fc2.setBounds(300,369,150,25);
        image.add(fc2);
        fc2.addActionListener(this);
        buttonGroup.add(fc2);
        //fast cash
        fc3=new JButton("Rs 1000");
        fc3.setBounds(120,402,150,25);
        image.add(fc3);
        fc3.addActionListener(this);
        buttonGroup.add(fc3);
        //mini statement
        fc4=new JButton("Rs 2000");
        fc4.setBounds(300,402,150,25);
        image.add(fc4);
        fc4.addActionListener(this);
        buttonGroup.add(fc4);
        //pin change
        fc5=new JButton("Rs 5000");
        fc5.setBounds(120,436,150,25);
        image.add(fc5);
        fc5.addActionListener(this);
        buttonGroup.add(fc5);
        //balance enquiry
        fc6=new JButton("Rs 10000");
        fc6.setBounds(300,436,150,25);
        image.add(fc6);
        fc6.addActionListener(this);
        buttonGroup.add(fc6);
        //exit to ogin
        exit=new JButton("Back");
        exit.setBounds(300,470,150,25);
        image.add(exit);
        exit.addActionListener(this);


        setUndecorated(true);   // doesn't displays frame box
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == exit) {
            new Login().setVisible(true);
            this.dispose();
        }

        if (a.getSource() == fc1 || a.getSource() == fc2 || a.getSource() == fc3 || a.getSource() == fc4 || a.getSource() == fc5 || a.getSource() == fc6) {
            try (connectionDB conn = new connectionDB()) {
                String tablename = "bank_" + cardNumber;
                String balance_query = "SELECT balance FROM " + tablename + " ORDER BY id DESC LIMIT 1";

                try (ResultSet rs = conn.s.executeQuery(balance_query)) {
                    if (rs.next()) {
                        String balance = rs.getString("balance");
                        double bal = (balance != null && !balance.equals("null")) ? Double.parseDouble(balance) : 0.0;
                        double am = 0.0;
                        String amount = "0";
                        if (a.getSource() == fc1) { am = 100.0; amount = "100"; }
                        else if (a.getSource() == fc2) { am = 500.0; amount = "500"; }
                        else if (a.getSource() == fc3) { am = 1000.0; amount = "1000"; }
                        else if (a.getSource() == fc4) { am = 2000.0; amount = "2000"; }
                        else if (a.getSource() == fc5) { am = 5000.0; amount = "5000"; }
                        else if (a.getSource() == fc6) { am = 10000.0; amount = "10000"; }

                        double newbal = bal - am;
                        if (newbal <= 0.0) {
                            JOptionPane.showMessageDialog(null, "Not Enough Balance in Account");
                            return;
                        }

                        String updateQuery = "INSERT INTO " + tablename + " (cardnumber, date, type, amount, balance) VALUES (?, ?, 'Fast Cash', ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                            Date date = new Date();
                            pstmt.setString(1, cardNumber);
                            pstmt.setString(2, date.toString());
                            pstmt.setString(3, amount);
                            pstmt.setDouble(4, newbal);

                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn");
                                new Login().setVisible(true);
                                this.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error occurred while processing the withdrawal");
                            }
                        }
                    }
                }
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    /*   @Override
     public void actionPerformed(ActionEvent a) {
           if(a.getSource()==exit){
               new Login().setVisible(true);
               this.dispose();
           }
           if(a.getSource()==fc1||a.getSource()==fc2||a.getSource()==fc3||a.getSource()==fc4||a.getSource()==fc5||a.getSource()==fc6){
               Date date = new Date();
               try(connectionDB conn = new connectionDB()){
                   //get user's account statement table
                   String tablename = "bank_"+cardNumber;
                   //call to know balance
                   String balance_query = "SELECT balance FROM "+tablename+" ORDER BY id DESC LIMIT 1";
                   ResultSet rs = conn.s.executeQuery(balance_query);
                   String balance = null;
                   String amount = "0.0";
                   if(rs.next()) {
                       balance = rs.getString("balance");
                       if (balance == null || balance.equals("null")) {
                           balance = "0.0";
                       }
                   }
   //                    ButtonModel selectedButtonModel = buttonGroup.getSelection();
   //                    if (selectedButtonModel != null) {
   //                        JRadioButton selectedButton = (JRadioButton) buttonGroup.getSelection();
   //                        String amount = selectedButton.getText().substring(3);
   //                        Double amountvalue = Double.parseDouble(amount);
   //                        System.out.println(amountvalue);
   //                    }
                   assert balance != null;
                   double bal = Double.parseDouble(balance);
                   double am = 0.0;
                   if(fc1.isSelected()){
                       am = 100.0;
                       amount = "100";
                   }
                   if(fc2.isSelected()){
                       am = 500.0;
                       amount = "500";
                   }
                   if(fc3.isSelected()){
                       am = 1000.0;
                       amount = "1000";
                   }
                   if(fc4.isSelected()){
                       am = 2000.0;
                       amount = "2000";
                   }
                   if(fc5.isSelected()){
                       am = 5000.0;
                       amount = "5000";
                   }
                   if(fc6.isSelected()){
                       am = 10000.0;
                       amount = "10000";
                   }
                   double newbal = bal - am;
                   System.out.println(amount+" "+am+" "+newbal);
                   if(newbal<=0.0){
                       JOptionPane.showMessageDialog(null,"Not Enough Balance in Account");
                       return;
                   }
                   balance = Double.toString(newbal);
                   //updating database
                   String query2 = "INSERT INTO " + tablename + " (cardNumber, date, type, amount, balance) VALUES ('" + cardNumber + "', '" + date.toString() + "', 'Fast Cash', '" + amount + "', '" + balance + "')";
                   conn.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn");
                   new Login().setVisible(true);
                   this.dispose();

               }catch (Exception e){
                   e.printStackTrace();
               }
           }
       }

       private double getNewbal(double bal) {
           double amount = 0.0;
           if(fc1.isSelected()){
               amount = 100.0;
           }else if(fc2.isSelected()){
               amount = 500.0;
           }else if(fc3.isSelected()){
               amount = 1000.0;
           }else if(fc4.isSelected()){
               amount = 2000.0;
           }else if(fc5.isSelected()){
               amount = 5000.0;
           }else if(fc6.isSelected()){
               amount = 10000.0;
           }
           double newbal = bal - amount;
           return newbal;
       }
   */
    public static void main(String[] args) {
        new fastCash("504050446240243","4729");
    }
}
