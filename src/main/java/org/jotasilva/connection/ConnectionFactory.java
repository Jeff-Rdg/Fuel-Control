package org.jotasilva.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection(){
        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String user = prop.getProperty("banco.user");
            final String password = prop.getProperty("banco.password");

            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        // Crio o objeto properties
        Properties prop = new Properties();
        // estabeleço o caminho que possui os dados do banco
        String path = "/connection.properties";
        // obtem o fluxo de entrada de um recurso armazenado no classpath
        prop.load(ConnectionFactory.class.getResourceAsStream(path));
        return prop;
    }
}
