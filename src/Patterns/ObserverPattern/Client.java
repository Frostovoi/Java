package Patterns.ObserverPattern;

public class Client implements Listener {


    @Override
    public void onPutMoney(Account account, int money) {
        System.out.println("Account number " + account.getNumber()+ "was changed on " + money + ".");
    }
}
