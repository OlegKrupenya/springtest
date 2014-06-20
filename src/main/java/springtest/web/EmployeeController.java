package springtest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springtest.domain.Employee;
import springtest.services.EmployeeService;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/hello")
    public String hello(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }
    

    @RequestMapping("/getAll")
    public String getAllEmployees(
            ModelMap model) {
        List<Employee> employees = this.employeeService.getEmployees();
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employees);
        return "employeesList";
    }
    
    @RequestMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result,
    Model model) {
        this.employeeService.addEmployee(employee);
        model.addAttribute("employee", employee);
        return "forward:/employeesList";
    }
    
    @RequestMapping("/add")
    public String addEmployeeFromInit(@ModelAttribute("employee") Employee employee, BindingResult result,
    Model model) {
        model.addAttribute("employee", new Employee());
        return "addNewEmployee";
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
