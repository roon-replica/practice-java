package java_util_function;

// lambda
//   - 익명함수
//   - first-class-language-citizen으로 다룰 수 있음 == 메서드 파라미터로 변수처럼 넘길 수 있음

import java.util.*;
import java.util.function.Function;

// java.util.function.Function<T,R> interface
//   - Represents a function that accepts one argument(T) and produces a result(R).
// 메서드
//   - R apply(T t)
//       -Applies this function to the given argument.
public class FunctionExample {
    public static void main(String[] args) {
        libraryFunctionInterface();

        customFunctionInterface();

        chainingFunction();
    }

    public static void libraryFunctionInterface() {
        Map<String, Integer> map = new HashMap<>();

        // computeIfAbsent: Function 인터페이스의 apply를 wrapping한 메서드임
        int value = map.computeIfAbsent("leemr", String::length);

        System.out.println(value);
    }

    public static void customFunctionInterface() {
        Function<String, Integer> function = String::length;

        int value = function.apply("leemr");
        System.out.println(value);
    }

    public static void chainingFunction() {
        Function<List<String>, List<String>> addParagraph = list -> {
            var ret = new ArrayList<String>();
            for (String s : list) {
                s = "'" + s + "'";
                ret.add(s);
            }
            return ret;
        };

        Function<List<String>, List<String>> addStar = list -> {
            var ret = new ArrayList<String>();
            for (String s : list) {
                s = "*" + s + "*";
                ret.add(s);
            }
            return ret;
        };

        var res = addParagraph.andThen(addStar).apply(Arrays.asList("leemr", "musk", "jobs"));

        System.out.println(res);
    }
}
