package online_banking;

public class Account {
    private int id;
    private final String number;
    private int balance;

    public Account(String number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public Account(int id, String number, int balance) {
        this.number = number;
        this.balance = balance;
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean transfer(Account account, int transferMoney){
        if (transferMoney > balance) {
            return false;
        }
        account.balance += transferMoney;
        balance -= transferMoney;
        return true;
    }
}
