package gr.aueb.softeng.project1804;

public class Evaluation
{
    private String comment;
    private Technician technician;
    private Visit visit;
    private Scale technicianBehavior, workQuality, priceEvaluation;

    /**
     * Constructor
     *
     * @param technician the technician associated with this evaluation
     * @param visit the visit associated with this evaluation
     * @param visit the comment associated with this evaluation
     * @param technicianBehavior the rating given
     * @param workQuality the rating given
     * @param priceEvaluation the rating given
     */
    public Evaluation(Technician technician, Visit visit, String comment, Scale technicianBehavior, Scale workQuality, Scale priceEvaluation)
    {
        this.technician = technician;
        this.comment = comment;
        this.visit = visit;
        this.technicianBehavior = technicianBehavior;
        this.workQuality = workQuality;
        this.priceEvaluation = priceEvaluation;
    }

    /**
     * @return this specific rating
     */
    public Scale getTechnicianBehavior()
    {
        return technicianBehavior;
    }

    /**
     * @return this specific rating
     */
    public Scale getWorkQuality()
    {
        return workQuality;
    }

    /**
     * @return this specific rating
     */
    public Scale getPriceEvaluation()
    {
        return priceEvaluation;
    }

    /**
     * @param newTechnicianBehavior sets the Evaluation's technicianBehaviour to newTechnicianBehaviour
     */
    public void setTechnicianBehaviour(Scale newTechnicianBehavior)
    {
        technicianBehavior = newTechnicianBehavior;
    }

    /**
     * @param newWorkQuality sets the Evaluation's workQuality to newWorkQuality
     */
    public void setWorkQuality(Scale newWorkQuality)
    {
        workQuality = newWorkQuality;
    }

    /**
     * @param newPriceEvaluation sets the Evaluation's priceEvaluation to newPriceEvaluation
     */
    public void setPriceEvaluation(Scale newPriceEvaluation)
    {
        priceEvaluation = newPriceEvaluation;
    }

    /**
     * @return the unique comments of this evaluation
     */
    public String getComment()
    {
        return comment;
    }

    public void setComment(String newComment)
    {
        comment = newComment;
    }

    /**
     * @return the customer associated with this Evaluation
     */

    /**
     * @return the technician associated with this Evaluation
     */
    public Technician getTechnician()
    {
        return technician;

    }

    /**
     * @return the visit associated with the current Evaluation
     */
    public Visit getVisit()
    {
        return visit;
    }

    /**
     * @param o object to compare with the current
     * @return true or false
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evaluation that = (Evaluation) o;

        if (!comment.equals(that.comment)) return false;
        if (!technician.equals(that.technician)) return false;
        if (!visit.equals(that.visit)) return false;
        if (technicianBehavior != that.technicianBehavior) return false;
        if (workQuality != that.workQuality) return false;
        return priceEvaluation == that.priceEvaluation;
    }

    @Override
    public int hashCode()
    {
        int result = comment.hashCode();
        result = 31 * result + technician.hashCode();
        result = 31 * result + visit.hashCode();
        result = 31 * result + technicianBehavior.hashCode();
        result = 31 * result + workQuality.hashCode();
        result = 31 * result + priceEvaluation.hashCode();
        return result;
    }
}