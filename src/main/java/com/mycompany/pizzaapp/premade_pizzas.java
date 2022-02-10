package com.mycompany.pizzaapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class helps initialize all the premade pizzas
 */
public class premade_pizzas 
{
    private ArrayList<Pizza> a = new ArrayList<Pizza>();
    private ArrayList<String> s = new ArrayList<String>();
    private Pizza p;
    
    /**
     * Construct premade pizza object
     */
    premade_pizzas()
    {
        System.out.println("im in premade_pizza constructor");
        try {
            this.load_data();
        } catch (FileNotFoundException ex) {
            System.out.println("load data didn't work");
            Logger.getLogger(premade_pizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * this method helps get all the data from database
     * and then add all those to an array list
     */
    private void load_data() throws FileNotFoundException
    {
        System.out.println("im in load_data");
        database db = new txt_db();
        s = db.read();
        System.out.println("after db.read before loop");
        for(String str:s)
        {
            p = new Pizza();
            String[] parts = str.split(" ");
            p.setName(parts[0]);
            p.setSize(parts[1].charAt(0));
            p.addToppings(parts[2]);
            p.addToppings(parts[3]);
            p.setSauce(parts[4]);
            p.setPrice(Double.valueOf(parts[5]));
            a.add(p);
        }
    }
    
    /**
     * @return array list of pre made objects
     * initially done this way but later implemented iterator
     * and passed data anonymously
     */
    private ArrayList get_data()
    {    
        return this.a;
    }
    
    /**
     * This is an inner class which is the major implementation
     * of the iterator design pattern
     */
    private static class Iterate implements MyIterator
    {
        private final premade_pizzas data;
        private int index;
        private int size;
        
        /**
         * Construct Iterate object
         * @param data, pre made pizza data passed
         */
        public Iterate(premade_pizzas data)
        {
            this.data = data;
            this.index = 0;
            this.size = data.a.size();
        }
        
        /**
         * this method checks if there is next item present in the list
         * @return returns true if next object is present else false
         */
        public boolean hasNext()
        {
            if(index<size)
                return true;
           return false; 
        }
        
        /**
         * @return returns the next pizza object from the list
         */
        public Pizza next()
        {
            return data.a.get(index++);
        }
        
        /**
         * user can call this method if the index has reached the end
         * and the user wants to iterate again
         */
        public void resetIndex()
        {
            this.index = 0;
        }
    }
    
    /**
     * @return returns the entire My iterator class
     */
    public MyIterator iter()
    {
        return new Iterate(this);
    }
}
