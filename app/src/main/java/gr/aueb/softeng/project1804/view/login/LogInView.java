package gr.aueb.softeng.project1804.view.login;

/**
 * Created by Stratos on 7/5/2018.
 */

public interface LogInView {

    /**
     * This method is responsible vor verifying the email and password provided by the users and ultimately allowing them, or not, to login.
     */
    public void startLogInOption();

    /**
     * this mehtod is responsible for starting the signup procedure
     */
    public void startSignUpOption();

    /**
     * this mehtod is responsible for allowing a user without account to browse through the technicians and their details
     */
    public void startVisitorOption();

    /**
     * Email getter
     */
    public String getEmail();

    /**
     * Password getter
     */
    public String getPassword();
}
