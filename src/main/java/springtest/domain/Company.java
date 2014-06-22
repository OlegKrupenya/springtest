/**
 * 
 */
package springtest.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author oleg.krupenya
 *
 */
@Entity
@Table(name="companies")
public class Company implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7287658308230427384L;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="company_id")
    private Long companyId;
    
    @Column(name="company_name")
    private String companyName;
    
    @Column(name="city")
    private String city;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "employee_company", joinColumns = { @JoinColumn(name = "company_id") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
    private Set<Employee> employees;

    public Company () {}
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result
                + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result
                + ((companyName == null) ? 0 : companyName.hashCode());
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
        Company other = (Company) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (companyId == null) {
            if (other.companyId != null)
                return false;
        } else if (!companyId.equals(other.companyId))
            return false;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        return true;
    }



    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    public Long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
}
