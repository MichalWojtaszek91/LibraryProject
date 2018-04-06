package pl.sda.repository;

import Models.Author;
import UtilTools.UtilTools;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AuthorRepository {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String authorPath = "./persistence/src/main/resources/db/authorsList.json";
    public static final String authorId = "./persistence/src/main/resources/ids/authors_ids";
    private final UtilTools utilTools;

    public AuthorRepository() {
        this.utilTools = new UtilTools();
    }


    public void create(Author author) throws IOException {
        author.setAuthorID(utilTools.idGenerator(authorId));
        List<Author> authors = listGetter();
        authors.add(author);
        OBJECT_MAPPER.writeValue(new File(authorPath), authors);
    }

    public Author read(Long id) throws IOException {
        List<Author> authors = listGetter();
        Author returnedAuthor = null;
        for (Author i : authors) {
            if (i.getAuthorID() == id) {
                returnedAuthor = i;
            }
        }
        return returnedAuthor;
    }

    public void edit(Author author) throws IOException {
        List<Author> authors = listGetter();
        for (Author i : authors) {
            if (i.getAuthorID() == author.getAuthorID()) {
                authors.remove(i);
                i = author;
                authors.add(i);
            }
        }
        OBJECT_MAPPER.writeValue(new File(authorPath), authors);

    }

    public void delete(Long id) throws IOException {

        List<Author> authors = listGetter();
        for (Author i : authors) {
            if (i.getAuthorID() == id) {
                authors.remove(i);
            }
        }
        OBJECT_MAPPER.writeValue(new File(authorPath), authors);
    }

    public List<Author> listGetter(){
        List<Author> theList = null;
        try {
            theList = OBJECT_MAPPER.readValue(new File(authorPath), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Author.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theList;
    }
}
