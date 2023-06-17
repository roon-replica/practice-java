package functional_interface.function_util;


// Runnalbe
// T Supplier<T> () - get
// void Consumer<T> (T) - accept
// void BiConsumer<T,U> (T,U) - accept
// R Function<T,R> (T) - apply
// R BiFunction<T,U,R> (T,U) - apply
// T UnaryOperator<T> (T) - apply
// boolean Predicate<T> - test

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionExample2 {
    public static void main(String[] args) {
        Supplier<String> HELLO_SUPPLIER = () -> "HELLO";
        System.out.println(HELLO_SUPPLIER.get());

        AtomicInteger num = new AtomicInteger();
        Consumer<Integer> numAdder = num::addAndGet;
        numAdder.accept(11);
        System.out.println(num.get());

        AtomicReference<String> sampleStr = new AtomicReference<>("hello");
        BiConsumer<Character, String> strDecorator = (firstChar, suffix) -> sampleStr.set(firstChar + " " + sampleStr + " " + suffix);
        strDecorator.accept('X', "suffix");
        System.out.println(sampleStr.get());

        Function<String, String> beforeFunction = t -> t + "1";
        Function<String, Integer> toInt = Integer::parseInt;
        Function<Integer, Integer> afterFunction = t -> t + 1;
        // 이건 좀 실행 순서가 이상할 듯.
        // 논리적으론 compose -> apply -> andThen 순서일듯한데
        // 실제로는 더 복잡한듯..
        int parsedIntNum = toInt.compose(beforeFunction)
                .andThen(afterFunction)
                .apply("123");
        System.out.println(parsedIntNum);

        // predicate
        Predicate<String> startsWith = str -> str.startsWith("START");
        Predicate<String> endsWith = str -> str.endsWith("END");
        Predicate<String> lengthLimit = str -> str.length() <= 8 + 2 + 2;
        List<String> sampleStrs = Arrays.asList("START_1_END", "XXX_12_END", "START_123_END", "XXX_1234_END", "START_12345_END" );
        String filtered1 = sampleStrs.stream()
                        .filter(startsWith.and(endsWith).and(lengthLimit))  // 프레디케이트 체이닝!!
                        .collect(Collectors.joining(" "));
        System.out.println(filtered1);

        String filtered2 = sampleStrs.stream()
                        .filter(startsWith.or(lengthLimit.negate()))       // and 외에 or도 사용 가능
                        .collect(Collectors.joining(" "));
        System.out.println(filtered2);

        Predicate<Character> isDigit = Character::isDigit;
        System.out.println(isDigit.test('1'));

        // List<Predicate>를  reduce해서 stream.filter에 predicate를 넘겨줄 수도 있음
        // 근데 Predicate라고 굳이 선언해가며 사용하기는 그닥 실효성은 없는듯
        // 코드의 의미를 살리는덴 더 좋긴할듯

    }


}
