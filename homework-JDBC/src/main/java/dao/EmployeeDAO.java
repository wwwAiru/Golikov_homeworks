package dao;


import entity.Department;
import entity.Detail;
import entity.Employee;
import entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeDAO implements EmpDao {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String SELECT_ALL_EMPS = "SELECT * FROM employees e JOIN details d ON e.details_id = d.id";
    private static final String SELECT_EMP_BY_ID = "SELECT * FROM employees e JOIN details d ON e.details_id = d.id WHERE e.id = ?";
    private static final String SELECT_DEPARTMENT_BY_EMP_ID = "SELECT e.id AS e_id, e.department_id AS e_dep, e.name AS e_name, " +
                                                              "e.salary AS e_salary, e.surname AS e_surname, d.id AS d_id, d.name AS d_name, max_salary, min_salary " +
                                                              "FROM employees e " +
                                                              "JOIN departments d ON e.department_id=d.id " +
                                                              "WHERE e.id = ?";

    private static final String SELECT_ALL_ROLES_BY_EMP_ID = "SELECT roles.id AS roles_id, roles.name AS roles_name " +
                                                             "FROM employee_role " +
                                                             "JOIN roles ON employee_role.role_id=roles.id " +
                                                             "WHERE employee_role.employee_id = ?";

    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EmployeeDAO();
        }
        return instance;
    }

    public EmployeeDAO() {
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement pse = conn.createStatement();
            ResultSet re = pse.executeQuery(SELECT_ALL_EMPS);
            while (re.next()) {
                Employee employee = new Employee();
                Detail detail = new Detail();
                detail.setId(re.getInt("id"));
                detail.setCity(re.getString("city"));
                detail.setEmail(re.getString("email"));
                detail.setPhoneNumber(re.getString("phone_number"));
                employee.setId(re.getInt("id"));
                employee.setName(re.getString("name"));
                employee.setSurname(re.getString("surname"));
                employee.setSalary(re.getInt("salary"));
                employee.setEmpDetail(detail);
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public List<Role> findAllRolesByEmployeeId(int id) {
        List<Role> roles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement pse = conn.prepareStatement(SELECT_ALL_ROLES_BY_EMP_ID);
            pse.setInt(1, id);
            ResultSet result = pse.executeQuery();
            while (result.next()) {
                Role role = new Role();
                role.setId(result.getInt("roles_id"));
                role.setRoleName(result.getString("roles_name"));
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SELECT_EMP_BY_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Employee employee = new Employee();
                Detail detail = new Detail();
                detail.setId(result.getInt("id"));
                detail.setCity(result.getString("city"));
                detail.setEmail(result.getString("email"));
                detail.setPhoneNumber(result.getString("phone_number"));
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setSurname(result.getString("surname"));
                employee.setSalary(result.getInt("salary"));
                employee.setEmpDetail(detail);
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findDepartmentByEmpID(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SELECT_DEPARTMENT_BY_EMP_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Employee employee = new Employee();
                Department department = new Department();
                department.setId(result.getInt("d_id"));
                department.setDepartmentName(result.getString("d_name"));
                department.setMaxSalary(result.getInt("max_salary"));
                department.setMinSalary(result.getInt("min_salary"));
                employee.setId(result.getInt("e_id"));
                employee.setName(result.getString("e_name"));
                employee.setSurname(result.getString("e_surname"));
                employee.setSalary(result.getInt("e_salary"));
                employee.setDepartment(department);
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

