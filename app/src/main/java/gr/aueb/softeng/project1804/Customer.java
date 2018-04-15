package gr.aueb.softeng.project1804;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by marios on 4/15/18.
 */

public class Customer extends User
{
    private List<Appointment> appointments;
    private List<Evaluation> evaluations;

    public Customer(String firstName, String lastName, String phone, String email)
    {
        super(firstName, lastName, phone, email);
        appointments = new ArrayList<Appointment>();
        evaluations = new ArrayList<Evaluation>();
    }

    public List<Appointment> getApprovedAppointments()
    {
        List<Appointment> approved = new ArrayList<Appointment>();

        for (Appointment appointment : appointments)
            if (appointment.getApproved())
                approved.add(appointment);

        return approved;
    }

    public List<Evaluation> getEvaluations()
    {
        return evaluations;
    }

    public void createAppointment()
    {
        // waiting for the appointment constructor to be made lol
    }

    public void pay(Appointment appointment)
    {
        for (Appointment apoint : appointments)
            if (appoint.equals(appointment))
            {
                // WTF?
            }
    }
}
