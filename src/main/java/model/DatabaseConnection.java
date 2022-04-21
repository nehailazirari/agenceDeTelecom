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
            System.out.println("les données ont été mis a jour");

        } catch (SQLException e) {
            System.out.println("échec de mise a jour");
        }

    }

    public  static ResultSet Afficher(String sql) {
        DatabaseConnection connectionNew = new DatabaseConnection();
        Connection connect = connectionNew.getConnectionD();
        ResultSet res=null;
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
             res = ps.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("echec");
        }

        return res;
    }

}
