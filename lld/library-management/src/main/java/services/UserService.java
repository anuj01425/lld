package services;

import constant.AccountStatus;
import constant.BookStatus;
import constant.Constant;
import exceptions.UserAlreadyExists;
import exceptions.UserDoesntExist;
import lombok.Data;
import models.Account;
import models.BookItem;
import models.User;
import repository.BookIssueRepository;
import repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class UserService {

    public void addUser(String userId, String password,String name,String emailId) throws UserAlreadyExists {
        User user = new User(emailId,name,userId,password);
        UserRepository.addUser(user);
    }

    public User getUserDetails(String userId) throws UserDoesntExist {
        User user = UserRepository.getUserIdsMap().get(userId);
        if(Objects.isNull(user)){
            throw new UserDoesntExist("User " + userId + "doesn't exist");
        }
        return user;
    }

    public boolean canUserBorrowBook(String userId){
        User user = UserRepository.getUserIdsMap().get(userId);
        if (Constant.MAX_BOOKS_ISSUED_TO_A_USER > user.getNumberOfBookCheckout()) {
            return true;
        }
        return false;
    }

    public void borrowBook(String userId, BookItem bookItem) throws UserDoesntExist {
        User user = UserRepository.getUserIdsMap().get(userId);
        int current = user.getNumberOfBookCheckout();
        user.setNumberOfBookCheckout(current +  1);
        bookItem.setBookStatus(BookStatus.BOOROWED);
        UserRepository.updateUserDetails(user);
        BookIssueRepository.issueBook(userId,bookItem);
        System.out.println("User with userId " + userId + " has borrowed book with barcode " + bookItem.getBookBarCode() + " and book id " + bookItem.getBookIsbnNumber());
    }

    public void returnBook(String userId,String barCode) throws UserDoesntExist {
        User user = UserRepository.getUserIdsMap().get(userId);
        int current = user.getNumberOfBookCheckout();
        user.setNumberOfBookCheckout(current-1);
        long currentTimeInMilli = Instant.now().toEpochMilli();
        BookItem bookItem = BookIssueRepository.getBookItemDetailCorrespondingToUser(userId,barCode);
        if(currentTimeInMilli - bookItem.getDueDate() > 10*24*60*60*1000){
            System.out.println("User " + userId  + " is applicable for the fine for barcode " + barCode);
        }
        bookItem.setBookStatus(BookStatus.AVAILABEL);
        UserRepository.updateUserDetails(user);
        BookIssueRepository.updateBookList(userId,barCode);
    }

    public void printBorrowed(String userId)  {
        User user = UserRepository.getUserIdsMap().get(userId);
        System.out.println("For Userid " + userId);
        if(user.getNumberOfBookCheckout() != 0) {
           List<BookItem> list = BookIssueRepository.getIssueBookRepository().get(userId);
           if(Objects.isNull(list) || list.isEmpty()){
               System.out.println(" No borrowed book currently");
           }
           for(BookItem bookItem : list){
               System.out.println("Boorowed bookid " + bookItem.getBookIsbnNumber() + " and barcode " + bookItem.getBookBarCode());
           }
        }
    }

}
