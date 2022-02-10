package com.mycompany.pizzaapp;

/**
 * customerData helps with getting and managing all
 * of the payment information provided by the customer
 */
public class CustomerData 
{
    private String name;
    private String phoneNumber;
    private String cardNumber;
    private String orderNumber;
    
    /**
     * Construct a CustomerData object
     * @param name, the name of the customer
     * @param phoneNumber, the phone number provided by the customer
     * @param cardNumber, the card number provided by the customer
     */
    CustomerData(String name, String phoneNumber, String cardNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
    }
    /**
     * Construct a Customer Data object.
     */
    CustomerData(){}
     /**
     * @return gets and returns an order number from order class
     */   
    public String getOrderNum()
    {
        String s = "";
        s = s+(this.name).substring(0,1);
        s = s+(this.phoneNumber).substring(0,2);
        s = s+(this.cardNumber).substring(0,2);
        return s;
    }
    /**
     * Checks if the name entered by the customer is valid
     * @param name, the name entered by the customer
     * @return true if its a valid name else false
     */
    public boolean checkName(String name)
    {
        if(name.equals(""))
        {
            this.emptyAll();
            return false;
        }
        this.name = name;
        return true;
    }
    /**
     * Checks if the phone number entered by the customer is valid
     * @param Number, the phone Number entered by the customer
     * @return true if its a valid number else false
     */
    public boolean checkPhone(String Number)
    {
        if(Number.length() != 10 || !Number.matches("[0-9]+"))
        {
            this.emptyAll();
            return false;
        }
        this.phoneNumber = phoneNumber;
        return true;
    }
    /**
     * Checks if the credit card entered by the customer is valid
     * @param Number, the credit card number entered by the customer
     * @return true if its a valid card else false
     */
    public boolean checkCard(String Number)
    {
        if(Number.length() != 16 || !Number.matches("[0-9]+"))
        {
            this.emptyAll();
            return false;
        }
        this.cardNumber = cardNumber;
        return true;    
    }
    /**
     * @return returns the name of the customer
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * @return returns the phone Number of the customer
     */
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    /**
     * @return returns the credit card number of the customer
     */
    public String getCardNumber()
    {
        return this.cardNumber;
    }
    /**
     * @return combines name, phone and card number and returns it as
     * a string
     */
    public String getAllinfo()
    {
        String info = "";
        info = info + this.name + " " + this.phoneNumber + " " + this.cardNumber;
        return info;
    }
    /**
     * clears the name, phone number, and card number of the customer
     */
    public void emptyAll()
    {
        this.name = "";
        this.phoneNumber = "";
        this.cardNumber = "";
    }
}
