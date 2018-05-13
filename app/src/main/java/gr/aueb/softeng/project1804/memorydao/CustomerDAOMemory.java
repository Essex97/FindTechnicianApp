package gr.aueb.softeng.project1804.memorydao;

import android.app.Application;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Customer;


/**
 * Created by Stratos on 2/5/2018.
 */

public class CustomerDAOMemory extends Application
{
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static Customer logedInCustomer;

    public static Customer getLogedInCustomer() {
        return logedInCustomer;
    }

    public static void setLogedInCustomer(Customer logedInCustomer) {
        CustomerDAOMemory.logedInCustomer = logedInCustomer;
    }

    /**
     * Save a customer into the list
     * @param customer The customer we want to add
     */
    public void addCustomer(Customer customer){
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

    public static Customer findCustomeByEmail(String email){
        for(Customer customer : customers){
            if (customer.getEmail().equals(email)) return customer;
        }
        return null;
    }
}
