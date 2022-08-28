package com.mycompany.lojavirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancodeDados {

    private static String url = "jdbc:mysql://localhost:3306/livraria_Virtual";
    private static String username = "osincriveis";
    private static String password = "sup&r&qu1p&*";

    public Connection conectar() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    public void close(Connection conn) throws SQLException {
        conn.close();
    }

    public void close(Statement stmt) throws SQLException {
        stmt.close();
    }

    public void close(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }

    public void close(ResultSet result) throws SQLException {
        result.close();
    }

}
