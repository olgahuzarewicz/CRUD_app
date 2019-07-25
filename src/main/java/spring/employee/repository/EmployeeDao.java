package spring.employee.repository;

import spring.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList();

    Employee getEmployeeById(Long empId);

    Employee updateEmployee(Employee emp);

    Employee deleteEmployee(Long empId);
}
