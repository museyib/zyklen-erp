package az.inci.pos.repository;

import az.inci.pos.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, String>
{
}
