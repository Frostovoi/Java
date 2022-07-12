package Patterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int balance;
    private String number;
    private List<Listener> listeners = new ArrayList<>();

    public Account(int balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public void subscribe(Listener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(int money) {
        for(Listener listener : listeners) {
            listener.onPutMoney(this, money);
        }
    }

    public void putMoney(int money) {
        balance += money;

        notifyListeners(money);
    }

    public void withdrawMoney(int money) {
        balance -= money;

    }
}
