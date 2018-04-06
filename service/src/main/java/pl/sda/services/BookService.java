package pl.sda.services;

import Models.Book;
import Models.BooksType;
import pl.sda.repository.BookRepository;

import java.io.IOException;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }


    public void createBook(Book book) {
        try {
            bookRepository.create(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void checkIfBookIsAvailable(Book book) {
        if (book.isRemoved() == true) {
            System.out.println("Sorry Book is already removed. Id of existing borrow : " + book.getBorrowId());
        }
    }

    public void checkIfBookIsAbleToDelete(Book book) {
        if (book.isRemoved() == true) {
            System.out.println("Sorry, You cant delete this book because there is active borrow. Borrow id : " + book.getBorrowId());
        }
    }

    public List<Book> displayBookList() throws IOException {
        return bookRepository.findAvailableBooks();
    }

}
