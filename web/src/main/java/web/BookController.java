package web;

import Models.Book;
import Models.BooksType;
import pl.sda.services.BookService;

import java.io.IOException;
import java.util.List;

public class BookController {

    private final BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }


    public void createBook(String title, String dateOfRelease, int isbn,
    BooksType booksType, int pageNumber, String shortDescription, Long authorID) throws NullPointerException {
        Book newBook = new Book.BookBuilder(title, dateOfRelease, isbn, booksType, pageNumber, shortDescription, authorID).Build();
        bookService.createBook(newBook);
    }

    public List<Book> displayBookList() throws IOException {
        return bookService.displayBookList();
    }
}
