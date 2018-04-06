package pl.sda.services;

import Models.Book;
import Models.Borrow;
import Models.Borrower;
import pl.sda.repository.BookRepository;
import pl.sda.repository.BorrowRepository;
import pl.sda.repository.BorrowerRepository;

import java.io.IOException;
import java.time.LocalDate;

public class BorrowService {
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
        this.bookRepository = new BookRepository();
        this.borrowerRepository = new BorrowerRepository();
    }

    public boolean createBorrow(Long borrowerId, Long bookId, LocalDate borrowDate) throws IOException {
        boolean borrowStatus = false;
        Borrower borrower = borrowerRepository.read(borrowerId);
        Book book = bookRepository.read(bookId);
Borrow borrow = new Borrow(borrowDate,book,borrower);
        if (!book.isRemoved()) {
            borrowRepository.create(borrow);
            borrowStatus = true;
        }
        return borrowStatus;
    }
}
