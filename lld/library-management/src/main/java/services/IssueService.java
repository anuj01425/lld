package services;

import exceptions.InvalidBook;
import exceptions.NotAvailabelException;
import exceptions.OverlimitException;
import exceptions.UserDoesntExist;
import lombok.Data;
import models.BookItem;
import repository.BookIssueRepository;
import repository.LibraryRepository;

import java.time.Instant;
import java.util.Objects;

@Data
public class IssueService {
    private UserService userService;
    private LibraryService libraryService;

    public IssueService(){
        this.libraryService=new LibraryService();
        this.userService=new UserService();
    }

    public void issueBook(String bookId,String userId) throws InvalidBook, NotAvailabelException, OverlimitException, UserDoesntExist {
        if(Objects.isNull(LibraryRepository.getBookIdsMap().get(bookId))){
            throw new InvalidBook("No such book exists with id " + bookId);
        }
        if(!userService.canUserBorrowBook(userId)){
            throw new OverlimitException("User " + userId + "has already booked with the limit");
        }

        BookItem bookItem = LibraryRepository.getAvailabelBookCopy(bookId);
        if(bookItem == null){
            throw new NotAvailabelException("No book with is availabel with  bookid " + bookId);
        }
        bookItem.setDueDate(Instant.now().toEpochMilli());
        userService.borrowBook(userId,bookItem);

    }

    public void returnBook(String userId,String barCode) throws InvalidBook, UserDoesntExist {
        if(!libraryService.isValidBarCodeId(barCode)) throw new InvalidBook("Invalid Book Copy Id");
        LibraryRepository.addToRack(barCode,libraryService.assignRack());
        userService.returnBook(userId,barCode);
    }
}
