package gr.aueb.softeng.project1804.signupcategories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;
import gr.aueb.softeng.project1804.view.signupcategories.SignUpCategoriesPresenter;
import gr.aueb.softeng.project1804.view.signupcategories.SignUpCategoriesViewStub;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class SignUpCategoriesPresenterTest
{
    private SignUpCategoriesPresenter presenter;
    private SignUpCategoriesViewStub stub;

    @Before
    public void setUp() throws Exception
    {
        stub = new SignUpCategoriesViewStub();
        presenter = new SignUpCategoriesPresenter(stub);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the users input when choosing a category
     */
    @Test
    public void onClickChooseCategoryTest()
    {
        presenter.onClickChooseCategory();

        Assert.assertEquals(stub.getCategories(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the users input when choosing cities
     */
    @Test
    public void onClickChooseCitiesTest()
    {
        presenter.onClickChooseCities();

        Assert.assertEquals(stub.getCities(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the users input when choosing hours
     */
    @Test
    public void onClickChooseHoursTest()
    {
        presenter.onClickChooseHours();

        Assert.assertEquals(stub.getHours(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the users input when choosing days
     */
    @Test
    public void onClickChooseDaysTest()
    {
        presenter.onClickChooseDays();

        Assert.assertEquals(stub.getDays(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the users input when choosing to continue
     */
    @Test
    public void onClickContinueTest()
    {
        presenter.onClickContinue();

        Assert.assertEquals(stub.getContin(), 1);
    }


}
