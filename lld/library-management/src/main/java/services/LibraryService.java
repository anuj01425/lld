package services;

import exceptions.DuplicateBook;
import exceptions.InvalidBook;
import models.BookItem;
import repository.LibraryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LibraryService {

    private int[] rackNumber;

    public LibraryService() {
        this.rackNumber = new int[10];
        for(int i=1;i<=10;i++){
            this.rackNumber[i-1]=i;
        }
    }
    public int assignRack(){
        Random random = new Random();

        int val=  Math.abs(random.nextInt())%10;
        if(val == 0) val++;
        return val;
    }

    public void addBook(String title, String[] authors, String publishers,String bookIsbNumber,String[] barcode) throws DuplicateBook {

        List<String> authorList = Arrays.asList(authors);
        List<String> barCodeList = Arrays.asList(barcode);
        int rack= assignRack();
        for(String barCode : barCodeList){
            BookItem book = new BookItem(rack,title,authorList,publishers,bookIsbNumber,barCode);
            LibraryRepository.addBook(book);
            LibraryRepository.addToRack(barCode,rack);
            System.out.println("Added Book " + barCode  + " to racks: " + rack);
        }

    }


    public void removeBook(String barCode) throws InvalidBook {
        if(Objects.isNull(LibraryRepository.getRackToBook().get(barCode))) {
            throw new InvalidBook("Book with id " + barCode + " doesn't exists");
        }
        LibraryRepository.removeBook(barCode);
    }

    public boolean isValidBarCodeId(String barCode) {
        if (Objects.isNull(LibraryRepository.getBookBarCodeExist().get(barCode)) || !LibraryRepository.getBookBarCodeExist().get(barCode)) {
            return false;
        }
        return true;
    }
}
