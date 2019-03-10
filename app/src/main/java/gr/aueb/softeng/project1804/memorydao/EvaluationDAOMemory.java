package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Evaluation;

/**
 * Created by Stratos on 2/5/2018.
 */

public class EvaluationDAOMemory {
    protected static ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();

    /**
     * Save an Evaluation into the list
     * @param evaluation The OfferedService we want to add
     */
    public void add(Evaluation evaluation){
        evaluations.add(evaluation);
    }

    /**
     * Returns all the evaluations
     * @return the evaluations list
     */
    public ArrayList<Evaluation> getEvaluations() {
        ArrayList<Evaluation> result = new ArrayList<Evaluation>();
        result.addAll(evaluations);
        return result;
    }
}
