package online_banking;

import java.util.ArrayList;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phone;
    private ArrayList<Account> accounts;


    public Client(String name, String surname, String login, String password, String phone, int id) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.id = id;

        accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getId() { return id; }
}
