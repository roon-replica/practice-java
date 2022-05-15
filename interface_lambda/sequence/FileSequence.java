package interface_lambda.sequence;

public class FileSequence implements Sequence<Number>, CustomCloseable {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Number next() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isOpen() {
        return false;
    }
}
