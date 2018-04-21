package gr.aueb.softeng.project1804;

public class Evaluation
{
    private String comment;
    private static int counter = 0;
    private String evaluationID;
    private Technician technician;
    private Visit visit;
    private Scale technicianBehavior, workQuality, priceEvaluation;

    /**
     * Constructor
     *
     * @param technician the technician associated with this evaluation
     * @param visit the visit associated with this evaluation
     */
    public Evaluation(Technician technician, Visit visit)
    {
        counter++;
        evaluationID = counter + "";
        this.technician = technician;
        this.visit = visit;
    }

    /**
     * @return unique id
     */
    public String getEvaluationID()
    {
        return evaluationID;
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


    /**
     * @param newComment sets the Evaluation's comment to newComment
     */
    public void setComment(String newComment)
    {
        comment = newComment;
    }


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

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (!evaluationID.equals(that.evaluationID)) return false;
        if (technician != null ? !technician.equals(that.technician) : that.technician != null)
            return false;
        if (visit != null ? !visit.equals(that.visit) : that.visit != null) return false;
        if (technicianBehavior != that.technicianBehavior) return false;
        if (workQuality != that.workQuality) return false;
        return priceEvaluation == that.priceEvaluation;
    }

    @Override
    public int hashCode()
    {
        int result = comment != null ? comment.hashCode() : 0;
        result = 31 * result + evaluationID.hashCode();
        result = 31 * result + (technician != null ? technician.hashCode() : 0);
        result = 31 * result + (visit != null ? visit.hashCode() : 0);
        result = 31 * result + (technicianBehavior != null ? technicianBehavior.hashCode() : 0);
        result = 31 * result + (workQuality != null ? workQuality.hashCode() : 0);
        result = 31 * result + (priceEvaluation != null ? priceEvaluation.hashCode() : 0);
        return result;
    }
}