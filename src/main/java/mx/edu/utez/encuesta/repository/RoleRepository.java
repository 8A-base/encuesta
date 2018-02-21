package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRole(String role);
}
