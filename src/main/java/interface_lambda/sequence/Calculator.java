package interface_lambda.sequence;

import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) {
        calcTest();

        castTest();
    }

    private static void castTest(){
        Sequence<Number> sequence = new StringSequence("1234");
        StringSequence stringSequence = (StringSequence) sequence;
        System.out.println(stringSequence.next());
    }

    private static void calcTest(){
        Sequence<Number> stringSequence = new StringSequence("1234");
        System.out.println(average(stringSequence, 3));

        Sequence<Number> integerList = new ListSequence(Arrays.asList(1, 2, 3, 4));
        System.out.println(average(integerList, 3));

        Sequence<Number> doubleList = new ListSequence(Arrays.asList(1.1, 2.2, 3.3, 4.4));
        System.out.println(average(doubleList, 3));
    }

    public static double average(Sequence<Number> sequence, int count) {
        validateSize(sequence, count);

        double ret = 0;
        for (int i = 0; sequence.hasNext() && i < count; i++) {
            ret += sequence.next().doubleValue();
        }

        return count == 0 ? 0 : ret / count;
    }

    private static void validateSize(Sequence sequence, int count) {
        if (sequence.size() < count) {
            throw new IndexOutOfBoundsException("sequence size is smaller than " + count);
        }
    }
}
