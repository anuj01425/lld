package models;

import lombok.Data;

@Data
public class Librarian extends Person {
    private Account account;
}
