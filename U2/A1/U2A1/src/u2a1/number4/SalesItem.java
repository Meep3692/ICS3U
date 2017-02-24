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
public class SalesItem {
    private String name;
    private float price;
    
    public SalesItem(String name, float price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public float getPrice(){
        return price;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        String output = "";
        output += this.getName();
        int spaceCount = 19 - this.getName().length() - Float.toString(this.getPrice()).length();
        for(int i = 0; i < spaceCount; i++){
            output += ".";
        }
        output += "$" + Float.toString(this.getPrice());
        return output;
    }
}
