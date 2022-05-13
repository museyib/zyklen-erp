package az.inci.pos.repository;

import az.inci.pos.entity.meta.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, String>
{
}
