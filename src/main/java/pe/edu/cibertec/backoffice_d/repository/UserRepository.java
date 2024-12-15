package pe.edu.cibertec.backoffice_d.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.backoffice_d.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}