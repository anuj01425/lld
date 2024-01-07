package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public abstract class Book {
    private List<String> authors;
    private String publication;
    private String bookIsbnNumber;
    private String bookTitle;

    Book(List<String> authors, String publication, String bookTitle,String bookIsbnNumber){
        this.authors=authors;
        this.publication=publication;
        this.bookTitle=bookTitle;
        this.bookIsbnNumber=bookIsbnNumber;
    }
    public Book(){

    }
}
