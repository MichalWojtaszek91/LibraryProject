package pl.sda.repository;

import Models.Borrow;
import UtilTools.UtilTools;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowRepository {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String borrowPath = "*/Downloads/Katas/Library01Beta/persistence/src/borrowersList.json";

    public void create(Borrow borrow) throws IOException {
        borrow.setBorrowId(UtilTools.idGenerator(borrowPath));
        List<Borrow> listOfBorrow = listGetter();
        listOfBorrow.add(borrow);
        OBJECT_MAPPER.writeValue(new File(borrowPath), listOfBorrow);
    }

    public void read(Long id) throws IOException {
        List<Borrow> listOfBorrow = listGetter();
        for (Borrow i:listOfBorrow) {
            if (i.getBorrowId()==id) {
                System.out.println(i);
            }
        }
    }

    public void edit(Borrow borrower) throws IOException {
        List<Borrow> listOfBooks = listGetter();
        for (Borrow i : listOfBooks) {
            if (i.getBorrowId()== borrower.getBorrowId()) {
                listOfBooks.remove(i);
                i = borrower;
                listOfBooks.add(i);
            }
        }
        OBJECT_MAPPER.writeValue(new File(borrowPath), listOfBooks);
    }

    public void delete(Long id) throws IOException {
        List<Borrow> listOfBooks = listGetter();
        Optional<Borrow> book = listOfBooks.stream().filter(x -> x.getBorrowId().equals(id))
                .findFirst();
        book.ifPresent(b -> b.setRemoved(true));
        OBJECT_MAPPER.writeValue(new File(borrowPath), listOfBooks);
    }

    public List<Borrow> listGetter(){
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        List<Borrow> theList = null;
        try {
            theList = OBJECT_MAPPER.readValue(borrowPath, new TypeReference<List<Borrow>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theList;
    }
}
