package questions;

import java.util.Arrays;

public class TrueFalse extends AbstractQuestion {

    public TrueFalse(String question, String answer) throws IllegalArgumentException {
        super(question, new String[]{answer} ,new String[]{"True","False"} );

        String[] valid = {"True","False"};

        if (!Arrays.asList(valid).contains(answer)) {
            throw new IllegalArgumentException("True or False are the only valid input");
        }

    }

    @Override
    public int compareTo(Question o) {

        return ((AbstractQuestion) o).compareToTrueFalse(this);
    }

    @Override
    protected int compareToTrueFalse(TrueFalse o) {
        return this.compareText(o);
    }

}
