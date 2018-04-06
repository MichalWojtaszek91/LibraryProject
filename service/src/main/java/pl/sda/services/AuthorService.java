package pl.sda.services;

import Models.Author;
import pl.sda.repository.AuthorRepository;

import java.io.IOException;
import java.util.List;

public class AuthorService {
private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    public void createAuthor(Author author){
        try{
            authorRepository.create(author);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Author> displayAutorList(){
       return authorRepository.listGetter();
    }
}
