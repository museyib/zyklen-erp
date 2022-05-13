package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_SEC_OBJECT_TYPE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsSecObjectType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEC_OBJECT_TYPE", nullable = false)
    private Integer id;

    @Column(name = "SEC_OBJECT_TYPE_DESC", length = 20)
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsSecObjectType that = (BmsSecObjectType) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}