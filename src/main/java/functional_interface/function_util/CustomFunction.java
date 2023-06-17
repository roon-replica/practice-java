package functional_interface.function_util;

@FunctionalInterface
public interface CustomFunction {
    void print();

    //  equals, toString이 추상메서드처럼 보여도 java.lang.Object에 구현되어 있는 메서드들은 추상 메서드로 세아리지 않음.
    boolean equals(Object o);

    String toString();


}
