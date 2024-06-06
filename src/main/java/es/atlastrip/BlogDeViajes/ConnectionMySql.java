package es.atlastrip.BlogDeViajes;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectionMySql {

    private static final ConnectionMySql INSTANCE = new ConnectionMySql();

    private ConnectionMySql() {

    }

    public static ConnectionMySql getInstance() {
        return INSTANCE;
    }

    private final String URL = "jdbc:mysql://localhost:3306/blogdeviajes";
    private final String USER = "root";
    private final String PASS = "";


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}