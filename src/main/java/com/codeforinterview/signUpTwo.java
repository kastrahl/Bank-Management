package com.codeforinterview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpTwo extends JFrame implements ActionListener {

    JRadioButton seniorYes,seniorNo,existYes,existNo;
    JButton next;
    JRadioButtonMenuItem religionHindu,religionMuslim,religionChristian,religionSikh,religionOther;
    JTextField panNumber,aadharNumber;
    String sreligion,formnum;
    JMenu religionMenu;
    JComboBox<String> category,education,occupation;
    Choice incchoice,relchoice;
    signUpTwo(String formnum){
        this.formnum=formnum;

        //grid layout null for custom layout
        setLayout(null);
        //set window frame
        setTitle("New Application Registration Form - Page 2");
        setSize(650,800);
        setLocation(350,50);
        getContentPane().setBackground(constants.backGroundColor);

        //label page number
        JLabel personaldetails=new JLabel("Page 2: Additional Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,15));
        personaldetails.setBounds(230,50,400,15);
        personaldetails.setForeground(Color.white);
        add(personaldetails);

        //religion
        JLabel rellabel=new JLabel("Religion :");
        rellabel.setFont(new Font("Raleway",Font.BOLD,15));
        rellabel.setForeground(constants.textLabelColor);
        rellabel.setBounds(100,100,150,20);
        add(rellabel);
        //religionmenubar       --implementing this menu bar will take a lot of memory! but need to learn
/*        JMenuBar religion = new JMenuBar();
        religionMenu = new JMenu("Religion");
        religionHindu = new JRadioButtonMenuItem("Hindu");
        religionChristian = new JRadioButtonMenuItem("Christian");
        religionMuslim = new JRadioButtonMenuItem("Muslim");
        religionSikh = new JRadioButtonMenuItem("Sikh");
        religionOther = new JRadioButtonMenuItem("Other");
        religionMenu.add(religionHindu);        //Adding menu item to menu
        religionMenu.add(religionChristian);
        religionMenu.add(religionMuslim);
        religionMenu.add(religionSikh);
        religionMenu.add(religionOther);
        religion.add(religionMenu);             //adding menu to menubar
        ButtonGroup relgroup=new ButtonGroup();
        relgroup.add(religionHindu);
        relgroup.add(religionMuslim);
        relgroup.add(religionOther);
        relgroup.add(religionSikh);
        relgroup.add(religionChristian);
        religion.setBounds(300,100,200,20);
        add(religion);
        //adding listener to display selected option
        ActionListener listener = e->{
          JRadioButtonMenuItem menuItem=(JRadioButtonMenuItem) e.getSource();
          sreligion=menuItem.getText();
          religionMenu.setText("Religion selected is : "+menuItem.getText());
        };
        religionHindu.addActionListener(listener);
        religionMuslim.addActionListener(listener);
        religionChristian.addActionListener(listener);
        religionSikh.addActionListener(listener);
        religionOther.addActionListener(listener);
*/
        relchoice = new Choice();
        relchoice.add("Hindu");
        relchoice.add("Muslim");
        relchoice.add("Christian");
        relchoice.add("Sikh");
        relchoice.add("Other");
        relchoice.setBounds(300, 100, 150, 20);
        add(relchoice);


        //category
        JLabel catlabel=new JLabel("Category :");
        catlabel.setFont(new Font("Raleway",Font.BOLD,15));
        catlabel.setForeground(constants.textLabelColor);
        catlabel.setBounds(100,140,150,20);
        add(catlabel);
        //making cobobox instead of menubar
        String[] categories ={"General","OBC","SC","ST","EWS"};
        category = new JComboBox<>(categories);
        category.setBackground(Color.white);
        category.setBounds(300,140,150,20);
        add(category);

        //income
        JLabel inclabel=new JLabel("Income :");
        inclabel.setFont(new Font("Raleway",Font.BOLD,15));
        inclabel.setForeground(constants.textLabelColor);
        inclabel.setBounds(100,180,150,20);
        add(inclabel);
        //income category
        incchoice = new Choice();
        incchoice.add("0 - 1 lakhs per annum");
        incchoice.add("1 - 3 lakhs per annum");
        incchoice.add("3 - 6 lakhs per annum");
        incchoice.add("6 - 20 lakhs per annum");
        incchoice.add("above 20 lakhs per annum");
        incchoice.setBounds(300, 180, 150, 20);
        add(incchoice);


        //educational qualification
        JLabel edulabel=new JLabel("Education :");
        edulabel.setFont(new Font("Raleway",Font.BOLD,15));
        edulabel.setForeground(constants.textLabelColor);
        edulabel.setBounds(100,220,150,20);
        add(edulabel);
        //education         - using choice menu
        String[] educations ={"Non-Graduate","Graduation","Post-Graduation","Doctrate","others"};
        education = new JComboBox<>(educations);
        education.setBackground(Color.white);
        education.setBounds(300,220,150,20);
        add(education);


        //Occupation
        JLabel occulabel=new JLabel("Occupation :");
        occulabel.setFont(new Font("Raleway",Font.BOLD,15));
        occulabel.setForeground(constants.textLabelColor);
        occulabel.setBounds(100,260,150,20);
        add(occulabel);
        //oocupationdrop down
        String[] occupations ={"Student","Salaried","Business","Govt Employee","Unemployeed","others"};
        occupation = new JComboBox<>(occupations);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,260,150,20);
        add(occupation);


        //PAN
        JLabel panlabel=new JLabel("Pan Number :");
        panlabel.setFont(new Font("Raleway",Font.BOLD,15));
        panlabel.setForeground(constants.textLabelColor);
        panlabel.setBounds(100,300,150,20);
        add(panlabel);
        //PAN details input field
        panNumber = new JTextField();
        panNumber.setFont(new Font("Raleway",Font.BOLD,15));
        panNumber.setBounds(300,300,150,20);
        add(panNumber);

        //Aadhar
        JLabel aadharlabel=new JLabel("Aadhar Number :");
        aadharlabel.setFont(new Font("Raleway",Font.BOLD,15));
        aadharlabel.setForeground(constants.textLabelColor);
        aadharlabel.setBounds(100,340,150,20);
        add(aadharlabel);
        //aadhar input field
        aadharNumber = new JTextField();
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,15));
        aadharNumber.setBounds(300,340,150,20);
        add(aadharNumber);

        //Senior Citizen
        JLabel seniorlabel=new JLabel("Senior Citizen :");
        seniorlabel.setFont(new Font("Raleway",Font.BOLD,15));
        seniorlabel.setForeground(constants.textLabelColor);
        seniorlabel.setBounds(100,380,150,20);
        add(seniorlabel);
        //seior sitien radio buttons
        ButtonGroup senior=new ButtonGroup();
        seniorYes=new JRadioButton("Yes");
        seniorNo=new JRadioButton("No");            //add buttons to group after declaration as new jRadiobutton
        senior.add(seniorYes);
        senior.add(seniorNo);
        seniorYes.setBounds(300,380,60,20);
        seniorNo.setBounds(390,380,60,20);
        add(seniorYes);
        add(seniorNo);

        //Existing Account
        JLabel existlabel=new JLabel("Existing Account :");
        existlabel.setFont(new Font("Raleway",Font.BOLD,15));
        existlabel.setForeground(constants.textLabelColor);
        existlabel.setBounds(100,420,150,20);
        add(existlabel);
        //Existing account
        ButtonGroup exist=new ButtonGroup();
        existYes=new JRadioButton("Yes");
        existNo=new JRadioButton("No");            //add buttons to group after declaration as new jRadiobutton
        exist.add(existYes);
        exist.add(existNo);
        existYes.setBounds(300,420,60,20);
        existNo.setBounds(390,420,60,20);
        add(existYes);
        add(existNo);

        next=new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(300,550,200,30);
        next.addActionListener(this);
        add(next);


        //set it visible
        setVisible(true);
    }
    boolean validateFields() {
        boolean check=false;
        // Check if all fields are filled and contain valid data

        if(category.getSelectedItem() == null||occupation.getSelectedItem()==null||education.getSelectedItem()==null||panNumber.getText().isBlank()||aadharNumber.getText().isBlank()||incchoice.getSelectedItem()==null||relchoice.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null,"Please complete the form");
            return false;
        }
        // If all fields are filled correctly, return true
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent a) {

        //handled religion as global variable
        String scategory = category.getSelectedItem().toString();
        String soccupation = occupation.getSelectedItem().toString();
        String seducation = education.getSelectedItem().toString();
        String seniorcitizen = "c",existingaccount = "c",pan=panNumber.getText(),aadhar=aadharNumber.getText();
        String income = incchoice.getSelectedItem().toString();
        String religion = relchoice.getSelectedItem().toString();
        //How to iterate over Jmenuitems
/*        String religion = null;
        for(Component component :religionMenu.getMenuComponents()){
            if(component instanceof JMenuItem){
                JMenuItem menuItem = (JMenuItem) component;
                if(menuItem.isSelected()){
                    religion=menuItem.getText();
                }
            }
        }
*/

        if(seniorYes.isSelected())
            seniorcitizen="Yes";
        else if (seniorNo.isSelected()){
            seniorcitizen="No";
        }
        if(existYes.isSelected())
            existingaccount="Yes";
        else if (existNo.isSelected()) {
            existingaccount="No";
        }
        if(validateFields()){
           try(connectionDB c=new connectionDB()){
               String query="insert into signuptwo values('"+formnum+"', '"+religion+"', '"+scategory+"', '"+income+"', '"+seducation+"', '"+soccupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
               System.out.println(query);
               c.s.executeUpdate(query);
               new signupThree(formnum).setVisible(true);
               setVisible(false);
               //SignUp ka object taki vo khule
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }
    public static void main(String[] args){
        new signUpTwo("");
    }

}
