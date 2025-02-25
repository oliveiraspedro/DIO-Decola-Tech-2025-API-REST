package dio.aula_spring_data_jpa.Repository;

import dio.aula_spring_data_jpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
