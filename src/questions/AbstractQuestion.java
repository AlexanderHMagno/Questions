package questions;

import java.util.Arrays;

public abstract class AbstractQuestion implements Question {

    private final String question;
    private final String[] response;
    private final String[] options;

    public AbstractQuestion(String question, String[] answer, String[] options) throws IllegalArgumentException {
        if (answer.length == 0) throw new IllegalArgumentException("Provide a valid Answer array");

        this.question = question;
        this.response = answer;
        this.options = options;
    }

    public AbstractQuestion(String question, String[] options) {
        this.question = question;
        this.response = new String[0];
        this.options = options;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String answer(String answer) {

        //If not Answer provided
        if (this.response.length == 0) return AbstractQuestion.CORRECT;

        //Else verify if the answer provided is equal to the initial response
        String[] split = answer.trim().split(" ");
        Arrays.sort(this.response);
        Arrays.sort(split);

        return Arrays.equals(this.response, split) ? Question.CORRECT : Question.INCORRECT;
    }

    @Override
    public String getText() {
        return this.question;
    }

    @Override
    public int compareTo(Question o) {
        return 0;
    }

    //Double Dispatch implementation

    protected int compareToLikert (Likert o) {return 1;}
    protected int compareToMultipleSelect (MultipleSelect o) {
        return (this instanceof Likert)? -1 : 1;
    }
    protected int compareToMultipleChoice (MultipleChoice o) {
        return  (this instanceof TrueFalse) ? 1 : -1;
    }
    protected int compareToTrueFalse (TrueFalse o) {return -1;}

    protected int compareText (Question o) {
//        System.out.println(o.getText() + " |||| " + this.getText() + "|||" + o.getText().compareTo(this.getText()));
        return o.getText().compareTo(this.getText()) > 0 ? 1 : -1;
    }
}
