package sebeikapranas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sebeikapranas.backend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByType(String Type);
}
