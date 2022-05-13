package az.inci.pos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BP_CHAIN")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BpChain
{
    @Id
    @Column(name = "BP_CHAIN_CODE", nullable = false, length = 15)
    private String id;

    @Column(name = "BP_CHAIN_NAME", length = 100)
    private String name;

    @OneToMany(mappedBy = "bpChain", cascade = {CascadeType.PERSIST,
                                                CascadeType.MERGE,
                                                CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Bp> bpList = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BpChain bpChain = (BpChain) o;
        return id != null && Objects.equals(id, bpChain.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}