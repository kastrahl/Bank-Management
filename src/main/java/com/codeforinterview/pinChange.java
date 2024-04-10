package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class pinChange extends JFrame implements ActionListener {
    String card, pin;
    JButton cancel,submit;
    ButtonGroup buttonGroup;
    JPasswordField oldpin,newpin,confirmpin;
    pinChange(String card, String pin){
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

        //enter old pin
        JLabel text1 = new JLabel("Enter current pin");
        text1.setBounds(200,250,200,20);
        text1.setForeground(constants.textLabelColor);
        text1.setFont(new Font("System",Font.BOLD,15));
        //to add text above image and not just add to frame
        image.add(text1);
        //old pin text field
        oldpin=new JPasswordField("");
        oldpin.setBounds(200,280,100,20);
        oldpin.setFont(new Font("System",Font.BOLD,15));
        image.add(oldpin);

        //enter new pin
        JLabel text2 = new JLabel("Enter new pin");
        text2.setBounds(200,320,700,20);
        text2.setForeground(constants.textLabelColor);
        text2.setFont(new Font("System",Font.BOLD,15));
        //to add text above image and not just add to frame
        image.add(text2);
        //new pin text field
        newpin=new JPasswordField("");
        newpin .setBounds(200,350,100,20);
        newpin.setFont(new Font("System",Font.BOLD,15));
        image.add(newpin);


        //confirm new pin
        JLabel text3 = new JLabel("Confirm New pin");
        text3.setBounds(200,390,700,20);
        text3.setForeground(constants.textLabelColor);
        text3.setFont(new Font("System",Font.BOLD,15));
        //to add text above image and not just add to frame
        image.add(text3);
        //confrim pin textfield
        confirmpin=new JPasswordField("");
        confirmpin.setBounds(200,420,100,20);
        confirmpin.setFont(new Font("System",Font.BOLD,15));
        image.add(confirmpin);

        //cancel
        cancel= new JButton("Cancel");
        cancel.setBounds(120,470,150,25);
        image.add(cancel);
        cancel.addActionListener(this);
        //buttonGroup.add(cancel);
        //submit
        submit= new JButton("Submit");
        submit.setBounds(300,470,150,25);
        image.add(submit);
        submit.addActionListener(this);
        //buttonGroup.add(submit);

        setUndecorated(true);   // doesn't displays frame box
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            new Login().setVisible(true);
            this.dispose();
        }
        String newpintext=newpin.getText(),oldpintext=oldpin.getText(),confirmpintext=confirmpin.getText();

        if(e.getSource()==submit){
            if(!newpintext.matches("\\d{4}")){
                JOptionPane.showMessageDialog(this,"Pin must be 4 digit number","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!newpintext.equals(confirmpintext)){
                JOptionPane.showMessageDialog(this,"Confirm and New Pin does not Match","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(newpintext.equals(oldpintext)){
                JOptionPane.showMessageDialog(this,"New Pin same as Old Pin","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            try(connectionDB conn = new connectionDB()){
                String query = "SELECT * FROM login WHERE cardnumber = "+card+" AND pin = "+pin+" ;";
                try(ResultSet rs=conn.s.executeQuery(query)){
                    if(rs.next()){
                        String oldpinfromDB=rs.getString("pin");
                        //String formnumber = rs.getString("formno");
                        if(!oldpinfromDB.equals(oldpintext)){
                            JOptionPane.showMessageDialog(this,"Please Enter Correct current pin","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        String pinupdate="UPDATE login SET pin = ? WHERE cardnumber = ?";
                        // prepared statements
                        try (PreparedStatement pstmt = conn.prepareStatement(pinupdate)) {
                            pstmt.setString(1,newpintext);
                            pstmt.setString(2,card);
                            int rowsaffected = pstmt.executeUpdate();
                            if(rowsaffected>0){
                                JOptionPane.showMessageDialog(this,"Pin update succesfully to:"+newpintext );
                            }else{
                                JOptionPane.showMessageDialog(this,"Error Encountered");
                            }
                        }
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }
            }catch (Exception a){
                a.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new pinChange("504050446240243","4729");
    }
}
