package Models;

public class Book {
    private String title;
    private String dateOfRelease;
    private int isbn;
    private BooksType booksType;
    private int pageNumber;
    private String shortDescription;
    private Long authorID;
    private Long bookID;
    private boolean borrow;
    private Long borrowId;
    private boolean removed;

    public Book() {
    }

    private Book(BookBuilder bookBuilder) {
        this.title = bookBuilder.title;
        this.dateOfRelease = bookBuilder.dateOfRelease;
        this.isbn = bookBuilder.isbn;
        this.booksType = bookBuilder.booksType;
        this.pageNumber = bookBuilder.pageNumber;
        this.shortDescription = bookBuilder.shortDescription;
        this.authorID = bookBuilder.authorID;
        this.bookID = bookBuilder.bookID;
    }

    public Long getBookID() {
        return bookID;
    }



    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }



    public String getTitle() {
        return title;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public int getIsbn() {
        return isbn;
    }

    public BooksType getBooksType() {
        return booksType;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public static class BookBuilder{
        private String title;
        private String dateOfRelease;
        private int isbn;
        private BooksType booksType;
        private int pageNumber;
        private String shortDescription;
        private Long authorID;
        private Long bookID;


        public BookBuilder(String title, String dateOfRelease, int isbn, BooksType booksType, int pageNumber, String shortDescription, Long authorID) {
            this.title = title;
            this.dateOfRelease = dateOfRelease;
            this.isbn = isbn;
            this.booksType = booksType;
            this.pageNumber = pageNumber;
            this.shortDescription = shortDescription;
            this.authorID = authorID;
            this.bookID = bookID;
        }
        public Book Build(){
return new Book(this);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDateOfRelease(String dateOfRelease) {
            this.dateOfRelease = dateOfRelease;
        }

        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }

        public void setBooksType(BooksType booksType) {
            this.booksType = booksType;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public void setAuthorID(Long authorID) {
            this.authorID = authorID;
        }

        public void setBookID(Long bookID) {
            this.bookID = bookID;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", dateOfRelease='" + dateOfRelease + '\'' +
                ", isbn=" + isbn +
                ", booksType=" + booksType +
                ", pageNumber=" + pageNumber +
                ", shortDescription='" + shortDescription + '\'' +
                ", authorID=" + authorID +
                ", bookID=" + bookID +
                ", borrow=" + borrow +
                ", borrowId=" + borrowId +
                ", removed=" + removed +
                '}';
    }
}
