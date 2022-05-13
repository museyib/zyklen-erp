package az.inci.pos.repository;

import az.inci.pos.entity.meta.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMethodRepository extends JpaRepository<PayMethod, String>
{
}
