package az.inci.pos.entity.meta;

import az.inci.pos.entity.Bp;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BP_STATUS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BpStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BP_STATUS_ID", nullable = false)
    private Integer id;

    @Column(name = "BP_STATUS_DESC", length = 30)
    private String name;

    @OneToMany(mappedBy = "bpStatus", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @ToString.Exclude
    private Set<Bp> bpList = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BpStatus bpStatus = (BpStatus) o;
        return id != null && Objects.equals(id, bpStatus.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}