package questions;

import java.util.Arrays;

/**
 * Abstract class that represents a Question, it has a question, an Answer and options. It implements the
 * Question Interface
 */
public abstract class AbstractQuestion implements Question {

    private final String question;
    private final String answer;
    private final String[] options;

    /**
     * Constructor method, it expects a Questions an answer and possible options
     * @param question Text to display as a question
     * @param answer A String with the expected answers separated by a space if multiple provided.
     * @param options Include the options to display as possible answers to this question.
     */
    public AbstractQuestion(String question, String answer, String... options) {

        this.question = question;
        this.answer = answer.trim();;
        this.options = options;
    }

    @Override
    public String answer(String answer) {

        //If not Answer is provide
        if(answer.trim().length() == 0) return AbstractQuestion.INCORRECT;

        //Else verify if the answer provided is equal to the initial answer
        String[] answerArray = answer.trim().split(" ");
        String[] validArray = this.answer.trim().split(" ");

        Arrays.sort(answerArray);
        Arrays.sort(validArray);

        return Arrays.equals(answerArray,validArray)? Question.CORRECT : Question.INCORRECT;
    }


    @Override
    public String getText() {
        return this.question;
    }

    /**
     * Double dispatch method to compare other objects to Likert
     * @param o The other object of type Likert to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareToLikert (Likert o) {return 1;}

    /**
     * Double dispatch method to compare other objects to MultipleSelect
     * @param o The other object of type MultipleSelect to compare with this Question
     * @return An integer to indicate if this instances is lower or greater than the other one
     */
    protected int compareToMultipleSelect (MultipleSelect o) {
        return (this instanceof Likert)? -1 : 1;
    }
    /**
     * Double dispatch method to compare other objects to MultipleChoice
     * @param o The other object of type MultipleChoice to compare with this Question
     * @return An integer to indicate if the other element is lower or greater than this one
     */
    protected int compareToMultipleChoice (MultipleChoice o) {
        return  (this instanceof TrueFalse) ? 1 : -1;
    }


    /**
     * Double dispatch method to compare other objects to TrueFalse
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
        int diff = o.getText().compareTo(this.getText());
        return diff == 0 ? 0 : diff > 0 ? 1 : -1;
    }
}
