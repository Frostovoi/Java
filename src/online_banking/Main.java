package online_banking;


import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import javax.mail.*;


public class Main {

    static void showAccounts(Client client){
        ArrayList<Account> accounts = client.getAccounts();
        for (int i = 0; i < accounts.size(); i++){
            System.out.println((i + 1) + "." + accounts.get(i).getNumber() + " " + accounts.get(i).getBalance());
        }
        System.out.println();
    }

    static String generateCode(){
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < 4; i++){
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    static String generateNumber(){
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }

    static void sendEmail(){
        final Properties properties = new Properties();
 //       properties.load(Main.class.getClassLoader().getResourceAsStream("mail.properties"));
 //       Session mailSession = Session.getDefaultInstance(properties);
  //      MimeMessage message = new MimeMessage(mailSession);

    }

    static void createAccount(Client client, Database database) throws SQLException {
        String accountNumber = generateNumber();
        while(!database.isUniqueNumber(accountNumber)){
            accountNumber = generateNumber();
        }
        Account account = new Account(accountNumber,0);
        database.addAccount(client, account);
        client.addAccount(account);
    }

    static void transferMoney(Client client, Database database) throws SQLException {
        if (client.getAccounts().size() < 2){
            System.out.println("У вас недостаточно счетов для перевода");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите счёт, с которого хотите перевести средства: \n");
        showAccounts(client);
        int numberFrom = scanner.nextInt();
        numberFrom--;

        System.out.println("Выберите счёт, на который хотите перевести средства: \n");
        showAccounts(client);
        int numberTo = scanner.nextInt();
        numberTo--;

        System.out.println("Введите сумму, которую хотите перевести:");
        int transferMoney = scanner.nextInt();

        Account accountFrom = client.getAccounts().get(numberFrom);
        Account accountTo = client.getAccounts().get(numberTo);

        if (accountFrom.transfer(accountTo,transferMoney)){
            database.updateAccount(accountFrom);
            database.updateAccount(accountTo);
        }
        else{
            System.out.println("Недостаточно средств на данном счёте");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        Database database = null;
        try {
            database = new Database();
            Client client = database.findClient(login,password);
            do{
                System.out.println("1.Вывести все счета");
                System.out.println("2.Создать новый счёт");
                System.out.println("3.Перевести деньги на другой счёт");
                System.out.println("4.Выйти из системы");
                int action = scanner.nextInt();
                switch (action){
                    case 1: {
                        showAccounts(client);
                        break;
                    }
                    case 2: {
                        createAccount(client, database);
                        break;
                    }
                    case 3: {
                        transferMoney(client,database);
                        break;
                    }
                    case 4: {
                        return;
                    }
                }
            }
            while(true);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
