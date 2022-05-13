package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UOM")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Uom
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "UOM", length = 10)
    private String uom;

    @Column(name = "UNIT_NAME", length = 20)
    private String unitName;

    @ManyToOne
    @JoinColumn(name = "BASE_UOM",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_UOM_UOM"))
    private Uom baseUom;

    @Column(name = "FACTOR", nullable = false)
    private double factor;

    @Column(name = "DINAMIC_FLAG")
    private Boolean dynamicFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uom uom = (Uom) o;
        return id != null && Objects.equals(id, uom.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}