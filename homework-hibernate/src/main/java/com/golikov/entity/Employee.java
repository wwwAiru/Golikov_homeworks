package com.golikov.entity;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedQuery(name = "salary_more",
            query = "SELECT e FROM Employee e WHERE e.salary > :salary"
)
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Detail empDetail;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_role",
               joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Embedded
    private Audit audit = new Audit();

    public Employee() {
    }

    public Employee(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRolesToEmployee(Role role) {
        if (role == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", empDetail=" + empDetail +
                '}';
    }
}
