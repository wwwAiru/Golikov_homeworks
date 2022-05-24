import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.RoleDAO;
import entity.Department;
import entity.Employee;
import entity.Role;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO ed = EmployeeDAO.getInstance();
        DepartmentDAO dd = DepartmentDAO.getInstance();
        RoleDAO rd = RoleDAO.getInstance();

        List<Employee> employees = ed.findAllEmployees();

        Optional<Employee> employee = ed.findEmployeeById(3);

        Optional<Department> depEmployees = dd.findEmployeesByDepId(2);
        List<Employee> lstEmps = depEmployees.get().getEmps();

        Optional<Employee> empFromDep = ed.findDepartmentByEmpID(1);

        List<Role> roles = ed.findAllRolesByEmployeeId(3);

        List<Employee> roleEmps = rd.findAllEmployeesByRole(2);

        System.out.println("********************************************************************************************");
        System.out.println("Пример связи один к одному, вывод сотрудников + детальная информация по каждому.");
        System.out.println(employees);
        System.out.println("********************************************************************************************");
        System.out.println("Вывод сотрудника + детали по id");
        System.out.println(employee);
        System.out.println("********************************************************************************************");
        System.out.println("Пример связи один ко многим, вывод сотрудников по id департамента");
        System.out.println(lstEmps);
        System.out.println("********************************************************************************************");
        System.out.println("Пример многие к одному, вывод департамента по id сотрудника");
        System.out.println(empFromDep.get().getName() +" "+ empFromDep.get().getSurname() +" "+empFromDep.get().getDepartment());
        System.out.println("********************************************************************************************");
        System.out.println("Сотрудник может иметь много ролей, роль может быть у множества сотрудников");
        System.out.println("Вывод ролей по id сотрудника");
        System.out.println(roles);
        System.out.println("Вывод сотрудников с role_id = 2");
        System.out.println(roleEmps);

    }
}
