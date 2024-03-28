package com.codeforinterview;
import java.sql.*;
public class connectionDB {         //use this class to create object

    //1 - register driver
    //2 - create connection
    Connection c;
    //3 - create statement
    Statement s;
    //4 - execute query
    //5 - close connection

    //constructor
    public connectionDB(){
        try {                       //mysql is external entity thus error chances -> use exception handling
            //1- register
            //Class.forName(com.mysql.cj.jdbc.Driver);          -> after adding jar no need to register driver it'll pick from jar itself

            //2- connection create
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306");     //jdbc is driver manager-> mysql db-> url? localhost port 3306
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","1234678");     //bydefauly mysql on localhost , directly write database name
            //3- create statement
            s =c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}
