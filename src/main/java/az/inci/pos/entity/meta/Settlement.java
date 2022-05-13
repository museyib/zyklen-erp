package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SETTLEMENT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Settlement
{
    @Id
    @Column(name = "SETTLEMENT_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "SETTLEMENT_NAME", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_CODE",
            referencedColumnName = "DISTRICT_CODE",
            foreignKey = @ForeignKey(name = "FK_SETTLEMENT_DISTRICT"))
    private District district;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_CODE",
            referencedColumnName = "PROVINCE_CODE",
            foreignKey = @ForeignKey(name = "FK_SETTLEMENT_PROVINCE"))
    private Province province;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_SETTLEMENT_COUNTRY"))
    private Country country;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Settlement that = (Settlement) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}