package com.mycompany.pizzaapp;


/**
 * This is a simple pizza ordering app program.
 * This is the initial entry point of the program.
 * It helps initialize cart and connection and the run 
 * the program.
 */
public class main 
{
    public static void main(String[] args) //throws FileNotFoundException 
    {     
        System.out.println("I am in main");
        Cart cart = new Cart();
        _Connection conn = new _Connection(cart);
        
        __Welcome w = new __Welcome(conn);
        w.show();
    }
}

