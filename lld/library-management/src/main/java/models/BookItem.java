package models;

import constant.BookCover;
import constant.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class BookItem extends Book {
    private int rackNumber;
    private String publicationDate;
    private BookCover bookCover;
    private String bookBarCode;
    private long dueDate;
    private BookStatus bookStatus;

    public BookItem(int rackNumber,String title, List<String> authors, String publication,String bookIsbnNumber,String barCode) {
        super(authors,publication,title,bookIsbnNumber);
        this.rackNumber=rackNumber;
        this.bookBarCode=barCode;
        this.bookStatus=BookStatus.AVAILABEL;
    }
    public BookItem(int rackNumber,String title, List<String> authors, String publication,BookCover bookCover,String bookIsbnNumber,String barCode) {
        super(authors,publication,title,bookIsbnNumber);
        this.rackNumber=rackNumber;
        this.bookBarCode=barCode;
        this.bookStatus=BookStatus.AVAILABEL;
        this.bookCover=bookCover;
    }

    public BookItem(){

    }
}
