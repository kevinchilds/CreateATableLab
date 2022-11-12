package com.revature.DO_NOT_TOUCH;


import com.revature.DO_NOT_TOUCH.Util.ConnectionUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateATable {

    public void problem1(){
        try {
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = parseSQLFile("problem1.sql");

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }
    }

    public void problem2(){
        try {
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = parseSQLFile("problem2.sql");

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }
    }

    private String parseSQLFile(String fileName) {

        StringBuilder sql = new StringBuilder();
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream("./src/main/java/com/revature/" + fileName);

            //file to be scanned
            Scanner sc = new Scanner(fis);

            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                sql.append(sc.nextLine());
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
        }

        return sql.toString();
    }

}
