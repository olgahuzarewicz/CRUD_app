package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.employee.entity.Employee;
import spring.employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private static final String HOME = "redirect:/";

    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getEmployees(Model model) {
        model.addAttribute("allEmployees", employeeService.getEmployeeList());
        return "employee";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("currentEmployee", employeeService.getEmployeeById(id));
        return "delete";
    }

    @PostMapping("/add")
    public String insertEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        employee.setJoinedOn(new Date());
        employeeService.insertEmployee(employee);
        return HOME;
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        employee.setJoinedOn(new Date());
        employeeService.updateEmployee(employee);
        return HOME;
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@ModelAttribute("deleteEmployee") @PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
        return HOME;
    }
}
