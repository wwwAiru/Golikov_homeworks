package dao;

import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoleDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static RoleDAO instance;
    private static final String SELECT_ALL_EMPS_BY_ROLE_ID = "select e.id AS id, e.name AS name, e.salary AS salary, e.surname AS surname from employee_role er join employees e on er.employee_id=e.id where er.role_id = ?";

    public static RoleDAO getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RoleDAO();
        }
        return instance;
    }

    public RoleDAO() {
    }

    public List<Employee> findAllEmployeesByRole(int id) {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPS_BY_ROLE_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setSurname(result.getString("surname"));
                employee.setSalary(result.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    }
