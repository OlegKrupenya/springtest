package springtest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springtest.dao.IEmployeeDao;
import springtest.domain.Employee;

@Service
public class EmployeeService {
	
    @Autowired
	private IEmployeeDao employeeDao;
	
    @Transactional
	public List<Employee> getEmployees() {
		return this.employeeDao.getEmployees();
	}
    @Transactional
	public Employee getEmployeeById(Long employeeId) {
		return this.employeeDao.getEmployeeById(employeeId);
	}
    @Transactional(rollbackFor = NullPointerException.class)
	public Employee addEmployee(Employee employeeToAdd) {
		return this.employeeDao.addEmployee(employeeToAdd);
	}
    @Transactional
	public boolean updateEmployee(Employee employeeToUpdate) {
		return this.employeeDao.updateEmployee(employeeToUpdate);
	}
    @Transactional
	public boolean deleteEmployee(Employee employeeToDelete) {
		return this.employeeDao.deleteEmployee(employeeToDelete);
	}

	public IEmployeeDao getEmployeDao() {
		return employeeDao;
	}

	public void setEmployeDao(IEmployeeDao employeDao) {
		this.employeeDao = employeDao;
	}
}
