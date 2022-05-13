package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INV_TYPE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INV_TYPE", nullable = false)
    private Integer id;

    @Column(name = "INV_TYPE_DESC", length = 30)
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvType invType = (InvType) o;
        return id != null && Objects.equals(id, invType.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}