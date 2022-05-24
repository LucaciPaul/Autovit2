package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    //
    public Connection Connection;
    String ConnectionURL="jdbc:sqlserver://localhost:1433;"+"databaseName=Autovit;integratedSecurity=true;";

    public DataBase (){
        DBConnection();
    }

    public void DBConnection (){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection= DriverManager.getConnection(ConnectionURL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
