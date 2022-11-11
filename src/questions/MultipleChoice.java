package questions;


/**
 * This class represents a Question type Multiple Choice, it has a Question, an array of answer and array of options.
 * It extends the MultipleSelect class.
 */
public class MultipleChoice extends MultipleSelect {

    /**
     * Constructor method, it expects a Questions a unique answer and possible options
     * @param question Text to display as a question
     * @param answer A unique answer is possible in this implementation.
     * @param options Include the options to display as possible answers to this question.
     * @throws IllegalArgumentException if the answer array size is greater than 1.
     */
    public MultipleChoice(String question, String[] answer, String[] options) throws IllegalArgumentException {
        super(question, answer, options);

        if (answer.length > 1) {
            throw new IllegalArgumentException("Please provide at most 1 answer, for multiple answers use MultipleSelect");
        }
    }

    @Override
    public int compareTo(Question o) {
        return ((AbstractQuestion) o).compareToMultipleChoice(this);
    }

    /**
     * It will compare instances of type MultipleChoice.
     * @param o The other object of type MultipleChoice to compare with this Question
     * @return An integer to indicate if this instance is lower or greater than the other one
     */
    @Override
    protected int compareToMultipleChoice(MultipleChoice o) {
        return this.compareText(o);
    }

}
