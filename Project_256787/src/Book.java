import java.time.LocalDate;

public class Book {
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static String title;
    private static String author;
    private static String type;
    private static boolean isBorrowed;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate publicationDate;
    public Book(String title2, Object author2, Object type2, Object isBorrowed2, Object borrowDate2, Object returnDate2,
                Object publicationDate2) {

    }

    public Book(int id, String title, String author, String type, boolean isBorrowed) {
    }

    public Book(String title, String author, String type, boolean borrowed) {
    }

    public static String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public static String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public static String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public static boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", type=" + type + ", isBorrowed=" + isBorrowed
                + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + ", publicationDate=" + publicationDate
                + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getType()=" + getType()
                + ", isBorrowed()=" + isBorrowed() + ", getBorrowDate()=" + getBorrowDate() + ", getReturnDate()="
                + getReturnDate() + ", getPublicationDate()=" + getPublicationDate() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    // Constructors, getters, setters, and toString() methods
}

