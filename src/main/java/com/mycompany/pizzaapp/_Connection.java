package com.mycompany.pizzaapp;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Connections Helps connect the input data with all of the
 * relevant classes. It helps do things like create new pizza 
 * objects and put those in cart, make a new order and put it
 * in order queue.
 */
public class _Connection 
{
    Scanner input = new Scanner(System.in);
    private Cart cart;
    private CustomerData customerD;
    private Order o;
    private OrderQueue oq;
    private Pizza p;
    private premade_pizzas pre;
    private database d = new txt_db();
    
    /**
     *Construct a _Connection object.
     * @param c a Cart object
     */
    _Connection(Cart c) //throws FileNotFoundException
    {
        this.cart = c;
        this.customerD = new CustomerData();
        this.o = new Order();
        this.oq = new OrderQueue();
        this.pre = new premade_pizzas();
    }
    /**
     * Create a new Pizza object for custom pizza and add it to cart
     * @param size the size of pizza object
     * @param toppings , all the toppings in a pizza object
     * @param sauce , the sauce used to make Pizza
     * @param name, name of the Pizza object
     * @return true if pizza can be inserted to cart else false
     */
    public boolean addCustomPizza(char size, ArrayList<String> toppings, String sauce, String name)
    {
        if(cart.getSize() < 10)
        {
            p = new Pizza(size, toppings, sauce, name);
            cart.insetPizza(p);
            return true;
        }
        return false;   
    }
    /**
     * Create a new Pizza object for premade pizza and add it to cart
     * @param size the size of pizza object
     * @param toppings , all the toppings in a pizza object
     * @param sauce , the sauce used to make Pizza
     * @param name, name of the Pizza object
     * @param price, the price of pre made pizza object
     * @return true if pizza can be inserted to cart else false
     */    
    public boolean addPremadePizza(char size, ArrayList<String> toppings, String sauce, String name, double price)
    {
        if(cart.getSize() < 10)
        {
            p = new Pizza(size, toppings, sauce, name, price);
            cart.insetPizza(p);
            return true;
        }
        return false;
    } 
    /**
     * Create a new CustomerData object, pack it with order and add to order queue
     * @param name, the name of the customer/order
     * @param phone, phone number of the customer
     * @param card, the credit card number of the customer
     */
    public void newCustomerData(String name, String phone, String card)
    {
        customerD = new CustomerData(name, phone, card);
        o.setOrder(cart, customerD);
        oq.insertOngoingOrder(o);
        
        String content = "-------------------------------------------------------------------\n";
        content += "CustomerData: ";
        content+= customerD.getAllinfo() +"\n\n";
        content += "Orders : \n"+cart.getPizzaInfo();
        content += "\n-------------------------------------------------------------------\n";
        //System.out.println(content);
        d.write(content);
    }
    /**
     * Checks if the name entered by the customer is valid
     * @param name, the name entered by the customer
     * @return true if its a valid name else false
     */
    public boolean checkName(String name)
    {
        return this.customerD.checkName(name);
    }
    /**
     * Checks if the phone number entered by the customer is valid
     * @param Number, the phone Number entered by the customer
     * @return true if its a valid number else false
     */
    public boolean checkPhone(String Number)
    {
        return this.customerD.checkPhone(Number);
    }
    /**
     * Checks if the credit card entered by the customer is valid
     * @param Number, the credit card number entered by the customer
     * @return true if its a valid card else false
     */
    public boolean checkCard(String Number)
    {
        return this.customerD.checkCard(Number);
    }
    /**
     * get all pizza information from cart
     * @return returns all the pizza that is present in
     * the cart as a string
     */
    public String getPizzaInfo()
    {
        return this.cart.getPizzaInfo();
    }
    /**
     * remove pizza from cart
     * @param strNum, the number associated with the pizza in cart
     * @return returns true if the number is valid and the pizza has been 
     * removed
     */
    public boolean removePizza(String strNum)
    {
        return this.cart.removePizza(strNum);
    }
    /**
     * @return all the total number of pizzas in the current cart
     */
    public int getSize()
    {
        return this.cart.getSize();
    }
    /**
     * checks if 10 seconds has passed since the order time
     */
    public void checkTime()
    {
        this.oq.checkTime();
    }
    /**
     * remove order from order queue
     * @param orderNum, the number associated with order
     * @return returns true if the order is found and removed else false
     */
    public boolean removeOngoingOrder(String orderNum)
    {
        return this.oq.removeOngoingOrder(orderNum);
    }
    /**
     * @return gets and returns an order number from order class
     */
    public String getOrderNum()
    {
        return this.oq.getOrderNum();
    }
    /**
     * @return gets all the current orders from order queue and returns that 
     * information as a string
     */
    public String showOngoinOrder()
    {
        return this.oq.showOngoinOrder();
    }
    /**
     * @return gets all the order that has been completed from the order queue
     * and returns that information as a string
     */
    public String showOrderReady()
    {
        return this.oq.showOrderReady();
    }
}
