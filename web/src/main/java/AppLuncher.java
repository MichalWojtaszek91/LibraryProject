import Models.Author;
import Models.Book;
import Models.BooksType;
import com.fasterxml.jackson.core.JsonParseException;
import pl.sda.repository.AuthorRepository;
import pl.sda.repository.BookRepository;
import pl.sda.services.BookService;
import web.AuthorController;
import web.BookController;
import web.BorrowController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class AppLuncher {
    public static final Scanner scan = new Scanner(System.in);

    private final BookController bookController = new BookController();
    private final AuthorController authorController = new AuthorController();
    private final BorrowController borrowController = new BorrowController();

    public static void main(String[] args) throws IOException {
        AppLuncher appLuncher = new AppLuncher();
        boolean flag1 = true;
        System.out.println("Welcome to \"Troll\" library ! How can we help you ?");
        do {
            System.out.println("1. Book borrow\n2. Return a book\n3. Add book\n4. Add author\n5. Display book list\n6. Display Authors list\n7. Exit");
            String menuOption = scan.nextLine();
            switch (menuOption) {
                case "1":
                    appLuncher.bookBorrow();
                    break;
                case "2":
                    returnAbook();
                    break;
                case "3":
                    appLuncher.addBook();
                    break;
                case "4":
                    appLuncher.addAuthor();
                    break;
                case "5":
                    appLuncher.displayBookList();
                    break;
                case "6":
                    appLuncher.displayAuthorsList();
                    break;
                case "7":
                    flag1 = false;
                    break;
                default:
                    System.out.println("Wrong commend. Please try again !");
            }
        }
        while (flag1);
    }

    public static void returnAbook() {
        System.out.println("Please enter borrow ID :");
        int borrowId = scan.nextInt();
        scan.nextLine();
    }

    public void displayBookList() throws IOException {
        List<Book> bookList = bookController.displayBookList();
        for (Book i : bookList) {
            System.out.println(i);
        }
    }

    public void displayAuthorsList() {
        List authorsList = new ArrayList(authorController.displayAuthorLists());
        for (Object i : authorsList) {
            System.out.println(i);
        }
    }

    public void bookBorrow() throws IOException {
        System.out.println("Please enter ID of book to borrow : ");
        Long bookID = scan.nextLong();
        scan.nextLine();
        System.out.println("Please enter Borrower Id : ");
        Long borrowerId = scan.nextLong();
        scan.nextLine();
        LocalDate dateOfBorrow = LocalDate.now();
        boolean flag = borrowController.createBorrow(bookID, dateOfBorrow, borrowerId);
        if (flag) {
            System.out.println("Book has been successful borrowed.");
        } else {
            System.out.println("Sorry book cannot be borrowed.");
        }
    }

    public void addBook() throws IOException, InputMismatchException, NullPointerException {
        String bookType = null;
        String title = null;
        String dateOfRelease = null;
        String shortDescription = null;
        Long authorId = null;
        int isbn = 0;
        int pageNumber = 0;
        try {
            System.out.println("Please enter book title :");
            title = scan.nextLine();
            System.out.println("Please enter date of release :");
            dateOfRelease = scan.nextLine();
            System.out.println("Please enter book type :");
            bookType = scan.nextLine().toUpperCase();
            System.out.println("Please enter number of pages :");
            pageNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter ISBN number :");
            isbn = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter a short description :");
            shortDescription = scan.nextLine();
            System.out.println("Please enter author ID :");
            int newId = scan.nextInt();
            authorId = (long) newId;
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Sorry, you put in wrong type. Try again !");
        } catch (NullPointerException y) {
            System.out.println("Ops ! Something goes wrong ! Null pointer as been detected.");
        }
        BooksType newBookType = BooksType.valueOf(bookType);
        bookController.createBook(title, dateOfRelease, isbn, newBookType, pageNumber, shortDescription, authorId);
    }

    public void addAuthor() throws IOException {
        System.out.println("Please enter author's name :");
        String authorName = scan.nextLine();
        System.out.println("Please enter author's lastname :");
        String authorLastName = scan.nextLine();
        System.out.println("Please enter author's birth place :");
        String birthPlace = scan.nextLine();
        authorController.createAuthor(authorName, authorLastName, birthPlace);
    }

    public boolean IsEqualStringandEnum(String str, BooksType booksType) {
        if (str.equals(booksType.toString()))
            return true;
        else
            return false;
    }
}
