package web;

import Models.Author;
import pl.sda.services.AuthorService;

import java.util.List;

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }


    public void createAuthor(String name, String lastName, String birthPlace){
        Author newAuthor = new Author.AuthorBuilder(name,lastName,birthPlace).build();
authorService.createAuthor(newAuthor);
    }
    public List<Author> displayAuthorLists(){
       return authorService.displayAutorList();
    }
}
