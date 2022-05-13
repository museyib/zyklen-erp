package az.inci.pos.repository;

import az.inci.pos.entity.auth.BmsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BmsUser, String>
{
}