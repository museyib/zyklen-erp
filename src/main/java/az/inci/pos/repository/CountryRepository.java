package az.inci.pos.repository;

import az.inci.pos.entity.meta.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String>
{
}
