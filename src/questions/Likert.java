package questions;

/**
 * This class represents a Question type likert, it doesn't have a defined answer.It extends the AbstractQuestion class.
 */
public class Likert extends AbstractQuestion{

    /**
     * Constructor method, it expects a Question
     * @param question Text to display as a question
     */
    public Likert(String question) {
        super(question,"","");
    }

    @Override
    public int compareTo(Question o) {
        return ((AbstractQuestion) o).compareToLikert(this);
    }

    /**
     * It will compare instances of typer Likert.
     * @param o The other object of type Likert to compare with this Question
     * @return An integer to indicate if this instance is lower or greater than the other one
     */
    @Override
    protected int compareToLikert(Likert o) {
        return this.compareText(o);
    }
}
