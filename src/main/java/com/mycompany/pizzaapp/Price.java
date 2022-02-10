package com.mycompany.pizzaapp;
import java.util.ArrayList;

/**
 * Price class helps store all the prices and 
 * return those prices which can be needed by the 
 * pizza class
 */
public class Price 
{
    private ArrayList<PriceFormat> prices = new ArrayList<PriceFormat>();
    
    /**
     * Construct price object
     * initialize all the prices of different toppings and sizes and
     * place them in an array list
     */
    Price()
    {
        prices.add(new PriceFormat("pepperoni", 1.0));
        prices.add(new PriceFormat("mushrooms", 1.0));
        prices.add(new PriceFormat("onions", 0.5));
        prices.add(new PriceFormat("sausage", 2.0));
        prices.add(new PriceFormat("bacon", 2.0));
        prices.add(new PriceFormat("extra cheese", 1.0));
        prices.add(new PriceFormat("black olives", 0.5));
        prices.add(new PriceFormat("green peppers", 1.0));
        prices.add(new PriceFormat("pineapple", 1.5));
        prices.add(new PriceFormat("spinach", 1.5));
        prices.add(new PriceFormat("chicken", 2.0));
        prices.add(new PriceFormat("s", 5.99));
        prices.add(new PriceFormat("m", 6.99));
        prices.add(new PriceFormat("l", 7.99));
    }
    
    /**
     * @param name, takes a topping or size as a parameter
     * @return returns the price of that topping or size
     */
    public double getPrice(String name)
    {
        double price = 0;
        for(int i = 0;i<prices.size();i++)
        {
            if(prices.get(i).getName().equals(name))
                return prices.get(i).getPrice();
        }
        return price;
    }
    
}

/**
 * PriceFormat class helps combine string and double which
 * can later be used to properly format price objects
 */
class PriceFormat
{
    private String name;
    private double price;
    
    /**
     * Construct PriceFormat object
     * @param name, this name can either be topping or size
     * @param price, this is the price of either topping or size
     */
    PriceFormat(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    /**
     * @param name, sets name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    //@param price, sets the price
    public void setPrice(Double price)
    {
        this.price = price;
    }
    //sets the price
    public void setPrice()
    {
        this.price = price;
    }
    //@return returns the price of associated topping or size
    public double getPrice()
    {
        return this.price;
    }
    //@return returns the name of the topping or size
    public String getName()
    {
        return this.name;
    }
}