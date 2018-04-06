package Models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Borrow {
    private LocalDate borrowDate;
    private Book book;
    private Borrower borrower;
    private Long borrowId;
    private boolean isRemoved;

    public Borrow(LocalDate borrowDate, Book book, Borrower borrower) {
        this.borrowDate = borrowDate;
        this.book = book;
        this.borrower = borrower;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
