package web;


import pl.sda.repository.AuthorRepository;
import pl.sda.repository.BookRepository;
import pl.sda.services.BorrowService;

import java.io.IOException;
import java.time.LocalDate;


public class BorrowController {
    private final BorrowService borrowService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BorrowController() {
        this.authorRepository = new AuthorRepository();
        this.bookRepository = new BookRepository();
        this.borrowService = new BorrowService();
    }

    public Boolean createBorrow(Long bookId, LocalDate dateOfBorrow, Long borrowerId) throws IOException {
        boolean borrowStatus;
        borrowStatus = borrowService.createBorrow(borrowerId, bookId, dateOfBorrow);
        return borrowStatus;
    }
}
