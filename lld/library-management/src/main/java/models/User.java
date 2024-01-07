package models;

import constant.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends Person {
    private Account account;
    private int numberOfBookCheckout;

    public User(String emailId, String contactNumber, String name, int age, Address address,String userName,String passWord) {
        super(emailId, contactNumber, name, age, address);
        Account account1 = new Account(userName,passWord, AccountStatus.CREATED);
        this.account=account1;
        this.numberOfBookCheckout=0;
    }

    public User(String emailId, String contactNumber, String name,String userName,String passWord) {
        super(emailId, contactNumber, name);
        Account account1 = new Account(userName, passWord, AccountStatus.CREATED);
        this.account = account1;
        this.numberOfBookCheckout=0;
    }
    public User(String emailId,String name,String userName,String passWord) {
        super(emailId, name);
        Account account1 = new Account(userName, passWord, AccountStatus.CREATED);
        this.account = account1;
        this.numberOfBookCheckout=0;
    }
}
