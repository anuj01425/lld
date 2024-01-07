package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Person {
    private String emailId;
    private String contactNumber;
    private String name;
    private int age;
    private Address address;
    public Person(String emailId,String contactNumber,String name){
        this.emailId=emailId;
        this.contactNumber=contactNumber;
        this.name=name;
    }
    public Person(String emailId,String name){
        this.emailId=emailId;
        this.name=name;
    }

    public Person(String name){
        this.emailId=emailId;
        this.name=name;
    }

    public Person() {

    }
}
