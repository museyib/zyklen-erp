package az.inci.pos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WHS_PROFILE_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class WarehouseProfile
{
    @Id
    @Column(name = "WHS_PROFILE_CODE", nullable = false)
    private String id;

    @Column(name = "WHS_PROFILE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "WHS_CODE",
            referencedColumnName = "WHS_CODE",
            foreignKey = @ForeignKey(name = "FK_WHS_PROFILE_MASTER_WHS_MASTER"))
    private Warehouse warehouse;

    @Column(name = "DEFAULT_FACTOR", nullable = false)
    private double defaultFactor;

    @Column(name = "inactive_flag")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WarehouseProfile that = (WarehouseProfile) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}