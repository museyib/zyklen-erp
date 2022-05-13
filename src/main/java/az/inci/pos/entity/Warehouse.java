package az.inci.pos.entity;

import az.inci.pos.entity.meta.Branch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "WHS_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Warehouse
{
    @Id
    @Column(name = "WHS_CODE", nullable = false, length = 5)
    private String id;

    @Column(name = "WHS_NAME", length = 50)
    private String name;

    @Column(name = "SHORT_NAME", length = 20)
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE",
            referencedColumnName = "BRANCH_CODE",
            foreignKey = @ForeignKey(name = "FK_WHS_MASTER_BRANCH"))
    private Branch branch;

    @Column(name = "PICKING_FLAG")
    private Boolean pickingFlag;

    @Column(name = "LOCATION_FLAG")
    private Boolean locationFlag;

    @Column(name = "FORBIDDEN_FLAG")
    private Boolean forbiddenFlag;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "FIRST_REC_USER", length = 15)
    private String createdBy;

    @Column(name = "FIRST_REC_DATE")
    private LocalDateTime createdAt;

    @Column(name = "FIRST_HOST_NAME", length = 15)
    private String createdHostName;

    @Column(name = "LAST_REC_USER", length = 15)
    private String modifiedBy;

    @Column(name = "LAST_REC_DATE")
    private LocalDateTime modifiedAt;

    @Column(name = "LAST_HOST_NAME", length = 15)
    private String modifiedHostName;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Warehouse warehouse = (Warehouse) o;
        return id != null && Objects.equals(id, warehouse.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}