package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Currency
{
    @Id
    @Column(name = "CURR_CODE", nullable = false, length = 3)
    private String id;

    @Column(name = "CURR_NAME", length = 50)
    private String name;

    @Column(name = "CENT_NAME", length = 50)
    private String centName;

    @Column(name = "INACTIVE_FLAG", nullable = false)
    private boolean inactiveFlag;

    @OneToMany(mappedBy = "currency", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    private Set<Cash> cashes = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Currency currency = (Currency) o;
        return id != null && Objects.equals(id, currency.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}