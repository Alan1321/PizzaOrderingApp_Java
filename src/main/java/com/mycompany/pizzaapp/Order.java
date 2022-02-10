package com.mycompany.pizzaapp;

import java.util.Date;

/**
 * Order helps combine customer data and cart object and packs them 
 * together.
 */
public class Order 
{
    private Cart cart;
    private CustomerData d;
    private double price;
    private String orderNumber;
    private Date date1;
    
    /**
     * Construct order object
     */
    Order(){}
    
    /**helps initialize the objects passed
     * @param c, cart object which is a part of order
     * @param d, customer data object which is another part of order
     */
    public void setOrder(Cart c, CustomerData d)
    {
        this.cart = c;
        this.d = d;
        this.orderNumber = this.d.getOrderNum();
        date1 = new Date();
    }
    /**
     * @return returns the exact date when order was placed
     */
    public Date getDate()
    {
        return this.date1;
    }
    /**
     * @return returns the data of customer
     */
    public CustomerData getCustomerData()
    {
        return this.d;
    }
    /**
     * @return returns the order number
     */
    public String getOrderNum()
    {
        return this.orderNumber;
    }
    /**
     * @return returns the cart that belongs to this order
     */
    public Cart getCart()
    {
        return this.cart;
    }
}
