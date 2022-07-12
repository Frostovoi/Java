package Patterns.ObserverPattern;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Robot robot = new Robot();
        Account account = new Account(1000,"123");
        account.subscribe(client);
        account.subscribe(robot);
        account.putMoney(100000);
        account.withdrawMoney(50000);
        account.putMoney(10000);
        account.putMoney(100);
        account.putMoney(1000000);

        account.subscribe((account1, money) -> System.out.println(money));
    }
}
