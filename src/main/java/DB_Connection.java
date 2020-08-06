

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private Connection connection ;
    private static DB_Connection instance;
    static {
        instance = new DB_Connection();
    }
    DB_Connection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new IllegalStateException("Please load Database Driver" , e);
        }
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn"
                    , "postgres" , "sa");
        } catch (SQLException e) {
            throw new RuntimeException("usr , pas wrong");
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static DB_Connection getInstance(){
        return instance;
    }
}
