package repository;

import constant.BookStatus;
import exceptions.DuplicateBook;
import exceptions.InvalidBook;
import lombok.Data;
import lombok.Getter;
import models.Book;
import models.BookItem;

import java.util.*;

@Data
public class LibraryRepository {

    @Getter
    private static Map<String,Integer> rackToBook = new HashMap<>();
    @Getter
    private static Map<String, List<BookItem>> bookIdsMap = new HashMap<>();
    @Getter
    private static Map<String, Boolean> bookBarCodeExist = new HashMap<>();

   public static void addToRack(String barCode,int rack){
       bookBarCodeExist.put(barCode,true);
       rackToBook.put(barCode,rack);
   }


   public static void addBook(BookItem bookItem)  {
       List<BookItem> bookItems = bookIdsMap.get(bookItem.getBookIsbnNumber());
       if(Objects.isNull(bookItems)) {
           bookItems = new ArrayList<>();
       }
       bookItems.add(bookItem);
       bookIdsMap.put(bookItem.getBookIsbnNumber(),bookItems);
   }

    public static void removeBook(String bookBarCode)  {
       System.out.println("Removed book barcode " + bookBarCode);
       rackToBook.remove(bookBarCode);

    }

    public static BookItem getAvailabelBookCopy(String bookId) throws InvalidBook {
        List<BookItem> bookItems = bookIdsMap.get(bookId);
        if (Objects.isNull(bookItems))
            throw new InvalidBook("Invalid Book ID");
        for(BookItem bookItem : bookItems){
            if(isBookCopyAvailabel(bookItem)){
                return bookItem;
            }
        }
        return null;
    }

    public static boolean isBookCopyAvailabel(BookItem bookItem){
       if(!Objects.isNull(rackToBook.get(bookItem.getBookBarCode())) && rackToBook.get(bookItem.getBookBarCode()) > 0
       && bookItem.getBookStatus().equals(BookStatus.AVAILABEL)){
           System.out.println("Book with id " + bookItem.getBookIsbnNumber()  + " is availabel in rack " + rackToBook.get(bookItem.getBookBarCode()));
           rackToBook.remove(bookItem.getBookBarCode());
            return true;
        }
        return false;
    }

}
