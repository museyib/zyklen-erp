package az.inci.pos.repository;

import az.inci.pos.entity.TrxType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrxTypeRepository extends JpaRepository<TrxType, Integer>
{
}
