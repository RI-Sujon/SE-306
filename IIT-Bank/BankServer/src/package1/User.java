package package1;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String accountNumber;
    private String password;
    private double balance;

    public User()
    {
        balance = 0;
    }

    public User(String name, String accountNumber, String password) {
        balance = 0;
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
