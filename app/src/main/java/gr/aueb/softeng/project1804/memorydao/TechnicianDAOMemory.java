package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Technician;

/**
 * Created by Stratos on 2/5/2018.
 */

public class TechnicianDAOMemory {
    protected static ArrayList<Technician> technicians = new ArrayList<Technician>();

    /**
     * Save a technician into the array
     * @param tech The technician we want to add
     */
    public void add(Technician tech){
        technicians.add(tech);
    }

    /**
     * Returns all the Technicians
     * @return the technicians list
     */
    public ArrayList<Technician> getTechnicians() {
        ArrayList<Technician> result = new ArrayList<Technician>();
        result.addAll(technicians);
        return result;
    }
}
