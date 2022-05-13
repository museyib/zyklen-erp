package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Country
{
    @Id
    @Column(name = "COUNTRY", nullable = false, length = 3)
    private String id;

    @Column(name = "COUNTRY_NAME", length = 50)
    private String name;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST,
                                                CascadeType.MERGE,
                                                CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Province> provinces = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country country = (Country) o;
        return id != null && Objects.equals(id, country.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}