package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Service;


/**
 * Created by Stratos on 2/5/2018.
 */

public class ServiceDAOMemory {
    protected static ArrayList<Service> services = new ArrayList<Service>();

    /**
     * Save a Service into the list
     * @param service The Service we want to add
     */
    public void add(Service service){
        services.add(service);
    }

    /**
     * Returns all the services
     * @return the services list
     */
    public ArrayList<Service> getOfferedService() {
        ArrayList<Service> result = new ArrayList<Service>();
        result.addAll(services);
        return result;
    }
}
