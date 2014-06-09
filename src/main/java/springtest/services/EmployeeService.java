package springtest.services;

import java.util.List;

import springtest.dao.IEmployeeDao;
import springtest.domain.Employee;

public class EmployeeService {
	
	private IEmployeeDao employeeDao;
	
	public List<Employee> getEmployees() {
		return this.employeeDao.getEmployees();
	}
	public Employee getEmployeeById(Long employeeId) {
		return this.employeeDao.getEmployeeById(employeeId);
	}
	public Employee addEmployee(Employee employeeToAdd) {
		return this.addEmployee(employeeToAdd);
	}
	
	public boolean updateEmployee(Employee employeeToUpdate) {
		return this.updateEmployee(employeeToUpdate);
	}
	
	public boolean deleteEmployee(Employee employeeToDelete) {
		return this.deleteEmployee(employeeToDelete);
	}

	public IEmployeeDao getEmployeDao() {
		return employeeDao;
	}

	public void setEmployeDao(IEmployeeDao employeDao) {
		this.employeeDao = employeDao;
	}
}
