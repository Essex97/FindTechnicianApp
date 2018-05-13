package gr.aueb.softeng.project1804.view.signupcategories;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class SignUpCategoriesViewStub implements SignUpCategoriesView
{
    private int categories, cities, hours, days, contin;
    public SignUpCategoriesViewStub()
    {
        categories=0;
        cities=0;
        hours=0;
        days=0;
        contin=0;
    }


    public int getCategories()
    {
        return categories;
    }

    public int getCities()
    {
        return cities;
    }

    public int getHours()
    {
        return hours;
    }

    public int getDays()
    {
        return days;
    }

    public int getContin()
    {
        return contin;
    }

    @Override
    public void startChooseCategoryOption()
    {
        categories++;
    }

    @Override
    public void startChooseCitiesOption()
    {
        cities++;
    }

    @Override
    public void startChooseHoursOption()
    {
        hours++;
    }

    @Override
    public void startChooseDaysOption()
    {
        days++;
    }

    @Override
    public void startContinueOption()
    {
        contin++;
    }
}
