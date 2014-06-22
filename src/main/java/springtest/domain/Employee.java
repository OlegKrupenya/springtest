package springtest.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3891233022773119495L;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="employee_id")
    private Long employeeId;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="age")
    private Short age;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")  
    private Set<Car> cars; 
    
    public Employee() {}
    
    
    
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Short getAge() {
        return age;
    }
    public void setAge(Short age) {
        this.age = age;
    }
    public Set<Car> getCars() {
        return cars;
    }
    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
