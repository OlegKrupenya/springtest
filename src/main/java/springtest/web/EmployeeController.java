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

    @RequestMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result,
    Model model) {
        this.employeeService.addEmployee(employee);
        return "redirect:/getAll";
    }
    
    @RequestMapping("/add")
    public String addEmployeeFromInit(@ModelAttribute("employee") Employee employee, BindingResult result,
    Model model) {
        model.addAttribute("employee", new Employee());
        return "addNewEmployee";
    }
    
    @RequestMapping("/editEmployee")
    public String editEmployee(@ModelAttribute("employee") Employee employee, BindingResult result,
    Model model) {
        this.employeeService.updateEmployee(employee);
        return "redirect:/getAll";
    }
    
    @RequestMapping("/edit")
    public String editEmployeeFromInit(@RequestParam(value = "id", required = true) String[] id, 
    Model model) {
        Long employeeId = Long.parseLong(id[0]);
        Employee employee = this.employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "editEmployee";
    }
    
    @RequestMapping("/delete")
    public String deleteEmployees(@RequestParam(value = "id", required = true) String[] id) {
        for (String s : id) {
            Long employeeId = Long.parseLong(s);
            Employee employee = this.employeeService.getEmployeeById(employeeId);
            this.employeeService.deleteEmployee(employee);
        }
        return "redirect:/getAll";
    }
    
    @RequestMapping("/getAll")
    public String getAllEmployees(
            ModelMap model) {
        List<Employee> employees = this.employeeService.getEmployees();
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employees);
        return "employeesList";
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
