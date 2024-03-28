package com.codeforinterview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class signUp extends JFrame implements ActionListener{

    long formnumber;
    JTextField namein,fnamein,emailin,addressin,cityin,statein,pincodein;
    JDateChooser dobin;
    JRadioButton genderinM,genderinF;
    JRadioButtonMenuItem single,married,other;
    JMenu maritalStatusMenu;
    JButton next;

    signUp(){
        setLayout(null);
        //setting up the window, size and bg colour
        setTitle("Welcome New User to Registration");
        setSize(800,800);
        //setVisible(true);        //check stackoverflow ;- https://stackoverflow.com/questions/47609833/jcomponents-only-appear-after-resizing
        setLocation(350,50);
        getContentPane().setBackground(Color.BLUE);

        //setting up labels

        Random ran=new Random();
        formnumber = Math.abs(ran.nextLong()%9000L + 1000L);           // SELF EDIT - check if applicationnumber already exists in mysql
        JLabel formnum = new JLabel("Application Form Number : " + formnumber);
        formnum.setFont(new Font("Raleway",Font.BOLD,20));
        formnum.setForeground(Color.white);                                 //set colour
        formnum.setBounds(150,20,400,40);               //only works when setlayout is null
        add(formnum);

        //label for page number 1
        JLabel persondetails = new JLabel("Page 1 : Personal Details" );
        persondetails.setFont(new Font("Raleway",Font.BOLD,10));
        persondetails.setForeground(Color.white);                                 //set colour
        persondetails.setBounds(230,60,400,10);               //only works when setlayout is null
        add(persondetails);

        //name label
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setForeground(Color.white);
        name.setBounds(100,100,150,20);
        add(name);
        //name textfield
        namein =new JTextField();
        namein.setFont(new Font("Raleway", Font.BOLD,15));
        namein.setBounds(300,100,200,20);
        namein.setForeground(Color.BLACK);
        namein.setBackground(Color.white);
        add(namein);

        //Father's name
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setForeground(Color.white);
        fname.setBounds(100,140,150,20);
        add(fname);
        //fname textfield
        fnamein =new JTextField();
        fnamein.setFont(new Font("Raleway", Font.BOLD,15));
        fnamein.setBounds(300,140,200,20);
        fnamein.setForeground(Color.BLACK);
        fnamein.setBackground(Color.white);
        add(fnamein);

        //DOB
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setForeground(Color.white);
        dob.setBounds(100,180,150,20);
        add(dob);
        // using Jdatecalender calendar
        dobin=new JDateChooser();
        dobin.setBounds(300,180,200,20);
        dobin.setFont(new Font("Raleway",Font.ITALIC,15));
        dobin.setForeground(new Color(105,105,105));
        add(dobin);

        //Gender
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setForeground(Color.white);
        gender.setBounds(100,220,150,20);
        add(gender);
        //genderinput textfield radiobutton
        ButtonGroup group = new ButtonGroup();          //JToggleButton does not belong to any group, while JRadioButton is usually grouped using a ButtonGroup object to ensure mutual exclusivity.
        genderinM=new JRadioButton("Male");
        genderinF=new JRadioButton("Female");
        group.add(genderinF);                           //first add buttons to group after creating them
        group.add(genderinM);
        genderinM.setBounds(300,220,80,20);
        genderinF.setBounds(420,220,80,20);
        add(genderinM);
        add(genderinF);

        //email
        JLabel email= new JLabel("Email :");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setForeground(Color.white);
        email.setBounds(100,260,150,20);
        add(email);
        //emailID
        emailin =new JTextField();
        emailin.setFont(new Font("Raleway", Font.BOLD,15));
        emailin.setBounds(300,260,200,20);
        emailin.setForeground(Color.BLACK);
        emailin.setBackground(Color.white);
        add(emailin);

        //Marital Status
        JLabel marital= new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setForeground(Color.white);
        marital.setBounds(100,300,150,20);
        add(marital);
        //marital status input field
        JMenuBar maritalin = new JMenuBar();                        //no need to define globally
        maritalStatusMenu = new JMenu("Marital Status");         //global cause will access later
        single = new JRadioButtonMenuItem("Single");            //these will be having action listener
        married = new JRadioButtonMenuItem("Married");
        other = new JRadioButtonMenuItem("Other");
        maritalStatusMenu.add(single);
        maritalStatusMenu.add(married);
        maritalStatusMenu.add(other);
        maritalin.add(maritalStatusMenu);
        ButtonGroup group2 = new ButtonGroup();                     //group for mutually exclusive
        group2.add(single);
        group2.add(married);
        group2.add(other);
        maritalin.setBounds(300,300,200,20);
        add(maritalin);
        // Add an ActionListener to update the menu label
        ActionListener listener = e -> {                            //lambda function: here we update which field was selected
            JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem) e.getSource();
            maritalStatusMenu.setText("Marital Status: " + menuItem.getText());
        };
        single.addActionListener(listener);
        married.addActionListener(listener);
        other.addActionListener(listener);

        //Address
        JLabel address= new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setForeground(Color.white);
        address.setBounds(100,340,150,20);
        add(address);
        //address input textfield
        addressin =new JTextField();
        addressin.setFont(new Font("Raleway", Font.BOLD,15));
        addressin.setBounds(300,340,200,20);
        addressin.setForeground(Color.BLACK);
        addressin.setBackground(Color.white);
        add(addressin);

        //City
        JLabel city= new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setForeground(Color.white);
        city.setBounds(100,380,150,20);
        add(city);
        //city input
        cityin =new JTextField();
        cityin.setFont(new Font("Raleway", Font.BOLD,15));
        cityin.setBounds(300,380,200,20);
        cityin.setForeground(Color.BLACK);
        cityin.setBackground(Color.white);
        add(cityin);

        //state
        JLabel state= new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setForeground(Color.white);
        state.setBounds(100,420,150,20);
        add(state);
        //state input
        statein =new JTextField();
        statein.setFont(new Font("Raleway", Font.BOLD,15));
        statein.setBounds(300,420,200,20);
        statein.setForeground(Color.BLACK);
        statein.setBackground(Color.white);
        add(statein);

        //pincode
        JLabel pincode= new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setForeground(Color.white);
        pincode.setBounds(100,460,150,20);
        add(pincode);
        //pincode in
        pincodein =new JTextField();
        pincodein.setFont(new Font("Raleway", Font.BOLD,15));
        pincodein.setBounds(300,460,200,20);
        pincodein.setForeground(Color.BLACK);
        pincodein.setBackground(Color.white);
        add(pincodein);

        //Nextpage button
        next=new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(300,550,200,30);
        next.addActionListener(this);
        add(next);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent a) {
        String formnum = "" + formnumber;                                                       //concat will convert long to string
        String name=namein.getText(),fathername=fnamein.getText(),email=emailin.getText(),address=addressin.getText(),city=cityin.getText(),state=statein.getText(),pin=pincodein.getText();
                                                                                                //getText -> Jtextfield me se value nikalna | setText se value set to JTextfield
        //String dob = ((JTextField)dobin.getDateEditor().getUiComponent()).getText();          //->in the tutorial

        String dob = dobin.getDateFormatString();                                               //self edit

        //getting input from radio button
        String gender = null;
        if(genderinM.isSelected()){
            gender="Male";
        }else if(genderinF.isSelected()){
            gender="Female";
        }
        //getting input from menu items
        String marital=null;
        if(single.isSelected()){
            marital="Single";
        } else if (married.isSelected()) {
            marital="Married";
        } else if (other.isSelected()) {
            marital="Other";
        }
        if(a.getSource()==next){

        }
        try{
            if(namein.getText().isEmpty()){                                                             //instead of name.equals("")
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else
            if(fnamein.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Father's name is Required");
            }else
            if (dobin.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }else
            if(!genderinM.isSelected()&&!genderinF.isSelected()){
                JOptionPane.showMessageDialog(null,"Please Select Gender");
            }else
            if(emailin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Email ID is Required");
            }else
            if(!single.isSelected()&&!married.isSelected()&&!other.isSelected()){
                JOptionPane.showMessageDialog(null,"Please Select marital Status");
            }else
            if(addressin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else
            if(cityin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else
            if(statein.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else
            if(pincodein.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Pincode is Required");
            }else {
                connectionDB c=new connectionDB();
                String query = "INSERT INTO signup VALUES('"+formnum+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);                           //this will run the above query in MySQL

            }
// "abcd'"+variable+"'abcd"   this is how we put variable in between string
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        new signUp();
    }


}
