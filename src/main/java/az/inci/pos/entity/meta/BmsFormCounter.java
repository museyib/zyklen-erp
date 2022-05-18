package az.inci.pos.entity.meta;

import az.inci.pos.entity.key.BmsFormKey;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_FORM_COUNTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsFormCounter
{
    @EmbeddedId
    private BmsFormKey primaryKey;

    @OneToOne
    @JoinColumn(name = "FORM_ID",
            referencedColumnName = "FORM_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_COUNTER_BMS_FORM"))
    private BmsForm bmsForm;

    @Column(name = "FORM_CNT", nullable = false)
    private int formCount;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsFormCounter that = (BmsFormCounter) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(primaryKey);
    }
}