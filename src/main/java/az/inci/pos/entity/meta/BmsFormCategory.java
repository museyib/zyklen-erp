package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "BMS_FORM_CATEGORY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsFormCategory
{
    @Id
    @Column(name = "FORM_CATEGORY", nullable = false)
    private Integer id;

    @Column(name = "CATEGORY_DESC", length = 20)
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsFormCategory that = (BmsFormCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}