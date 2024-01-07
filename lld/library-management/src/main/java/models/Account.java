package models;

import constant.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String userName;
    private String password;
    private AccountStatus accountStatus;
}
