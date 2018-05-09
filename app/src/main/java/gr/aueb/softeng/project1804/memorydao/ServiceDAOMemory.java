package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Service;


/**
 * Created by Stratos on 2/5/2018.
 */

public class ServiceDAOMemory {
    public static ArrayList<Service> services = new ArrayList<Service>();

    /**
     * Save a Service into the list
     * @param service The Service we want to add
     */
    public void add(Service service){
        services.add(service);
    }


    public static ArrayList<Service> getServicesByCategory(String title){
        ArrayList<Service> toReturn = new ArrayList<>();
        for (int i = 0; i < services.size(); i++){
            if(services.get(i).getCategory().getTitle().equals(title)){
                toReturn.add(services.get(i));
            }
        }
        return toReturn;
    }

    public static Service findServiceByTitle(String title){
        for(Service service : services){
            if(service.getDescription().equals(title)) return service;
        }
        return null;
    }
}
