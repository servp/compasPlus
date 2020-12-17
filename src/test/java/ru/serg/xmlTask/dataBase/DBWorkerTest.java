package ru.serg.xmlTask.dataBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.serg.xmlTask.entity.MessageTask;

import java.sql.*;
import java.util.Date;


public class DBWorkerTest {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "1";
    private static String url = "jdbc:postgresql://localhost:5432/messagesDB";
    private static Connection connect;
    private static MessageTask messageTask;

    @Before
    public void initConnection() throws SQLException {
        Connection conn = null;
        try {
            Class driver = Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url, USER, PASS);
        } catch (ClassNotFoundException cl) {
            cl.printStackTrace();
        }
        connect = conn;
    }

    @Before
    public void initMessage() {
        Date date = new Date();
        String textMessage = "test message #1";
        messageTask = new MessageTask(date, textMessage);
    }

    @Test
   public void create() throws SQLException {
        if (connect != null) {
            String sql = "INSERT INTO messages (time_message,text) Values (?,?)";
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            Timestamp timestamp = new Timestamp(messageTask.getDate().getTime());
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setString(2, messageTask.getText());
            preparedStatement.execute();

            String sqlQuery = "select * from messages where id=3";
            PreparedStatement preparedStatement1 = connect.prepareStatement(sqlQuery);
            preparedStatement1.executeQuery();
            ResultSet resultSet = preparedStatement1.getResultSet();
            String stringFromDb = null;
            while (resultSet.next()) {
                stringFromDb = resultSet.getString(3);
            }
            String assertTextMessage = "test message #1";
            Assert.assertEquals(assertTextMessage, stringFromDb);
        }
    }
}