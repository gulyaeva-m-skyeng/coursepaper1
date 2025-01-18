import java.util.Objects;
import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Сергей", "Иван", "Александр", "Павел", "Максим"};
    private final static String[] PATRONYMIC_NAMES = {"Сергеевич", "Иванович", "Александрович", "Павлович", "Максимович"};
    private final static String[] SURNAMES = {"Сергеев", "Иванов", "Александров", "Павлов", "Максимов"};

    private static Employee[] employees = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(0, PATRONYMIC_NAMES.length)];
            employees[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(75_000, 150_000));
        }

    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма ЗП сотрудников: " + calculateSumofSalaries());
        System.out.println("Сотрудника с мин ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудника с макс ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя ЗП: " + calculateAverageOfSalaries());
        printFullNames();
    }

    private static void print() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateSumofSalaries() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumofSalaries() / employees.length;
    }

    private static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static void main(String[] args) {
        Employee alexandrovMaxim = new Employee("Александров Максим Павлович", 1, 89369);
        Employee pavlovIvan = new Employee("Павлов Иван Максимович", 5, 89697);

        System.out.println(alexandrovMaxim.hashCode());
        System.out.println(pavlovIvan.hashCode());
        System.out.println(alexandrovMaxim.equals(pavlovIvan));
    }
}







