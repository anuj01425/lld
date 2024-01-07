import exceptions.*;
import services.IssueService;
import services.LibraryService;
import services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateBook, InvalidBook, OverlimitException, UserDoesntExist, NotAvailabelException {
        UserService userService = new UserService();
        IssueService issueService = new IssueService();
        LibraryService libraryService = new LibraryService();

        //Creating some users
        try {
            userService.addUser("user1", "user1", "user1", "uone@gmail.com");
            userService.addUser("user2", "user2", "user2", "utwo@gmail.com");
            userService.addUser("user3", "user3", "user3", "uthree@gmail.com");
            userService.addUser("user4", "user4", "user4", "ufour@gmail.com");
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            if (commandType.equals("exit"))
                break;

            switch (commandType) {
                case "add_book":
                    //add_book cs book2 siddharth publisher2 10,12,23
                    //add_book cs book2 siddharth publisher2 1,2,3
                    String title = commands[1];
                    String bookId = commands[2];
                    String[] authors = commands[3].split(",");
                    String publishers = commands[4];
                    String[] barCode = commands[5].split(",");
                    libraryService.addBook(title, authors, publishers, bookId, barCode);
                    break;
                case "remove_book_copy":
                    //remove_book_copy 10
                    libraryService.removeBook(commands[1]);
                    break;
                case "borrow_book":
                    //borrow_book book2 user1
                    ///borrow_book book2 user1
                    issueService.issueBook(commands[1], commands[2]);
                    break;
                case "return_book":
                    //return_book user1 10
                    issueService.returnBook(commands[1], commands[2]);
                    break;
                case "print_borrowed":
                    //print_borrowed user1
                    userService.printBorrowed(commands[1]);
                    break;
                default:
                    break;
            }
        }
    }
}
