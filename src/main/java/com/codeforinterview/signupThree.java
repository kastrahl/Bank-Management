package com.codeforinterview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,disclaimer;
    JButton submit,cancel;
    String formnum;
    JLabel cardNumber1,pin;
    signupThree(String formNumber) {
        this.formnum=formNumber;
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
        cardNumber1 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardNumber1.setBounds(300,250,200,30);
        cardNumber1.setFont(new Font("Raleway",Font.BOLD,15));
        add(cardNumber1);

        //pin
        JLabel pinNumber = new JLabel("Pin Number:");
        pinNumber.setBounds(100,300,200,30);
        pinNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNumber);
        //number
        pin = new JLabel("XXXX");
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
        disclaimer = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        disclaimer.setFont(new Font("Raleway",Font.BOLD,10));
        disclaimer.setBounds(100,600,400,20);
        add(disclaimer);

        //submit button
        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,10));
        submit.setBounds(100,700,200,20);
        submit.setForeground(constants.textLabelColor);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        //cencel button
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,10));
        cancel.setBounds(300,700,200,20);
        cancel.setForeground(constants.textLabelColor);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }
    private boolean validateFields() {
        boolean check = false;
        if(!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()&&!r4.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select Account type");
            return false;
        }
        if(!disclaimer.isSelected()) {
            JOptionPane.showMessageDialog(null,"Please Accept terms and conditions");
            return false;
        }
        return true;
    }

    private Long generateUniqueCardNumber() {

        /*do{
            //generate random number
            cardNumber = Math.abs(random.nextLong()%90000000L) + 50405040L;     //initial numbers will be 50405040
            String query = "select count(*) from signupthree WHERE cardNumber = "+cardNumber;
            try(connectionDB c=new connectionDB()){
                ResultSet re = c.s.executeQuery(query);
                if(re.next()){
                    int count = re.getInt(1);
                    if(count==0){
                        isUnique = true;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (!isUnique);
        */

        //above implementation will repeatedly make connections below will try to connect only once

        long cardNumber = 0;
        Random random=new Random();
        try(connectionDB c=new connectionDB()){
            String query = "select count(*) from signupthree WHERE cardNumber = "+cardNumber;
            boolean isUnique = false;
            do{
                cardNumber = Math.abs(random.nextLong()%90000000L) + 504050400000000L;     //initial numbers will be 50405040
                ResultSet re = c.s.executeQuery(query);
                if(re.next()) {
                    int count = re.getInt(1);
                    if (count == 0) {
                        isUnique = true;
                    }
                }
            }while (!isUnique);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cardNumber;
    }

    @Override
    public void actionPerformed(ActionEvent a) {

        if(a.getSource()==cancel){
            new signupThree(formnum);
            dispose();
        } else if (a.getSource()==submit) {
            String accountType=null;
            if(r1.isSelected()){
                accountType="Savings Account";
            } else if (r2.isSelected()) {
                accountType="Current Account";
            }else if (r3.isSelected()) {
                accountType="Recurring Deposit";
            }else if (r4.isSelected()) {
                accountType="Fixed Deposit";
            }

            Random random=new Random();
            String cardNumber =""+ generateUniqueCardNumber();
            cardNumber1.setText(cardNumber);
            String pinNumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
            pin.setText(pinNumber);

            String facility="";
            if(c1.isSelected()){
                facility = facility+"ATM card";
            }
            if(c2.isSelected()){
                facility = facility+","+"Internet Banking";
            }
            if(c3.isSelected()){
                facility = facility+","+"Cheque Book";
            }
            if(c4.isSelected()){
                facility = facility+","+"Mobile, Banking";
            }
            if(c5.isSelected()){
                facility = facility+","+"Email Alerts";
            }
            if(c6.isSelected()){
                facility = facility+","+"E-Statements";
            }

            if(validateFields()){
                try (connectionDB c = new connectionDB()) {
                    String query = "insert into signupthree values('"+formnum+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    int rowsAffected = c.s.executeUpdate(query);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null,"Account created successfully\n Card Number : " + cardNumber+"\n PIN : "+pinNumber);
                    } else {
                        JOptionPane.showMessageDialog(null,"Failed to create account.Please try again");
                        new signupThree(formnum);
                        dispose();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
