package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PROVINCE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Province
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PROVINCE_NAME", length = 50)
    private String name;

    @Id
    @Column(name = "PROVINCE_CODE", length = 2)
    private String provinceCode;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_PROVINCE_COUNTRY"))
    private Country country;

    @OneToMany(mappedBy = "province", cascade = {CascadeType.PERSIST,
                                                 CascadeType.MERGE,
                                                 CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<District> districts = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Province province = (Province) o;
        return id != null && Objects.equals(id, province.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}