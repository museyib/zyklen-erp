package az.inci.pos.repository;

import az.inci.pos.entity.auth.BmsRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<BmsRole, String>
{
}
