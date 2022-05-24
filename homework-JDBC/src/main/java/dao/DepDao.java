package dao;

import java.util.Optional;

public interface DepDao<T> {

    Optional<T> findEmployeesByDepId(int id);

}
