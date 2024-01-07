package repository;

import exceptions.InvalidBook;
import lombok.Data;
import lombok.Getter;
import models.Book;
import models.BookItem;

import java.util.*;

@Data
public class BookIssueRepository {
    @Getter
    private static Map< String, List<BookItem > > issueBookRepository = new HashMap<>();

    public static void issueBook(String userId,BookItem bookItem){
        if(!Objects.isNull(bookItem)){
            List<BookItem> bookItems;
            bookItems = issueBookRepository.get(userId);
            if(bookItems == null){
                bookItems = new ArrayList<>();
            }
            bookItems.add(bookItem);
            issueBookRepository.put(userId,bookItems);
        }
        else new InvalidBook("Book with id " + bookItem.getBookIsbnNumber() + " deosn't exists");
    }

    public static void updateBookList(String userId,String barCode){
        if(issueBookRepository.containsKey(userId)){
            List<BookItem> bookItems = issueBookRepository.get(userId);
            List<BookItem> bookList = new ArrayList<>();
            for(BookItem bookItem : bookItems){
                if(bookItem.getBookBarCode().equals(barCode)) continue;;
                bookList.add(bookItem);
            }
            issueBookRepository.put(userId,bookList);
        }
    }

    public static BookItem getBookItemDetailCorrespondingToUser(String userId,String barCode){
        if(issueBookRepository.containsKey(userId)){
            List<BookItem> bookItems = issueBookRepository.get(userId);
            for(BookItem bookItem : bookItems){
                if(bookItem.getBookBarCode().equals(barCode)) return bookItem;
            }
        }
        return null;
    }
}
