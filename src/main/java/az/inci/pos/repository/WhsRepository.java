package az.inci.pos.repository;

import az.inci.pos.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhsRepository extends JpaRepository<Warehouse, String>
{
}
