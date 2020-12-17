package ru.serg.xmlTask.dataBase;

import ru.serg.xmlTask.entity.MessageTask;

import java.sql.*;

public class DBWorker implements DataBaseWorker {

    private  static String url = "jdbc:postgresql://localhost:5432/messagesDB";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "1";

    private static Connection connection() throws SQLException {
        Connection conn = null;
        try {
            Class driver = Class.forName(JDBC_DRIVER);
             conn = DriverManager.getConnection(url,USER,PASS);
        }catch (ClassNotFoundException cl){
            cl.printStackTrace();
        }
        return conn;
    }

    @Override
    public boolean create(MessageTask messageTask) {
       try {
           Connection connection = connection();
           if (connection!=null) {
               String sql = "INSERT INTO messages (time_message,text) Values (?,?)";
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               Timestamp timestamp = new Timestamp(messageTask.getDate().getTime());
               preparedStatement.setTimestamp(1, timestamp);
               preparedStatement.setString(2, messageTask.getText());
               preparedStatement.execute();
               return true;
           }
       }catch (SQLException sqlExp){
           sqlExp.printStackTrace();
       }
       return false;
    }

    @Override
    public MessageTask findByTime(Timestamp timestamp) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(MessageTask messageTask) {
        return false;
    }

}
