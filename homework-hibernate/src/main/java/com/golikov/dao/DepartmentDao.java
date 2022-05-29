package com.golikov.dao;

import com.golikov.entity.Department;
import com.golikov.entity.Employee;
import com.golikov.entity.Role;
import com.golikov.util.EmfUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.*;

public class DepartmentDao {
    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

// JPQL
    public Department findByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM Department d WHERE d.departmentName = :name");
        query.setParameter("name", name);
        return (Department) query.getResultList().get(0);
    }

    public Department findByIdWithEmpsRoles(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityGraph entityGraph = em.createEntityGraph("employees_roles_graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Department res = em.find(Department.class, id, properties);
        return res;
    }
    
}
