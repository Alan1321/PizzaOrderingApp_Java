package com.mycompany.pizzaapp;

import java.util.ArrayList;

/**
 * database interface used later for txt_db
 */
public interface database 
{
    public void write(String info);
    public ArrayList read();
}
