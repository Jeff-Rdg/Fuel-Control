package org.jotasilva.connection.migrations;

import org.jotasilva.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSchema {
    public static void createDatabase() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        String sql = "CREATE DATABASE IF NOT EXISTS fuel_control";

        Statement statement = conn.createStatement();

        statement.execute(sql);

        System.out.println("Banco criado com sucesso!");

        statement.close();
        conn.close();
    }
}
