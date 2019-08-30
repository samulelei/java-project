/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineone;

import java.util.ArrayList;

public class VendingMachineUser {

    private double money;
    private double usedmoney;
    private ArrayList userinventory;

    public VendingMachineUser() {
        ArrayList<String> inventory = new ArrayList();
        this.userinventory = inventory;

    }

    public VendingMachineUser(double money) {
        this.money = money;
        ArrayList<String> inventory = new ArrayList();
        this.userinventory = inventory;
    }

    public void setUserinventory(ArrayList userinventory) {
        this.userinventory = userinventory;
    }

    public ArrayList getUserinventory() {
        return userinventory;
    }

    public void removeMoney(double purchase) {
        money = money - purchase;
    }

    public void insertMoney(double coin) {
        money = money + coin;
        usedmoney = usedmoney + coin;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public double getUsedmoney() {
        return usedmoney;
    }

    public void putItemi(String item) {
        ArrayList itemit = getUserinventory();
        itemit.add(item);
        setUserinventory(itemit);
    }

    public void printInventory() {
        ArrayList lista = getUserinventory();
        System.out.println(lista);
    }
}
