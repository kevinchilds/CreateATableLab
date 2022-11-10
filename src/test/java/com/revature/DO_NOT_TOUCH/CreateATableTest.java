package com.revature.DO_NOT_TOUCH;

import com.revature.DO_NOT_TOUCH.Util.ConnectionUtil;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class CreateATableTest{
    private CreateATable createATable = new CreateATable();

    /**
     * The after annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void cleanup(){

        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "DROP TABLE songs;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("dropping table");
        }
    }

    /**
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exists, and exception will be thrown and the test will fail.
     */
    @Test
    public void problem1Test(){

        try {
            createATable.problem1();

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it Be', 'Beatles')";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }


    }


    /**
     * To test that the table exists, we are attempting to insert rows into the table trying to break the rules defined in our constraints.
     */
    @Test
    public void problem2TableCreatedTest(){

        try {
            createATable.problem2();

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; // testing the songs table exists with correct columns

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void problem2UniqueConstraintOnTitleTest(){
        problem2TableCreatedTest();
        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; //testing duplicate value
            String sql2 = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; //testing duplicate value

            PreparedStatement ps = connection.prepareStatement(sql + sql2);

            ps.executeUpdate();
            System.out.println("UNIQUE constraint not added to 'title' column");
            fail();

        } catch (SQLException e) {
        }
    }

    @Test
    public void problem2NotNullConstraintOnTitleTest(){
        problem2TableCreatedTest();
        try {


            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT into songs (Title, Artist) VALUES (NULL, 'Beatles');";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();
            System.out.println("NOT NULL constraint not added to 'title' column");
            fail();

        } catch (SQLException e) {
        }
    }

    @Test
    public void problem2NotNullConstraintOnArtistTest(){
        problem2TableCreatedTest();
        try {


            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT into songs (Title, Artist) VALUES ('Imagine', NULL);";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();
            System.out.println("NOT NULL constraint was not added to 'artist' column");
            fail();

        } catch (SQLException e) {
        }
    }
}