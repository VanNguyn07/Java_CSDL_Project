package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static Connection getConnection(){

        Connection connection = null;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver JDBC đã được nạp!");

            String url = "jdbc:sqlserver://localhost:49828;databaseName=Project_Finally;encrypt=true;trustServerCertificate=true;loginTimeout=30;socketTimeout=60";
            String user = "superadmin";
            String password = "admin123";

            connection = DriverManager.getConnection(url,user,password);

            System.out.println("Connected to SQL Server successfully!");

        }catch (ClassNotFoundException e){
            System.out.println("SQL Server JDBC Driver not found!"+ e.getMessage());
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("Connection failed!"+e.getMessage());
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return connection;
    }

}
