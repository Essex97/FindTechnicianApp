package gr.aueb.softeng.project1804.memorydao;

import gr.aueb.softeng.project1804.domain.User;

/**
 * Created by marios on 5/16/18.
 */

public class LogedInUser
{
    private static LogedInUser logedInUser = null;
    private static User user;

    private LogedInUser()
    {

    }

    public static LogedInUser getInstance()
    {
        if (user == null)
            logedInUser = new LogedInUser();

        return logedInUser;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
