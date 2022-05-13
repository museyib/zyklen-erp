package az.inci.pos.repository;

import az.inci.pos.entity.meta.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String>
{
}
