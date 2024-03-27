package com.codeforinterview;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login(){    //constructor

        setLayout(null);                        //we'll use custom layout so setBounds works
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));

        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);  //resizing image
        ImageIcon i3 = new ImageIcon(i2);       //cannot pass image to jlabel   appeares in center
        JLabel label =new JLabel(i3);           //create label for the icon ,

                                                            //need to change center location of the icon
        label.setBounds(50,30,50,50);     //will still be in center because java use layout to arrange
                                                            //we'll use setlayout to cutomize this
        add(label);                                         //add image to frame
        getContentPane().setBackground(Color.WHITE);

        // title inside window pane
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200,30,400,40);                               //compulsory to define as setlayout is null
        add(text);                                                  //from top title takes 70px

        //adding label for table entries and fields
        //card number
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardno.setBounds(150,200,200,40);             //must be >70px
        add(cardno);

        //adding text field for card number
        JTextField cardtextfield = new JTextField();
        cardtextfield.setBounds(350,200,200,40);
        add(cardtextfield);

        //Pin number
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,25));
        Pin.setBounds(150,250,200,40);
        add(Pin);
        //adding text field for pin number
        JTextField pintextfield = new JTextField();
        pintextfield.setBounds(350,250,100,40);
        add(pintextfield);

        //add buttons
        //sign in
        JButton login=new JButton("Sign In");
        login.setBounds(350,300,100,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        add(login);
        //Clear button
        JButton Clear=new JButton("Clear");
        Clear.setBounds(500,380,100,40);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        add(Clear);
        //Register button
        JButton Register=new JButton("Register");
        Register.setBounds(200,380,100,40);
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.white);
        add(Register);

        setTitle("Automated Teller Machine");
        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);



    }
    public static void main(String[] args) {
        new Login();
        System.out.println("Hello world!");
    }

}