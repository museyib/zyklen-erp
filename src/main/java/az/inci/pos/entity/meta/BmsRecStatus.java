package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_REC_STATUS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsRecStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_STATUS", nullable = false)
    private Integer id;

    @Column(name = "REC_STATUS_DESC", length = 20)
    private String name;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsRecStatus that = (BmsRecStatus) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}