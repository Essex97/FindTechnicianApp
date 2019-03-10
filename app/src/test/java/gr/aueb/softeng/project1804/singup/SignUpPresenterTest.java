package gr.aueb.softeng.project1804.singup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.signup.SignUpPresenter;
import gr.aueb.softeng.project1804.view.signup.SignUpViewStub;

/**
 * Created by marios on 5/12/18.
 */

public class SignUpPresenterTest
{
    private SignUpPresenter presenter;
    private SignUpViewStub stub;
    public static final String NAME = "name";
    public static final String PASS = "pass";
    public static final String PHONE = "phone";
    public static final String STREETNAME = "street_name";
    public static final String POSTALCODE = "postal_code";
    public static final String EMAIL = "email";
    public static final int STREETNUMBER = 123;

    @Before
    public void setUp() throws Exception
    {
        stub = new SignUpViewStub(STREETNUMBER, NAME, PASS, PHONE, STREETNAME, POSTALCODE, EMAIL);
        presenter = new SignUpPresenter(stub);
    }

    /**
     * This method tests the code that is responsible for
     * handling the presses of the sign up button.
     */
    @Test
    public void startSignUpOptionTest()
    {
        presenter.onClickSignUp();

        Assert.assertEquals(stub.getSignUpCounter(), 1);
    }

    /**
     * This method tests the code that is responsible for
     * handling the presses of the next button.
     */
    @Test
    public void startNextOptionTest()
    {
        presenter.onClickNext();

        Assert.assertEquals(stub.getNextCounter(), 1);
    }

    /**
     * This method tests the code that is responsible for
     * returning the name.
     */
    @Test
    public void getNameTest()
    {
        Assert.assertEquals(stub.getName(), NAME);
    }

    /**
     * This method tests the code that is responsible for
     * returning the password.
     */
    @Test
    public void getPasswordTest()
    {
        Assert.assertEquals(stub.getPassword(), PASS);
    }

    /**
     * This method tests the code that is responsible for
     * returning the email.
     */
    @Test
    public void getEmailTest()
    {
        Assert.assertEquals(stub.getEmail(), EMAIL);
    }

    /**
     * This method tests the code that is responsible for
     * returning the phone.
     */
    @Test
    public void getPhoneTest()
    {
        Assert.assertEquals(stub.getPhone(), PHONE);
    }

    /**
     * This method tests the code that is responsible for
     * returning the street name.
     */
    @Test
    public void getStreetNameTest()
    {
        Assert.assertEquals(stub.getStreetName(), STREETNAME);
    }

    /**
     * This method tests the code that is responsible for
     * returning the street number.
     */
    @Test
    public void getStreetNumberTest()
    {
        Assert.assertEquals(stub.getStreetNumber(), STREETNUMBER);
    }

    /**
     * This method tests the code that is responsible for
     * returning the postal code.
     */
    @Test
    public void getPostalCodeTest()
    {
        Assert.assertEquals(stub.getPostalCode(), POSTALCODE);
    }
}
