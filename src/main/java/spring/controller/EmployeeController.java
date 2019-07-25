package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.employee.entity.Employee;
import spring.employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/")
public class EmployeeController {

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
    public String showAdd() {
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("currentEmployee", employeeService.getEmployeeById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("currentEmployee", employeeService.getEmployeeById(id));
        return "delete";
    }

    @PostMapping("/add")
    public String insertEmployee(@ModelAttribute @Valid Employee newEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        newEmployee.setJoinedOn(new Date());
        employeeService.insertEmployee(newEmployee);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@Valid @ModelAttribute("editEmployee") Employee employee, @PathVariable(name = "id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/edit/{id}";
        }
        employee.setJoinedOn(new Date());
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@ModelAttribute("deleteEmployee") @PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
