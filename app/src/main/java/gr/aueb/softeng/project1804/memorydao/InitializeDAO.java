package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Resource;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;

/**
 * Created by Stratos on 16/5/2018.
 */

public class InitializeDAO {

    public static boolean isInisialized = false;

    public InitializeDAO() {

    }

    public  void initialize(){
        if(isInisialized){
            return;
        }

        TechnicianDAOMemory.technicians.add(new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com"));
        TechnicianDAOMemory.technicians.add(new Technician("Dimitris", "Staratzis", "xxxxx", "xxxxx"));
        List<String> availableDays = new ArrayList<>();
        availableDays.add("Monday");
        availableDays.add("Friday");
        List<String> availableHours = new ArrayList<>();
        availableHours.add("10:00 AM - 11:00 AM");
        availableHours.add("13:00 PM - 14:00 PM");
        TechnicianDAOMemory.technicians.get(0).setAvailableDays(availableDays);
        TechnicianDAOMemory.technicians.get(0).setAvailableHours(availableHours);
        TechnicianDAOMemory.technicians.get(1).setAvailableDays(availableDays);
        TechnicianDAOMemory.technicians.get(1).setAvailableHours(availableHours);

        CategoryDAOMemory.categories.add(new Category("Plumber", "A plumber is a tradesperson who specializes in installing and maintaining systems used for potable (drinking) water, sewage and drainage in plumbing systems."));
        CategoryDAOMemory.categories.add(new Category("Electrician", "An electrician is a tradesman specializing in electrical wiring of buildings, stationary machines, and related equipment."));
        ServiceDAOMemory.services.add(new Service("Faucet Repair", CategoryDAOMemory.categories.get(0)));
        ServiceDAOMemory.services.add(new Service("Change Solar Panel", CategoryDAOMemory.categories.get(0)));
        ServiceDAOMemory.services.add(new Service("Change Lamp", CategoryDAOMemory.categories.get(1)));
        ServiceDAOMemory.services.add(new Service("Change The Socket", CategoryDAOMemory.categories.get(1)));
        ResourceDAOMemory.resources.add(new Resource("screw", 0.10, 200));
        ResourceDAOMemory.resources.add(new Resource("bulb", 1, 27));
        ResourceDAOMemory.resources.add(new Resource("pipe", 3, 59));

        isInisialized = true;
    }
}
