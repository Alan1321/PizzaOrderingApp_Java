package com.mycompany.pizzaapp;
import java.util.ArrayList;

/**
 * This class helps store all the different pizza object
 * in a Array List. It acts like a real word cart system.
 */
public class Cart 
{
    private ArrayList<Pizza> cart = new ArrayList<Pizza>();
    private double totalPrice;
    
    /**
     * This method inserts pizza into the cart
     * @param p, the pizza object 
     */
    public void insetPizza(Pizza p)
    {
        cart.add(p);
    }
    /**
     * remove pizza from cart
     * @param strNum, the number associated with the pizza in cart
     * @return returns true if the number is valid and the pizza has been 
     * removed
     */
    public boolean removePizza(String strNum)
    {
        try {
            double d = Double.parseDouble(strNum);
            int index = (int)d;
            if(index <= this.getSize()-1)
                cart.remove(index);
            else 
                return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    /**
     * @return returns the pizza that was most recently inserted
     */
    public String getCurrentPizza()
    {
        int currPizza = cart.size()-1;
        String info = "";
        String PizzaName = cart.get(currPizza).getName();
        String toppings = cart.get(currPizza).getToppings();
        String sauce = cart.get(currPizza).getSauce();
        String price = String.valueOf(cart.get(currPizza).getPrice());

        info  = info + "Name: " + PizzaName + "\n" +
                       "Toppings Used: " + toppings + "\n" +
                       "Sauce Used: " + sauce + "\n" +
                       "Size: " + cart.get(currPizza).getSize() + "\n" +
                       "Price of this Pizza: " + price + "\n\n";
        return info;
    }
    /**
     * get all pizza information from cart
     * @return returns all the pizza that is present in
     * the cart as a string
     */
    public String getPizzaInfo()
    {
        String info = "";
        int count = 0;
        for(Pizza p: cart)
        {
            String PizzaName = p.getName();
            String toppings = p.getToppings();
            String sauce = p.getSauce();
            String price = String.valueOf(p.getPrice());
            
            info  = info + "Pizza_Number: " + String.valueOf(count) + "\n" +
                            "Name: " + PizzaName + "\n" +
                           "Toppings Used: " + toppings + "\n" +
                           "Sauce Used: " + sauce + "\n" +
                           "Size: " + p.getSize() + "\n" +
                           "Price of this Pizza: $" + price + "\n\n";
                           
            
            count++;
            
        }
        info = info + "\n\nTotal Price: $" + String.valueOf(this.getTotalPrice());
        return info;
    }
    /**
     * @return combines all the pizza names from the cart and returns it as a
     * one big string
     */
    public String getAllPizzaName()
    {
        String s = "";
        for(Pizza p:cart)
        {
            s = s + p.getName() + " ,";
        }
        return s;
    }
    /**
     * @return combines all the pizza prices from the cart 
     * and returns the total price as a double
     */
    public double getTotalPrice()
    {
        double pr = 0;
        for(Pizza p:cart)
        {
            pr += p.getPrice();
        }
        return pr;
    }
    /**
     * @return returns the total number of pizzas in the cart
     */
    public int getSize()
    {
        return cart.size();
    }
    /**
     * helps clear the entire cart at once
     */
    public void emptyCart()
    {
        cart.clear();
    }
}