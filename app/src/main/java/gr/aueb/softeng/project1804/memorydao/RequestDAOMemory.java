package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Request;

/**
 * Created by Stratos on 2/5/2018.
 */

public class RequestDAOMemory {

    protected static ArrayList<Request> requests = new ArrayList<Request>();

    /**
     * Save a request into the list
     * @param req The request we want to add
     */
    public void add(Request req){
        requests.add(req);
    }

    /**
     * Returns all the Requests
     * @return the requests list
     */
    public ArrayList<Request> getRequests() {
        ArrayList<Request> result = new ArrayList<Request>();
        result.addAll(requests);
        return result;
    }

}
