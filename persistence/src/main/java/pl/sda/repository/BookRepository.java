package pl.sda.repository;

import Models.Book;
import UtilTools.UtilTools;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookRepository {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String booksPath = "./persistence/src/main/resources/db/booksList.json";
    private static final String ID_PATH = "./persistence/src/main/resources/ids/book_ids";


    public void create(Book book) throws IOException {
        book.setBookID(UtilTools.idGenerator(ID_PATH));
        List<Book> listOfBooks = listGetter();
        listOfBooks.add(book);
        OBJECT_MAPPER.writeValue(new File(booksPath), listOfBooks);
    }

    public Book read(Long id) throws IOException {
        List<Book> listOfBooks = listGetter();
        Book returningBook = null;
        for (Book i : listOfBooks) {
            if (i.getBookID() == id) {
                returningBook = i;
            }
        }
        return returningBook;
    }

    public void edit(Book book) throws IOException {
        List<Book> listOfBooks = listGetter();
        for (Book i : listOfBooks) {
            if (i.getAuthorID() == book.getAuthorID()) {
                listOfBooks.remove(i);
                i = book;
                listOfBooks.add(i);
            }
        }
        OBJECT_MAPPER.writeValue(new File(booksPath), listOfBooks);
    }

    public void delete(Long id) throws IOException {
        List<Book> listOfBooks = listGetter();
        Optional<Book> book = listOfBooks.stream()
                .filter(x -> x.getBookID().equals(id))
                .findFirst();
        book.ifPresent(b -> b.setRemoved(true));
        OBJECT_MAPPER.writeValue(new File(booksPath), listOfBooks);
    }


    public List<Book> findAvailableBooks() throws IOException {
      List<Book>  theList = OBJECT_MAPPER.readValue(new File(booksPath),
              OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book.class));

        return theList.stream()
                .filter(x -> !x.isRemoved())
                .filter(x -> !x.isBorrow())
                .collect(Collectors.toList());
    }


    public List<Book> listGetter() throws NullPointerException {
        List<Book> theList = null;
        try {
            theList = OBJECT_MAPPER.readValue(new File(booksPath), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theList;
    }

}
