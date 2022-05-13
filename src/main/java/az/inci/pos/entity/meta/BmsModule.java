package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "BMS_MODULE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsModule
{
    @Id
    @Column(name = "MODULE_ID", nullable = false)
    private String id;

    @Column(name = "MODULE_CAPTION", length = 30)
    private String name;

    @Column(name = "ORDERING", nullable = false)
    private int ordering;

    @Column(name = "SHOWCAPTION")
    private Boolean showCaption;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsModule bmsModule = (BmsModule) o;
        return id != null && Objects.equals(id, bmsModule.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}