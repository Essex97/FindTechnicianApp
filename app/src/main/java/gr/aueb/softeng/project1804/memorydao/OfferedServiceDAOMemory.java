package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.OfferedService;

/**
 * Created by Stratos on 2/5/2018.
 */

public class OfferedServiceDAOMemory {

    protected static ArrayList<OfferedService> OfferedServices = new ArrayList<OfferedService>();

    /**
     * Save a OfferedService into the list
     * @param ofsv The OfferedService we want to add
     */
    public void add(OfferedService ofsv){
        OfferedServices.add(ofsv);
    }

    /**
     * Returns all the OfferedServices
     * @return the OfferedServices list
     */
    public ArrayList<OfferedService> getOfferedService() {
        ArrayList<OfferedService> result = new ArrayList<OfferedService>();
        result.addAll(OfferedServices);
        return result;
    }
}
