package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Technician;

import android.app.Application;

/**
 * Created by Stratos on 2/5/2018.
 */

public class TechnicianDAOMemory extends CustomerDAOMemory {
    public static ArrayList<Technician> technicians = new ArrayList<Technician>();

    /**
     * Save a technician into the array
     * @param tech The technician we want to add
     */
    public void addTechnician(Technician tech){
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

    public static Technician findTechnicianByEmail(String email){
        for(Technician technician : technicians){
            if(technician.getEmail().equals(email)) return technician;
        }
        return null;
    }


}
