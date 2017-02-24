/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billofsale;

/**
 *
 * @author Meep3_000
 */
public class Main {
    public static void main(String[] args){
        SalesItem[] items = new SalesItem[1];
        items[0] = new SalesItem("Shirt", 12.49f);
        Bill bill = new Bill(items, 20.00f, 0.13f);
        System.out.println(bill.toString());
    }
}
