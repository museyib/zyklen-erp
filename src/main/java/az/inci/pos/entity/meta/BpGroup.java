package az.inci.pos.entity.meta;

import az.inci.pos.entity.Bp;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BP_GROUP")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BpGroup
{
    @Id
    @Column(name = "BP_GROUP_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "DESCRIPTION", length = 50)
    private String name;

    @OneToMany(mappedBy = "bpGroup", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @ToString.Exclude
    private Set<Bp> bpList = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BpGroup bpGroup = (BpGroup) o;
        return id != null && Objects.equals(id, bpGroup.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}