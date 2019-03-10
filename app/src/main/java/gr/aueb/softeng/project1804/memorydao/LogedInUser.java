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

    /**
     * This method is responsible for returning the single instance of the class.
     * This is the only way to get an instance and as a result to access its methods.
     *
     * @return The instance of the singleton class.
     */
    public static LogedInUser getInstance()
    {
        if (logedInUser == null)
            logedInUser = new LogedInUser();

        return logedInUser;
    }

    /**
     * This static method resets the state of the singleton.
     */
    public static void reset()
    {
        user = null;
        logedInUser = null;
    }

    /**
     * This is the getter of the current logged in user.
     */
    public User getUser()
    {
        return user;
    }

    /**
     * This is the setter of the current logged in user.
     *
     * @param user The new logged in user.
     */
    public void setUser(User user)
    {
        this.user = user;
    }
}
