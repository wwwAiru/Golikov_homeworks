package com.golikov;

import com.golikov.dao.DepartmentDao;
import com.golikov.dao.EmployeeDao;
import com.golikov.entity.Department;
import com.golikov.entity.Employee;
import com.golikov.entity.Role;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmployeeDao empDao = new EmployeeDao();

        System.out.println("*********************************** Find employee by ID ************************************");
        Optional<Employee> emp = empDao.findById(1);
        System.out.println(emp.get());
        System.out.println("\n");

        System.out.println("************************************ Find all employees ************************************");
        List<Employee> employees = empDao.findAll();
        System.out.println(employees);
        System.out.println("\n");

        System.out.println("******************************** Find employees by department *******************************");
        List<Employee> empsByDep = empDao.findEmpsByDepartmentName("IT");
        System.out.println(empsByDep);
        System.out.println("\n");

        System.out.println("***************************** find by salary greather then 1000 *****************************");
        List<Employee> empsBySalary = empDao.findBySalaryGreatherThen(1000);
        System.out.println(empsBySalary);
        System.out.println("\n");


        DepartmentDao depDao = new DepartmentDao();
        Optional<Employee> empUpd = empDao.findById(1);
        Department department = depDao.findByName("Sales");
        empUpd.get().setDepartment(department);
        empDao.save(empUpd.get());
        System.out.println("******************************************** Graph ******************************************");
        Department department2 = depDao.findByIdWithEmpsRoles(3);
        department2.getEmps().stream().map(Employee::getRoles).forEach(System.out::println);
        System.out.println("\n");







    }

}
