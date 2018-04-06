package pl.sda.repository;

import Models.Borrower;
import UtilTools.UtilTools;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowerRepository {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String borrowerPath = "*/Downloads/Katas/Library01Beta/persistence/src/borrowersList.json";

    public void create(Borrower borrower) throws IOException {
        borrower.setBorrowerId(UtilTools.idGenerator(borrowerPath));
        List<Borrower> listOfBorrower = listGetter();
        listOfBorrower.add(borrower);
        OBJECT_MAPPER.writeValue(new File(borrowerPath), listOfBorrower);
    }

    public Borrower read(Long id) throws IOException {
        Borrower readedBorrower = null;
        List<Borrower> listOfBorrower = listGetter();
        for (Borrower i:listOfBorrower) {
            if (i.getBorrowerId()==id) {
readedBorrower = i;            }
        }
        return readedBorrower;
    }

    public void edit(Borrower borrower) throws IOException {
        List<Borrower> listOfBooks = listGetter();
        for (Borrower i : listOfBooks) {
            if (i.getBorrowerId()== borrower.getBorrowerId()) {
                listOfBooks.remove(i);
                i = borrower;
                listOfBooks.add(i);
            }
        }
        OBJECT_MAPPER.writeValue(new File(borrowerPath), listOfBooks);
    }

    public void delete(Long id) throws IOException {
        List<Borrower> listOfBooks = listGetter();
        Optional<Borrower> book = listOfBooks.stream().filter(x -> x.getBorrowerId().equals(id))
                .findFirst();
        book.ifPresent(b -> b.setRemoved(true));
        OBJECT_MAPPER.writeValue(new File(borrowerPath), listOfBooks);
    }

    public List<Borrower> listGetter(){
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        List<Borrower> theList = null;
        try {
            theList = OBJECT_MAPPER.readValue(borrowerPath, new TypeReference<List<Borrower>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theList;
    }
}
