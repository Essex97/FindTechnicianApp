package gr.aueb.softeng.project1804;

import java.sql.Time;
import java.util.*;

public class Appointment
{
    private String appointmentCode;
    private Date date;
    private Time time;
    private boolean approved;

    public String getAppointmentCode()
    {
        return appointmentCode;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date newDate)
    {
        date = newDate;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time newTime)
    {
        time = newTime;
    }

    public boolean getApproved()
    {
        return approved;
    }

    public void setApproved(boolean flag)
    {
        approved = flag;
    }

}


