/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u2a1.number4;

/**
 *
 * @author Meep3_000
 */
public class Bill {
    SalesItem[] items;
    float tendered;
    float taxRate;
    
    public Bill(SalesItem[] items, float tendered, float taxRate){
        this.items = items;
        this.tendered = tendered;
        this.taxRate = taxRate;
    }
    
    public float getSubTotal(){
        float subTot = 0.0f;
        for (SalesItem item : items) {
            subTot += item.getPrice();
        }
        return subTot;
    }
    
    public float getTaxes(){
        return this.getSubTotal() * this.taxRate;
    }
    
    public float getTotal(){
        return this.getSubTotal() + this.getTaxes();
    }
    
    public float getChange(){
        return tendered - this.getTotal();
    }
    
    @Override
    public String toString(){
        String output = "";
        for(SalesItem item : items){
            output += item.toString() + "\n";
        }
        output += "\nSubtotal......$" + String.format("%1.2f", this.getSubTotal());
        output += "\nHST(13%)......$" + String.format("%1.2f", this.getTaxes());
        output += "\nTotal.........$" + String.format("%1.2f", this.getTotal());
        output += "\nTendered......$" + String.format("%1.2f", this.tendered);
        output += "\nChange........$" + String.format("%1.2f", this.getChange());
        return output;
    }
}
