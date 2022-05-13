package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INV_GROUP")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InvGroup
{
    @Id
    @Column(name = "INV_GROUP_ID", nullable = false, length = 10)
    private String id;

    @Column(name = "INV_GROUP_DESC", length = 50)
    private String name;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @ManyToOne
    @JoinColumn(name = "INV_CATEGORY_ID",
            referencedColumnName = "INV_CATEGORY_ID",
            foreignKey = @ForeignKey(name = "FK_INV_GROUP_CATEGORY"))
    private InvCategory invCategory;

    @ManyToOne
    @JoinColumn(name = "PARENT_GROUP_ID",
            referencedColumnName = "INV_GROUP_ID",
            foreignKey = @ForeignKey(name = "FK_INV_GROUP_INV_GROUP"))
    private InvGroup parentInvGroup;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvGroup invGroup = (InvGroup) o;
        return id != null && Objects.equals(id, invGroup.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}