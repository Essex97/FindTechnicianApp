package gr.aueb.softeng.project1804.view.signup;

/**
 * Created by marios on 5/12/18.
 */

public class SignUpViewStub implements SignUpView
{
    private String name, password, email,phone, streetName, postalCode;
    private int streetNumber, signUpCounter, nextCounter;
    public SignUpViewStub(int number, String ... args)
    {
        signUpCounter = 0;
        nextCounter = 0;
        streetNumber = number;
        if (args.length == 6)
        {
            name = args[0];
            password = args[1];
            phone = args[2];
            streetName = args[3];
            postalCode = args[4];
            email = args[5];
        }else
        {
            name = null;
            password = null;
            phone = null;
            streetName = null;
            postalCode = null;
        }
    }

    @Override
    public void startSignUpOption()
    {
        signUpCounter++;
    }

    @Override
    public void startNextOption()
    {
        nextCounter++;
    }

    public int getSignUpCounter()
    {
        return signUpCounter;
    }

    public int getNextCounter()
    {
        return nextCounter;
    }

    @Override
    public String getName()

    {
        return name;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getPhone()
    {
        return phone;
    }

    @Override
    public String getStreetName()
    {
        return streetName;
    }

    @Override
    public int getStreetNumber()
    {
        return streetNumber;
    }

    @Override
    public String getPostalCode()
    {
        return postalCode;
    }
}
