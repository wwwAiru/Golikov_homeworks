package com.golikov.dao;


import com.golikov.entity.Department;
import com.golikov.entity.Employee;
import com.golikov.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class EmployeeDao {
    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Employee save(Employee emp) {
        EntityManager em = emf.createEntityManager();
        Employee newInstance;
        em.getTransaction().begin();
        if (emp.getId() == null) {
            em.persist(emp);
            newInstance = emp;
        } else {
            newInstance = em.merge(emp);
        }
        em.getTransaction().commit();
        return newInstance;
    }

    public Optional<Employee> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Employee res = em.find(Employee.class, id);
        return Optional.ofNullable(res);
    }

// criteria query
    public List<Employee> findEmpsByDepartmentName(String name) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        Join<Employee, Department> join = root.join("department");
        Predicate predicate = cb.and(cb.like(join.get("departmentName"), name));
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

// JPQL
    public List<Employee> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

// NamedQuery with parameter
    public List<Employee> findBySalaryGreatherThen(Integer salary) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee> query = em.createNamedQuery("salary_more", Employee.class);
        query.setParameter("salary", salary);
        return query.getResultList();
    }
}
