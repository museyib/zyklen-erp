package az.inci.pos.repository;

import az.inci.pos.entity.meta.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Cash, String>
{
}
