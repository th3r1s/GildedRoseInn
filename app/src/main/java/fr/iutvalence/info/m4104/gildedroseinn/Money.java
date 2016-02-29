package fr.iutvalence.info.m4104.gildedroseinn;

/**
 * Created by Optip on 29/02/2016.
 */
public class Money {

    private int money;

    public Money(){
        this(0);
    }

    public Money(int initialMoney){
        this.money=initialMoney;
    }


    public int getMoney() {
        return money;
    }

    public void subsMoney(int money) {
        this.money -= money;
    }

    public void addMoney(int money) {
        this.money += money;
    }
}
