package az.inci.pos.entity.meta;

import az.inci.pos.entity.Bp;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BP_TYPE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BpType
{
    @Id
    @Column(name = "BP_TYPE_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "DESCRIPTION", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CC",
            referencedColumnName = "CC",
            foreignKey = @ForeignKey(name = "FK_BP_TYPE_COMPANY"))
    private Company company;

    @OneToMany(mappedBy = "bpType", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @ToString.Exclude
    private Set<Bp> bpList = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BpType bpType = (BpType) o;
        return id != null && Objects.equals(id, bpType.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}