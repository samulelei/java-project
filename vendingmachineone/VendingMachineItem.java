/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineone;

/**
 *
 * @author Samuel
 */
public class VendingMachineItem {

    private int itemcode;
    private String name;
    private double price;
    private int stock;

    public VendingMachineItem() {
    }

    public VendingMachineItem(int itemcode, String name, double price, int stock) {
        this.itemcode = itemcode;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getItemcode() {
        return itemcode;
    }

    public double getPrice() {
        return price;
    }

    public void removeStock() {
        stock = stock - 1;
    }
}
