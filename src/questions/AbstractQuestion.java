package questions;

import java.util.Arrays;

/**
 * Abstract class that represents a Question, it has a question, an Answer and options. It implements the
 * Question Interface
 */
public abstract class AbstractQuestion implements Question {

    private final String question;
    private final String[] answer;
    private final String[] options;

    /**
     * Constructor method, it expects a Questions an answer and possible options
     * @param question Text to display as a question
     * @param answer An array of String with the expected answers.
     * @param options Include the options to display as possible answers to this question.
     * @throws IllegalArgumentException if the answer is not provided
     */
    public AbstractQuestion(String question, String[] answer, String[] options) throws IllegalArgumentException {
        if (answer.length == 0) throw new IllegalArgumentException("Provide a valid Answer array");

        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    /**
     * Constructor method, it expects a Questions and possible options, the answer by default is empty.
     * @param question Text to display as a question
     * @param options Include the options to display as possible answers to this question.
     */
    public AbstractQuestion(String question, String[] options) {
        this.question = question;
        this.answer = new String[0];
        this.options = options;
    }


    @Override
    public String answer(String answer) {

        //If not Answer provided
        if (this.answer.length == 0) return AbstractQuestion.CORRECT;

        //Else verify if the answer provided is equal to the initial answer
        String[] split = answer.trim().split(" ");
        Arrays.sort(this.answer);
        Arrays.sort(split);

        return Arrays.equals(this.answer, split) ? Question.CORRECT : Question.INCORRECT;
    }

    @Override
    public String getText() {
        return this.question;
    }

    /**
     * Double dispatch function to compare other objects to Likert
     * @param o The other object of type Likert to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareToLikert (Likert o) {return 1;}

    /**
     * Double dispatch function to compare other objects to MultipleSelect
     * @param o The other object of type MultipleSelect to compare with this Question
     * @return An integer to indicate if this instances is lower or greater than the other one
     */
    protected int compareToMultipleSelect (MultipleSelect o) {
        return (this instanceof Likert)? -1 : 1;
    }
    /**
     * Double dispatch function to compare other objects to MultipleChoice
     * @param o The other object of type MultipleChoice to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareToMultipleChoice (MultipleChoice o) {
        return  (this instanceof TrueFalse) ? 1 : -1;
    }


    /**
     * Double dispatch function to compare other objects to TrueFalse
     * @param o The other object of type TrueFalse to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareToTrueFalse (TrueFalse o) {return -1;}

    /**
     * Compare two instances of the same class and based on a Lexicographical comparison it determines
     * which instance goes first in case of sorting.
     *      Note: As per each class in this implementation has the same comparison among themselves, then
     *      we should implement only once this function to compare instances of the same class.
     * @param o The other object of type Question to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareText (Question o) {
        return o.getText().compareTo(this.getText()) > 0 ? 1 : -1;
    }
}
