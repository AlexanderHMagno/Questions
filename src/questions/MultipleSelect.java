package questions;

import java.util.Arrays;

public class MultipleSelect extends AbstractQuestion {

    public MultipleSelect(String question, String[] answer, String[] options) throws IllegalArgumentException {

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

    @Override
    protected int compareToMultipleSelect(MultipleSelect o) {
        return this.compareText(o);
    }

}
