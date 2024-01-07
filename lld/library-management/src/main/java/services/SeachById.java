package services;

import models.BookItem;
import repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SeachById implements SearchService <List<BookItem>,String>{

    @Override
    public List<BookItem> search(String value) {
       return LibraryRepository.getBookIdsMap().get(value);
    }
}
