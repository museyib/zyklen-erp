package az.inci.pos.repository;

import az.inci.pos.entity.meta.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String>
{
}
