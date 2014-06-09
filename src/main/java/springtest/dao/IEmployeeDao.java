package springtest.dao;

import java.util.List;

import springtest.domain.Employee;

public interface IEmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(Long employeeId);
	public Employee addEmployee(Employee employeeToAdd);
	public boolean updateEmployee(Employee employeeToUpdate);
	public boolean deleteEmployee(Employee employeeToDelete);
}
