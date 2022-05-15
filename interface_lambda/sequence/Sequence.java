package interface_lambda.sequence;

public interface Sequence<T extends Number> {
    boolean hasNext();

    T next();

    int size();
}
