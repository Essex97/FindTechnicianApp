package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Visit;

/**
 * Created by Stratos on 2/5/2018.
 */

public class VisitDAOMemory {
    protected static ArrayList<Visit> visits = new ArrayList<Visit>();

    /**
     * Save a visit into the list
     * @param vis The request we want to add
     */
    public void add(Visit vis){
        visits.add(vis);
    }

    /**
     * Returns all the Visits
     * @return the visit list
     */
    public ArrayList<Visit> getVisits() {
        ArrayList<Visit> result = new ArrayList<Visit>();
        result.addAll(visits);
        return result;
    }
}
