package dao;

import entity.Department;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DepartmentDAO implements DepDao{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String SELECT_ALL_EMPS_BY_DEPARTMENT_ID = "SELECT department_id, id, name, surname, salary " +
                                                                   "FROM employees " +
                                                                   "WHERE department_id = ?";

    private static final String SELECT_DEPARTMENT_BY_ID = "SELECT * FROM departments WHERE id = ?";
    private static DepartmentDAO instance;

    public static DepartmentDAO getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DepartmentDAO();
        }
        return instance;
    }


    @Override
    public Optional<Department> findEmployeesByDepId(int id) {
        List<Employee> depEmployees = new ArrayList<>();
        Department department = findDepartmentById(id);
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPS_BY_DEPARTMENT_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setSurname(result.getString("surname"));
                employee.setSalary(result.getInt("salary"));
                employee.setDepartment(department);
                depEmployees.add(employee);
            }
            department.setEmps(depEmployees);
            return Optional.of(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Department findDepartmentById(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SELECT_DEPARTMENT_BY_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Department department = new Department();
                department.setId(result.getInt("id"));
                department.setDepartmentName(result.getString("name"));
                department.setMaxSalary(result.getInt("max_salary"));
                department.setMinSalary(result.getInt("min_salary"));
                return department;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
