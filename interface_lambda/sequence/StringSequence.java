package interface_lambda.sequence;

public class StringSequence implements Sequence<Number> {
    private String number;
    private int idx;
    private int size;

    public StringSequence(String number) {
        this.number = number;
        idx = 0;
        size = number.length();
    }

    @Override
    public synchronized boolean hasNext() {
        return idx < size - 1;
    }

    @Override
    public synchronized Integer next() {
        char digit = number.charAt(idx);
        validateDigit(digit);

        idx++;
        return digit - '0';
    }

    private void validateDigit(char digit) {
        if (!Character.isDigit(digit)) throw new NumberFormatException("[" + digit + "] is not a digit");
    }

    @Override
    public int size() {
        return size;
    }
}
