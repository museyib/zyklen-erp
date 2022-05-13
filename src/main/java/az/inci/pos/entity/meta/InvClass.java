package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INV_CLASS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvClass
{
    @Id
    @Column(name = "INV_CLASS", nullable = false, length = 3)
    private String id;

    @Column(name = "INV_CLASS_DESC", length = 30)
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvClass invClass = (InvClass) o;
        return id != null && Objects.equals(id, invClass.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}