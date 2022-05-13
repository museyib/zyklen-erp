package az.inci.pos.repository;

import az.inci.pos.entity.meta.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String>
{
}
