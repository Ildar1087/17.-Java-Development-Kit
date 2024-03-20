package HW4;


import java.util.List;

public class Program {
    public static void main(String[] args) {
        // создаем экземпляр класса ReferenceBook
        ReferenceBook refbook = new ReferenceBook();

        refbook.addEmployee(1, "89003212132", "Измайлов", 3);
        refbook.addEmployee(2, "89990005434", "Михайлова", 9);
        refbook.addEmployee(3, "89443432323", "Акинфеев", 3);
        refbook.addEmployee(4, "89545423232", "Самойлов", 10);
        refbook.addEmployee(1, "89943232312", "Авелдаюков", 2);


        // Поиск сотрудников с опытом 3 года и вывод их имен
        List<ReferenceBook.Employee> employeesExperience = refbook.findEmployeesByWorkExperience(3);
        System.out.println("1. Сотрудники со стажем 3 года:");
        for (ReferenceBook.Employee employee : employeesExperience) {
            System.out.println(employee.getName());
        }

        // Поиск номера телефона по имени сотрудника
        String phoneNumber = refbook.findPhoneNumberByName("Самойлов");
        System.out.println("2. Номер телефона Самойлов: " + phoneNumber);

        // Поиск сотрудника по табельному номеру и вывод его имени
        ReferenceBook.Employee employee = refbook.findEmployeeByEmployeeId(10);
        if (employee != null) {
            System.out.println("3. Сотрудник с табельным номером 1 найден: " + employee.getName());
        } else {
            System.out.println("3. Сотрудника с данным табельным номером нет.");
        }
    }
}
