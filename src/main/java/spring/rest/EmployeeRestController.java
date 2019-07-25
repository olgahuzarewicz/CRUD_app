package spring.rest;

import org.springframework.web.bind.annotation.*;
import spring.employee.entity.Employee;
import spring.employee.service.EmployeeService;

import java.util.List;

@RestController("/emp")
public class EmployeeRestController {

    private EmployeeService employeeService;

    EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee newEmployee){
        return employeeService.insertEmployee(newEmployee);
    }

    @PutMapping("/emp/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee){
        newEmployee.setEmpId(id);
        return employeeService.updateEmployee(newEmployee);
    }

    @DeleteMapping("/emp/{id}")
    public Employee deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
