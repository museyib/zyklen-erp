package az.inci.pos.repository;

import az.inci.pos.entity.WarehouseProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhsProfileRepository extends JpaRepository<WarehouseProfile, String>
{
}
