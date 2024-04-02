package com.codeforinterview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    signupThree() {
        setLayout(null);
        setSize(650,800);
        setLocation(350,50);
        setTitle("Page 3");

        //set title
        JLabel title = new JLabel("Page 3 : Account Details");
        title.setBounds(200,50,400,30);
        title.setFont(new Font("Raleway",Font.BOLD,20));
        add(title);


        //Account type
        JLabel accounttype = new JLabel("Account Type:");
        accounttype.setBounds(100,120,200,30);
        accounttype.setFont(new Font("Raleway",Font.BOLD,20));
        add(accounttype);
        //buttons
        ButtonGroup acctype=new ButtonGroup();
        r1=new JRadioButton("Saving Account");
        r2=new JRadioButton("Current Account");
        r3=new JRadioButton("Recurring Deposit Account");
        r4=new JRadioButton("Fixed Deposit Account");
        r1.setFont(new Font("Raleway",Font.BOLD,10));
        r2.setFont(new Font("Raleway",Font.BOLD,10));
        r3.setFont(new Font("Raleway",Font.BOLD,10));
        r4.setFont(new Font("Raleway",Font.BOLD,10));
        r1.setBounds(100,170,200,20);
        r2.setBounds(310,170,200,20);
        r3.setBounds(100,200,200,20);
        r4.setBounds(310,200,200,20);
        acctype.add(r1);acctype.add(r2);acctype.add(r3);acctype.add(r4);
        add(r1);add(r2);add(r3);add(r4);

// Create checkboxes        -- Y NOT TO USE ? -> NOT EXCLUSIVE -> USE RADIO BUTTON IN BUTTON GROUP
//        JCheckBox checkBox1 = new JCheckBox("Option 1");
//        checkBox1.setBounds(50, 50, 100, 30);
//        JCheckBox checkBox2 = new JCheckBox("Option 2");
//        checkBox1.setBounds(50, 50, 100, 30);
//        add(checkBox2);
//        add(checkBox1);

        //Card number
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setBounds(100,250,200,30);
        cardNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardNumber);
        //number
        JLabel cardNumber1 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardNumber1.setBounds(300,250,200,30);
        cardNumber1.setFont(new Font("Raleway",Font.BOLD,15));
        add(cardNumber1);

        //pin
        JLabel pinNumber = new JLabel("Pin Number:");
        pinNumber.setBounds(100,300,200,30);
        pinNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNumber);
        //number
        JLabel pin = new JLabel("XXXX");
        pin.setBounds(300,300,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        add(pin);
        //disclaimer to note
        JLabel disc1 = new JLabel("Please Note your 16 digit CARD NUMBER and PIN  ");
        disc1.setBounds(150,340,400,30);
        disc1.setFont(new Font("Raleway",Font.BOLD,13));
        add(disc1);

        //Services required
        JLabel services = new JLabel("Services Required:");
        services.setBounds(100,390,200,30);
        services.setFont(new Font("Raleway",Font.BOLD,20));
        add(services);
        //check boxes
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(100,430,200,20);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(400,430,200,20);
        add(c2);
        c3 = new JCheckBox("Cheque Book");
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBounds(100,465,200,20);
        add(c3);
        c4 = new JCheckBox("Mobile Banking");
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBounds(400,465,200,20);
        add(c4);
        c5 = new JCheckBox("Email Alerts");
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBounds(100,500,200,20);
        add(c5);
        c6 = new JCheckBox("E-Statements");
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBounds(400,500,200,20);
        add(c6);

        //disclaimer
        JCheckBox disclaimer = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        disclaimer.setFont(new Font("Raleway",Font.BOLD,10));
        disclaimer.setBounds(100,600,400,20);
        add(disclaimer);

        //submit button
        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,10));
        submit.setBounds(100,700,200,20);
        submit.setForeground(constants.textLabelColor);
        submit.setBackground(Color.BLACK);
        add(submit);
        //cencel button
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,10));
        cancel.setBounds(300,700,200,20);
        cancel.setForeground(constants.textLabelColor);
        cancel.setBackground(Color.BLACK);
        add(cancel);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new signupThree();
    }
}
