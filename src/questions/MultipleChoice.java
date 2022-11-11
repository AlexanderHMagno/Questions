package questions;

public class MultipleChoice extends MultipleSelect {

    public MultipleChoice(String question, String[] answer, String[] options) throws IllegalArgumentException {
        super(question, answer, options);

        if (answer.length > 1) {
            throw new IllegalArgumentException("Please provide 1 answer, for multiple answers use MultipleSelect");
        }
    }

    @Override
    public int compareTo(Question o) {
        return ((AbstractQuestion) o).compareToMultipleChoice(this);
    }

    @Override
    protected int compareToMultipleChoice(MultipleChoice o) {
        System.out.println("alex");
        return this.compareText(o);
    }

}
