package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INV_BRAND")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvBrand
{
    @Id
    @Column(name = "INV_BRAND_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "INV_BRAND_NAME", length = 10)
    private String name;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvBrand invBrand = (InvBrand) o;
        return id != null && Objects.equals(id, invBrand.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}