package gr.aueb.softeng.project1804.view.signupcategories;

/**
 * Created by Stratos on 8/5/2018.
 */

public interface SignUpCategoriesView {

    /**
     * this method is responsible for letting a technician choose in which category he belongs
     */
    void startChooseCategoryOption();

    /**
     * this method is responsible for letting a technician choose in which city he is available
     */
    void startChooseCitiesOption();

    /**
     * this method is responsible for letting a technician choose which hours he is available
     */
    void startChooseHoursOption();

    /**
     * this method is responsible for letting a technician choose which days he is available
     */
    void startChooseDaysOption();

    /**
     * this method is continues the signup procedure
     */
    void startContinueOption();

}
