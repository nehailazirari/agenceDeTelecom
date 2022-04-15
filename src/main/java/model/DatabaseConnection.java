package model;

import java.sql.*;
public class DatabaseConnection {

    static Connection connection =null;
    static String databaseName="gestiondaatabase";
    static String url="jdbc:mysql://localhost:3306/"+databaseName;
    static String user="root";
    static String password="root";

    public  Connection getConnectionD() {
      

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public  static void gerer(String sql){
        DatabaseConnection connectionNew = new DatabaseConnection();
        Connection connect = connectionNew.getConnectionD();
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("data inserted successfully");

        } catch (SQLException e) {
            System.out.println("fail in inserting data");
        }

    }
}
