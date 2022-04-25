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

    public  void gereMAJ(String sql){
        DatabaseConnection connectionNew = new DatabaseConnection();
        Connection connect = connectionNew.getConnectionD();
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  ResultSet afficher(String sql) {
        DatabaseConnection connectionNew = new DatabaseConnection();
        Connection connect = connectionNew.getConnectionD();
        ResultSet res=null;
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
             res = ps.executeQuery(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

}
