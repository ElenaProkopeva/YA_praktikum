package org.example.sprint5;

public class TaskPolimorfizm {
    public static void main(String[] args) {
        Pear pear = new Pear();
        pear.processFruit();

        Account account = new Account(100.65);
        account.add(10);
        account.add(10.10);
        System.out.println(account.getBalance());
    }
}

class Fruit {

    public void processFruit() {
        removeStone();
        System.out.println("Фрукт готов к использованию");
    }

    public void removeStone() {
        System.out.println("Нужно удалить косточки ножом");
    }
}

class Pear extends Fruit {
    @Override
    public void removeStone() {
        System.out.println("Нужно удалить косточки ложкой");
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void add(double money) {
        balance = balance + money;
    }
    public void add(int money) {
        balance = balance + money;
    }

    public double getBalance() {
        return balance;
    }
}

