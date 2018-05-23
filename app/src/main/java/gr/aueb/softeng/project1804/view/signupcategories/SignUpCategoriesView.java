package gr.aueb.softeng.project1804.view.signupcategories;

/**
 * Created by Stratos on 8/5/2018.
 */

public interface SignUpCategoriesView {

    /**
     * this method is responsible for letting a technician choose in which category he belongs
     */
    public void startChooseCategoryOption();

    /**
     * this method is responsible for letting a technician choose in which city he is available
     */
    public void startChooseCitiesOption();

    /**
     * this method is responsible for letting a technician choose which hours he is available
     */
    public void startChooseHoursOption();

    /**
     * this method is responsible for letting a technician choose which days he is available
     */
    public void startChooseDaysOption();

    /**
     * this method is continues the signup procedure
     */
    public void startContinueOption();


}
