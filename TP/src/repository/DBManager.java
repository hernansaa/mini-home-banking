package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    // Parámetros de conexión
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//home/hernan/eclipse-workspace/TP/data/minihomebanking;AUTO_SERVER=TRUE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    private static Connection connection;

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_BASE_URL, DB_USER, DB_PASSWORD);
                System.out.println("Conexión establecida con éxito.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

