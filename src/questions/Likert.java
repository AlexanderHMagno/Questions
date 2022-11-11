package questions;


public class Likert extends AbstractQuestion{

    public Likert(String question, String[] options) {
        super(question, options);
    }

    @Override
    public int compareTo(Question o) {
        return ((AbstractQuestion) o).compareToLikert(this);
    }

    @Override
    protected int compareToLikert(Likert o) {
        return this.compareText(o);
    }
}
