package es.atlastrip.BlogDeViajes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
    String url = "jdbc:mysql://localhost:3306/usuarios";
    String user = "root";
    String pass = "";


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}