package gr.aueb.softeng.project1804.view.login;

/**
 * Created by Stratos on 7/5/2018.
 */

public interface LogInView {

    /**
     * This method is responsible vor verifying the email and password provided by the users and ultimately allowing them, or not, to login.
     */
    void startLogInOption();

    /**
     * this method is responsible for starting the signup procedure
     */
    void startSignUpOption();

    /**
     * this method is responsible for allowing a user without account to browse through the technicians and their details
     */
    void startVisitorOption();

    /**
     * Email getter
     */
    String getEmail();

    /**
     * Password getter
     */
    String getPassword();
}
