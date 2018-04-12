package gr.aueb.softeng.project1804;

import java.util.Date;
import java.util.ArrayList;

public class Visit
{
    private Date date;
    private Appointment appointment;
    private ArrayList<Resource> resources;
    private Payment payment;
    private Technician technician;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Appointment getAppointment()
    {
        return appointment;
    }

    public ArrayList<Resource> getResources()
    {
        return resources;
    }


    public Payment getPayment()
    {
        return payment;
    }

    public Technician getTechnician()
    {
        return technician;
    }

}