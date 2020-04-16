package be.uantwerpen.lab3StefDistributed.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class BankAccount {

    private @Id @GeneratedValue Long id;
    int capital;
    private String accountName;
    private String userName;

    public BankAccount(){}

    public BankAccount(String accountName, String userName) {
        this.accountName = accountName;
        this.userName = userName;
    }
}
