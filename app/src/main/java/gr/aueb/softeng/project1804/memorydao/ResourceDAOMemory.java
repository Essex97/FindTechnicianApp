package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Resource;


/**
 * Created by Stratos on 2/5/2018.
 */

public class ResourceDAOMemory {

    protected static ArrayList<Resource> resources = new ArrayList<Resource>();

    /**
     * Save a resources into the list
     * @param resource The resource we want to add
     */
    public void add(Resource resource){
        resources.add(resource);
    }

    /**
     * Returns all the Resourced
     * @return the resources list
     */
    public ArrayList<Resource> getResources() {
        ArrayList<Resource> result = new ArrayList<Resource>();
        result.addAll(resources);
        return result;
    }
}
