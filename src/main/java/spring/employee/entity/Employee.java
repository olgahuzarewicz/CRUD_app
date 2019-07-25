package spring.employee.entity;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")

    @NotNull
    private Long empId;

    @NotEmpty(message="Name cannot be empty")
    private String name;

    private String departament;

    @Range(min=0, max=15000, message = "Salary must be in range (1 - 15000)")
    private Long salary;

    @Column(name = "JOINED_ON")
    private Date joinedOn;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    @Override
    public String toString() {
        return this.empId + " | " + this.name + " | " + this.departament + " | " + this.salary + " | " + this.joinedOn;
    }
}