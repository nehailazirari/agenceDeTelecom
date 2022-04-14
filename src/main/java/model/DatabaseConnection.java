package model;
import java.sql.*;
public class DatabaseConnection {

    static Connection connection =null;
    static String databaseName="gestiondatabase";
    static String url="jdbc:mysql://localhost:3306/"+databaseName;
    static String user="system";
    static String password="nehaila2001";

    public  Connection getConnectionD() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
