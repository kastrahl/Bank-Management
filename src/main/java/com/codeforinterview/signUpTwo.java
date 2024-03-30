package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpTwo extends JFrame implements ActionListener {

    JRadioButton seniorYes,seniorNo,existYes,existNo;
    JMenu religion,category,income,educationqualification,occupation;
    JRadioButtonMenuItem religionHindu,ReligionMuslim,religionChristian,religionSikh,religionOther;
    JRadioButtonMenuItem catGen,catOBC,catSC,catST;
    JRadioButtonMenuItem inc;
    JTextField panNumber,aadharNumber;
    JRadioButtonMenuItem education;



    signUpTwo(){
        //grid layout null for custom layout
        setLayout(null);
        //set window frame
        setTitle("New Application Registration Form - Page 2");
        setSize(800,800);
        setLocation(350,50);
        getContentPane().setBackground(constants.backGroundColor);

        //label page number
        JLabel personaldetails=new JLabel("Page 2: Additional Details");
        personaldetails.setBounds(230,60,400,15);
        personaldetails.setForeground(Color.white);
        add(personaldetails);

        //religion
        //category
        //income
        //educational qualification
        //Occupation
        //PAN
        //Aadhar
        //Senior Citizen
        //Existing Account






        //set it visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
