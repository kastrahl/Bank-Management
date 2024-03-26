package com.codeforinterview;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login(){    //constructor

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));

        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);

        JLabel label =new JLabel(i1);           //create label for the icon
        add(label);                             //add image to frame
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