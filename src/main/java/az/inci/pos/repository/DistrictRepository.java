package az.inci.pos.repository;

import az.inci.pos.entity.meta.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, String>
{
}
