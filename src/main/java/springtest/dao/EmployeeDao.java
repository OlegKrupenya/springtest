package springtest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springtest.domain.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao {
    
    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
    @Override
	public List<Employee> getEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return (Employee) this.sessionFactory.getCurrentSession().get(Employee.class, employeeId);
	}

	@Override
	public Employee addEmployee(Employee employeeToAdd) {
	    Long employeeId = (Long) this.sessionFactory.getCurrentSession().save(employeeToAdd);
	    employeeToAdd.setEmployeeId(employeeId);
		return employeeToAdd;
	}

	@Override
	public boolean updateEmployee(Employee employeeToUpdate) {
		try {
		    this.sessionFactory.getCurrentSession().update(employeeToUpdate);
		    return true;
		} catch (Exception e) {
		    return false;
		}
	}

	@Override
	public boolean deleteEmployee(Employee employeeToDelete) {
	    try {
            this.sessionFactory.getCurrentSession().delete(employeeToDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
