package spring.employee.repository;

import org.springframework.stereotype.Repository;
import spring.employee.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> getEmployeeList() {
        String queryStr = "select emp from Employee emp";
        TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return entityManager.find(Employee.class, empId);
    }

    @Override
    public Employee insertEmployee(Employee emp) {
        entityManager.persist(emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        entityManager.merge(emp);
        return emp;
    }

    @Override
    public Employee deleteEmployee(Long empId) {
        Employee emp = entityManager.find(Employee.class, empId);
        if (entityManager.contains(emp)) {
            entityManager.remove(emp);
        }
        return emp;
    }
}
