/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineone;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    public Map inventory;
    private double money = 0;

    public VendingMachine() {

        VendingMachineItem pepsi = new VendingMachineItem(1, "Pepsi", 2.3, 3);
        VendingMachineItem vesi = new VendingMachineItem(2, "Novelle lähdevesi", 2.2, 3);
        VendingMachineItem es = new VendingMachineItem(3, "Euroshopper Energiajuoma", 2.5, 3);
        VendingMachineItem snickers = new VendingMachineItem(4, "Snickers patukka", 1.5, 5);
        VendingMachineItem broadway = new VendingMachineItem(5, "Broadway perunalastut", 3, 5);
        VendingMachineItem haribo = new VendingMachineItem(6, "Haribo nallekarkkipussi", 2, 5);
        VendingMachineItem leader = new VendingMachineItem(7, "Leader proteiinipatukka", 1.8, 5);
        VendingMachineItem jenkki = new VendingMachineItem(8, "Jenkki purukumi", 1, 10);

        Map<String, VendingMachineItem> inventory = new HashMap();
        inventory.put("1", pepsi);
        inventory.put("2", vesi);
        inventory.put("3", es);
        inventory.put("4", snickers);
        inventory.put("5", broadway);
        inventory.put("6", haribo);
        inventory.put("7", leader);
        inventory.put("8", jenkki);
        setInventory(inventory);
        
    }

    public double getPrice(String numero) {
        VendingMachineItem itemi = (VendingMachineItem) getInventory().get(numero);
        double price = itemi.getPrice();
        return price;
    }

    public double getStock(String numero) {
        VendingMachineItem itemi = (VendingMachineItem) getInventory().get(numero);
        double stock = itemi.getStock();
        return stock;
    }
    
    public String getName(String numero) {
        VendingMachineItem itemi = (VendingMachineItem) getInventory().get(numero);
        String nimi  = itemi.getName();
        return nimi;
    }

    public void removeStock(String numero) {
        VendingMachineItem itemi = (VendingMachineItem) getInventory().get(numero);
        itemi.removeStock();
    }

    public Map getInventory() {
        return inventory;
    }

    public void setInventory(Map inventory) {
        this.inventory = inventory;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    
     public void removeMoney(double purchase) {
        money = money - purchase;
    }
    
    public void insertMoney(double coin) {
        money = money + coin;
    }
}
