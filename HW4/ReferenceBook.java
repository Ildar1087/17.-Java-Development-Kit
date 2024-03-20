package HW4;

import java.util.ArrayList;
import java.util.List;

public class ReferenceBook {
    List<Employee> employees = new ArrayList<>();

    public class Employee {
        private int employeeId; // табельный номер сотрудника
        private String phoneNumber;
        private String name;
        private int workExperience; // трудовой стаж

        public Employee(int employeeId, String phoneNumber, String name, int workExperience) {
            this.employeeId = employeeId;
            this.phoneNumber = phoneNumber;
            this.name = name;
            this.workExperience = workExperience;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getName() {
            return name;
        }

        public int getWorkExperience() {
            return workExperience;
        }
    }

    /**
     * Метод для добавления нового сотрудника
     */
    public void addEmployee(int employeeId, String phoneNumber, String name, int workExperience) {
        Employee newEmployee = new Employee(employeeId, phoneNumber, name, workExperience);
        employees.add(newEmployee);
    }

    /**
     * Метод по поиску сотрудника по стажу
     */
    public List<Employee> findEmployeesByWorkExperience(int targetWorkExperience) {
        List<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getWorkExperience() == targetWorkExperience) {
                res.add(employee);
            }
        }
        return res;
    }

    /**
     * Метод по поиску сотрудника по имени
     */
    public String findPhoneNumberByName(String targetName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(targetName)) {
                return employee.getPhoneNumber();
            }
        }
        return "Сотрудник с именем " + targetName + " не найден!";
    }

    /**
     * Метод для поиска сотрудника по табельному номеру
     */
    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null; // Если такого сотрудника нет
    }

}

