package com.golikov.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "departments")
@NamedQuery(name = "find_by_name",
        query = "SELECT e FROM Employee e WHERE e.salary > :salary")
@NamedEntityGraph(name = "employees_roles_graph",
                  attributeNodes = @NamedAttributeNode(value = "emps", subgraph = "emp_roles"),
                  subgraphs = @NamedSubgraph(name = "emp_roles",
                  attributeNodes = {@NamedAttributeNode("roles")}))
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String departmentName;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Column(name = "min_salary")
    private Integer minSalary;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Employee> emps;

    public Department() {
    }

    public Department(String departmentName, Integer maxSalary, Integer minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void AddEmployeeToDepartment(Employee employee) {
        if (emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDepartment(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
