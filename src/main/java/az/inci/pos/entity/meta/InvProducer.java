package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INV_PRODUCER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvProducer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCER_CODE", nullable = false)
    private Integer id;

    @Column(name = "PRODUCER_NAME", length = 30)
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvProducer that = (InvProducer) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}