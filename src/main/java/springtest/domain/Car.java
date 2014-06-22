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
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((brandName == null) ? 0 : brandName.hashCode());
        result = prime * result + ((carId == null) ? 0 : carId.hashCode());
        result = prime * result
                + ((employee == null) ? 0 : employee.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (brandName == null) {
            if (other.brandName != null)
                return false;
        } else if (!brandName.equals(other.brandName))
            return false;
        if (carId == null) {
            if (other.carId != null)
                return false;
        } else if (!carId.equals(other.carId))
            return false;
        if (employee == null) {
            if (other.employee != null)
                return false;
        } else if (!employee.equals(other.employee))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        return true;
    }



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
