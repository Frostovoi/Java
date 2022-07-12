package Patterns.ObserverPattern;

public class Robot implements Listener{

    @Override
    public void onPutMoney(Account account, int money) {
        if (money > 100000) {
            System.out.println("Аккаунт номер " + account.getNumber() + " отправлен на проверку.");
        }
    }
}
