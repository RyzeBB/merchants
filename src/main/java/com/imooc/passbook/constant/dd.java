package com.imooc.passbook.constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dd {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection)DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/passbook?user=me&password=1&useUnicode=true&characterEncoding=UTF8");
                            Statement s =  conn.createStatement();
            System.out.println(conn.isClosed());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

