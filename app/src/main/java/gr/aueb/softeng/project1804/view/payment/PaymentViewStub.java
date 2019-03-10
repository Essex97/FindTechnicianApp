package gr.aueb.softeng.project1804.view.payment;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class PaymentViewStub implements PaymentView
{
    private int startPayOption, startEvaluationOption, startChooseTechnician;

    public PaymentViewStub()
    {
        startChooseTechnician=0;
        startEvaluationOption=0;
        startPayOption=0;
    }
    @Override
    public void startPayOption()
    {
        startPayOption++;
    }

    @Override
    public void startEvaluateOption()
    {
        startEvaluationOption++;
    }

    @Override
    public void startChooseTechnician()
    {
        startChooseTechnician++;
    }

    public int getStartPayOption()
    {
        return startPayOption;
    }

    public int getStartEvaluationOption()
    {
        return startEvaluationOption;
    }

    public int getStartChooseTechnician()
    {
        return startChooseTechnician;
    }

}
