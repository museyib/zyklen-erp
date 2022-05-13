package az.inci.pos.repository;

import az.inci.pos.entity.meta.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, String>
{
}
