package interface_lambda.library.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 라이브러리에서 제공하는 인터페이스들 몇가지
// Comparable
// Comparator
// Runnable
// EventHandler(GUI 용도)

public class comparable {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{new Employee(3), new Employee(2), new Employee(1)};

        // using comparable
        Arrays.sort(employees);

        // using comparator
        Arrays.sort(employees, Employee::compareTo);

        String arrayOrder = Arrays.stream(employees)
                .map(Employee::toString)
                .collect(Collectors.joining(" "));

        System.out.println(arrayOrder);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Employee> employeeList = Arrays.asList(new Employee(3), new Employee(2), new Employee(1));

        // using comparable
        Collections.sort(employeeList);

        // using comparator
        employeeList.sort(Employee::compareTo);

        String listOrder = employeeList.stream()
                .map(Employee::toString)
                .collect(Collectors.joining(" "));

        System.out.println(listOrder);
    }


    private static class Employee implements Comparable<Employee> {
        private int id;

        public Employee(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(id, o.id);
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
