package com.mycompany.pizzaapp;
import java.util.ArrayList;

/**
 * pizza class is the core class of our program
 * it represents a pizza like in the real word and 
 * includes most of the things that a real pizza
 * contributes of
 */
public class Pizza 
{
    private char size;
    private ArrayList<String> toppings = new ArrayList<String>();
    private double price = 0;
    private String sauce;
    private String pizzaName;
    private Price p = new Price();
    
    /**
     * Construct an empty pizza object
     */
    Pizza(){}
    
    /**
     * Construct a new Pizza object
     * @param size the size of pizza object
     * @param toppings , all the toppings in a pizza object
     * @param sauce , the sauce used to make Pizza
     * @param name, name of the Pizza object
     */
    Pizza(char size, ArrayList<String> toppings, String sauce, String name)
    {
        this.pizzaName = name;
        this.sauce = sauce;
        this.setSize(size);
        for(String t:toppings)
        {
            this.addToppings(t);
        }
    }
    /**
     * Create a new Pizza object
     * @param size the size of pizza object
     * @param toppings , all the toppings in a pizza object
     * @param sauce , the sauce used to make Pizza
     * @param name, name of the Pizza object
     * @param price, the price of pre made pizza object
     */  
    Pizza(char size, ArrayList<String> toppings, String sauce, String name, double price)
    {
        this.pizzaName = name;
        this.sauce = sauce;
        this.price = price;
        this.setSize(size);
        this.toppings = toppings;
    }
    /**
     * @return returns the size of the pizza, can be large, medium or small
     */
    public String getSize()
    {
        if(this.size == 's')
            return "Small";
        else if(this.size == 'm')
            return "Medium";
        else 
            return "Large";
    }
    /**
     * @return combines all of the pizza information like name, toppings, and 
     * price and returns it as a single string
     */
    public String pizzaInfo()
    {
        String s = "";
        s = s+this.pizzaName+"\n";
        s = s+this.sauce+" Sauce\n";
        s = s+this.toppings.get(0) + "\n";
        s = s+this.toppings.get(1) +"\n";
        s = s+"$"+this.price+"\n";
        return s;
    }
    /**
     * @return returns the name of the pizza
     */
    public String getName()
    {
        return this.pizzaName;
    }
    
    //@return returns all the toppings of a pizza object
    public String getToppings()
    {
        String allTopping = "";
        for(String i:toppings)
        {
            allTopping = allTopping + i + " ";
        }
        return allTopping;
    }
    
    //@return returns the price of the pizza
    public double getPrice()
    {
        return this.price;
    }
    
    //@return returns the sauce of the pizza object
    public String getSauce()
    {
        return this.sauce;
    }
    
    /**
     * @param topping, sets the topping in a pizza
     * also calculates the prices based on different toppings used
     */
    public void addToppings(String topping)
    {
        this.price += p.getPrice(topping); 
        toppings.add(topping);
    }
    
    /**
     * @param name, sets the name of pizza
     */
    public void setName(String name)
    {
        this.pizzaName = name;
    }
    
    /**
     * @param sauce sets the sauce of pizza
     */
    public void setSauce(String sauce)
    {
        this.sauce = sauce;
    }
    
    //@param d sets the price of pizza
    public void setPrice(double d)
    {
        this.price = d;
    }
    
    /**
     * @param s, sets size of pizza
     * also calculates prices based on different sizes
     */
    public void setSize(char s)
    {
        this.price += p.getPrice(Character.toString(s));
        this.size = s;
    }
}
