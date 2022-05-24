package dao;

import java.util.List;
import java.util.Optional;

public interface EmpDao<T> {

    List<T> findAllEmployees();

    List<T> findAllRolesByEmployeeId(int id);

    Optional<T> findEmployeeById(int id);


    Optional<T> findDepartmentByEmpID(int id);


}
