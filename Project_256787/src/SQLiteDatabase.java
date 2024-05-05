import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDatabase {
    private static final String DATABASE_URL = "jdbc:sqlite:library.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
            return null;
        }
    }

    public static void initialize() {
        try (Connection connection = connect()) {
            if (connection != null) {
                createTables(connection);
            }
        } catch (SQLException e) {
            System.out.println("Error initializing the database");
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String bookTable = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "author TEXT NOT NULL," +
                "type TEXT NOT NULL," +
                "is_borrowed INTEGER NOT NULL)";
        String bookIndex = "CREATE INDEX IF NOT EXISTS books_title_index ON books (title)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(bookTable);
            ((Statement) statement).execute(bookIndex);
        }
    }
}
