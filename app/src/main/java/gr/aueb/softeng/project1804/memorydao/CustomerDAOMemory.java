package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Customer;


/**
 * Created by Stratos on 2/5/2018.
 */

public class CustomerDAOMemory {
    protected static ArrayList<Customer> customers = new ArrayList<Customer>();

    /**
     * Save a customer into the list
     * @param customer The customer we want to add
     */
    public void add(Customer customer){
        customers.add(customer);
    }

    /**
     * Returns all the customers
     * @return the customers list
     */
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> result = new ArrayList<Customer>();
        result.addAll(customers);
        return result;
    }
}
