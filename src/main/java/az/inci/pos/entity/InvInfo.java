package az.inci.pos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inv_info")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INV_INFO_ID", nullable = false)
    private Integer id;


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvInfo invInfo = (InvInfo) o;
        return id != null && Objects.equals(id, invInfo.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}