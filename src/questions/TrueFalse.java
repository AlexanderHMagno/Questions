package questions;
import java.util.Arrays;

/**
 * This class represents a Question type True of False, it has a Question, an array of answers and array of options.
 * It extends the AbstractQuestion class.
 */
public class TrueFalse extends AbstractQuestion {

    /**
     * Constructor method, it expects a Questions and Answer
     * @param question Text to display as a question
     * @param answer A String with 2 valid options True or False
     * @throws IllegalArgumentException if the provided answer is not a string equal to True or False
     */
    public TrueFalse(String question, String answer) throws IllegalArgumentException {
        super(question, answer ,"True","False");

        String[] valid = {"True","False"};

        if (!Arrays.asList(valid).contains(answer)) {
            throw new IllegalArgumentException("True or False are the only valid input");
        }

    }

    @Override
    public int compareTo(Question o) {
        return ((AbstractQuestion) o).compareToTrueFalse(this);
    }

    /**
     * It will compare instances of type TrueFalse.
     * @param o The other object of type TrueFalse to compare with this Question
     * @return An integer to indicate if this instance is lower or greater than the other one
     */
    @Override
    protected int compareToTrueFalse(TrueFalse o) {
        return this.compareText(o);
    }
}
