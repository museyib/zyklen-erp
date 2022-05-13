package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DISTRICT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class District
{
    @Id
    @Column(name = "DISTRICT_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "DISTRICT_NAME", length = 10)
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_DISTRICT_COUNTRY"))
    private Country country;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_CODE",
            referencedColumnName = "PROVINCE_CODE",
            foreignKey = @ForeignKey(name = "FK_DISTRICT_PROVINCE"))
    private Province province;

    @OneToMany(mappedBy = "province", cascade = {CascadeType.PERSIST,
                                                 CascadeType.MERGE,
                                                 CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Settlement> settlements = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        District district = (District) o;
        return id != null && Objects.equals(id, district.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}