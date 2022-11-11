package questions;

/**
 * This class represents a Question type Multiple Select, it has a Question, an  answer and options.
 * It extends the AbstractQuestion class.
 */
public class MultipleSelect extends AbstractQuestion {

    /**
     * Constructor method, it expects a Questions a multiple answer array and possible options
     * @param question Text to display as a question
     * @param answer A string with 2 or more answers is possible in this implementation. Separate each answer by space
     * @param options Include the options to display as possible answers to this question.
     * @throws IllegalArgumentException if the options array size is lower than 3 or greater than 8.
     */
    public MultipleSelect(String question, String answer, String... options) throws IllegalArgumentException {

        super(question,answer,options);

        if(options.length < 3 || options.length > 8) {
            throw new IllegalArgumentException("Options should be between 3 and 8");
        }
    }

    @Override
    public int compareTo(Question o) {
        if (o instanceof MultipleChoice) return 1;
        return ((AbstractQuestion) o).compareToMultipleSelect(this);
    }

    /**
     * It will compare instances of type MultipleSelect.
     * @param o The other object of type MultipleSelect to compare with this Question
     * @return An integer to indicate if this instance is lower or greater than the other one
     */
    @Override
    protected int compareToMultipleSelect(MultipleSelect o) {
        return this.compareText(o);
    }

}
