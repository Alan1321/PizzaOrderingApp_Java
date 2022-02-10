package com.mycompany.pizzaapp;


/**
 * interface used later to help with creating an iterator
 */
public interface MyIterator 
{
    Pizza next();
    boolean hasNext(); 
    void resetIndex();
}
