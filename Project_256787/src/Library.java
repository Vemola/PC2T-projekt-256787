import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static List<Book> books;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private List<String> lines;

    public Library(String dbUrl, String dbUser, String dbPassword) {
        this.books = new ArrayList<>();
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        loadFromDatabase1();
    }

    private void loadFromDatabase1() {
        
    }

    public Library() {

    }

    public void addBook() {
        try (Connection connection = SQLiteDatabase.connect()) {
            String sql = "INSERT INTO books (title, author, type, is_borrowed) VALUES (?, ?, ?, 0)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Book.getTitle());
            pstmt.setString(2, Book.getAuthor());
            pstmt.setString(3, Book.getType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding book");
            e.printStackTrace();
        }
    }

    public void deleteBook(String title) {
        try (Connection connection = SQLiteDatabase.connect()) {
            String sql = "DELETE FROM books WHERE title = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting book");
            e.printStackTrace();
        }
    }

    public Book findBook(String title) {
        try (Connection connection = SQLiteDatabase.connect()) {
            String sql = "SELECT * FROM books WHERE title = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("type"), rs.getBoolean("is_borrowed"));
            }
        } catch (SQLException e) {
            System.out.println("Error finding book");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooksByAuthor(String author) {
        try (Connection connection = SQLiteDatabase.connect()) {
            String sql = "SELECT * FROM books WHERE author = ? ORDER BY id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, author);
            ResultSet rs = pstmt.executeQuery();

            List<Book> books = new ArrayList<>();

            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("type"), rs.getBoolean("is_borrowed")));
            }

            return books;
        } catch (SQLException e) {
            System.out.println("Error getting books by author");
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBorrowedBooks() {
        try (Connection connection = SQLiteDatabase.connect()) {
            String sql = "SELECT * FROM books WHERE is_borrowed = 1";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Book> books = new ArrayList<>();

            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("type"), rs.getBoolean("is_borrowed")));
            }

            return books;
        } catch (SQLException e) {
            System.out.println("Error getting borrowed books");
            e.printStackTrace();
        }
        return null;
    }

    public void saveBookToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Title: " + Book.getTitle() + "\n");
            fileWriter.write("Author: " + Book.getAuthor() + "\n");
            fileWriter.write("Type: " + Book.getType() + "\n");
            fileWriter.write("Borrowed: " + Book.isBorrowed() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving book to file");
            e.printStackTrace();
        }
    }

    public Book loadBookFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String title = scanner.nextLine().replace("Title: ", "");
            String author = scanner.nextLine().replace("Author: ", "");
            String type = scanner.nextLine().replace("Type: ", "");
            boolean borrowed = Boolean.parseBoolean(scanner.nextLine().replace("Borrowed: ", ""));

            return new Book(title, author, type, borrowed);
        } catch (FileNotFoundException e) {
            System.out.println("Error loading book from file");
            e.printStackTrace();
        }
        return null;
    }

    public static void saveBooksToDatabase() {
        try (Connection connection = SQLiteDatabase.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM books");

            for (Book book : books) {
                String sql = "INSERT INTO books (title, author, type, is_borrowed) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, book.getTitle());
                pstmt.setString(2, book.getAuthor());
                pstmt.setString(3, book.getType());
                pstmt.setBoolean(4, book.isBorrowed());
                pstmt.executeUpdate();
            }
        } catch (SQLException e){
            System.out.println("Error saving books to database");
            e.printStackTrace();
        }
    }

    public static void loadBooksFromDatabase() {
        try (Connection connection = SQLiteDatabase.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                books.add(new Book(resultSet.getString("title"), resultSet.getString("author"),
                        resultSet.getString("type"), resultSet.getBoolean("is_borrowed")));
            }
        } catch (SQLException e) {
            System.out.println("Error loading books from database");
            e.printStackTrace();
        }
    }


    public void searchBook(String s) {
    }

    public void displayBooksByAuthor(String s) {
    }

    public void displayBorrowedBooks() {
    }

    public void loadFromDatabase() {
    }
}
