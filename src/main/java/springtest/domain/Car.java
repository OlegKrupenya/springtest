/**
 * 
 */
package springtest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author oleg.krupenya
 *
 */
@Entity
@Table(name="cars")
public class Car implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4976519783204292460L;
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="car_id")
    private Long carId;
    
    @Column(name = "brand_name")
    private String brandName;
    
    @Column(name = "model")
    private String model;
    
    @ManyToOne 
    @JoinColumn(name = "employee_id") 
    private Employee employee;
    
    public Car () {}
    

    



    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
