import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int sum = traverse(map, map.get(id));
        return sum;
    }

    public int traverse(HashMap<Integer, Employee> map, Employee employee) {
        if (employee == null) {
            return 0;
        }
        int sum = employee.importance;
        for (Integer n : employee.subordinates) {
            sum += traverse(map, map.get(n));
        }
        return sum;
    }

    public void test() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        employee1.subordinates = list1;
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        List<Integer> list2 = new ArrayList<>();
        employee2.subordinates = list2;
        employees.add(employee2);

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        List<Integer> list3 = new ArrayList<>();
        employee3.subordinates = list3;
        employees.add(employee3);

        System.out.println(getImportance(employees, 1));
    }
}
