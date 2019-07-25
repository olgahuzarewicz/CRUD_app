package spring.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.employee.entity.Employee;
import spring.employee.repository.EmployeeDao;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeesDao;

    @Override
    public List<Employee> getEmployeeList() {
        return this.employeesDao.getEmployeeList();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return this.employeesDao.getEmployeeById(empId);
    }

    @Override
    public Employee insertEmployee(Employee emp) {
        return this.employeesDao.insertEmployee(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return this.employeesDao.updateEmployee(emp);
    }

    @Override
    public Employee deleteEmployee(Long empId) {
        return this.employeesDao.deleteEmployee(empId);
    }
}
