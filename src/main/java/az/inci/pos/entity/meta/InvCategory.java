package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INV_CATEGORY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvCategory
{
    @Id
    @Column(name = "INV_CATEGORY_ID", nullable = false, length = 10)
    private String id;

    @Column(name = "INV_CATEGORY_NAME", length = 50)
    private String name;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvCategory that = (InvCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}