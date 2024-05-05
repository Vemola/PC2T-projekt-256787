import java.util.Scanner;

public static void main(String[] args) throws ClassNotFoundException {
    Library library = new Library();
    library.loadFromDatabase();
    SQLiteDatabase.initialize();
    // ...

    Scanner scanner = new Scanner(System.in);
    int option;
    while (true) {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add a book");
        System.out.println("2. Delete a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Display books by author");
        System.out.println("5. Display borrowed books");
        System.out.println("6. Save book to file");
        System.out.println("7. Load book from file");
        System.out.println("8. Exit");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                library.addBook();
                break;
            case 2:
                System.out.println("Enter the book title to delete:");
                library.deleteBook(scanner.nextLine());
                break;
            case 3:
                System.out.println("Enter the book title to search for:");
                library.searchBook(scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter the author to search for:");
                library.displayBooksByAuthor(scanner.nextLine());
                break;
            case 5:
                library.displayBorrowedBooks();
                break;
            case 6:
                System.out.println("Enter the book title to save:");
                library.saveBookToFile(scanner.nextLine());
                break;
            case 7:
                System.out.println("Enter the book title to load:");
                library.loadBookFromFile(scanner.nextLine());
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

}

