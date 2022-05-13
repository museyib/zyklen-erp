package az.inci.pos.entity.meta;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.key.BmsFormKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "BMS_FORM_LOCKS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsFormLocks
{
    @EmbeddedId
    private BmsFormKey primaryKey;

    @ManyToOne
    @JoinColumn(name = "FORM_ID",
            referencedColumnName = "FORM_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_LOCKS_BMS_FORM"))
    private BmsForm bmsForm;

    @Column(name = "FORM_VALUE", length = 50)
    private String formValue;

    @Column(name = "LOCK_TYPE", nullable = false)
    private int lockType;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            referencedColumnName = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_LOCKS_BMS_USER"))
    private BmsUser bmsUser;

    @Column(name = "LOCK_DATE")
    private LocalDateTime lockDate;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsFormLocks that = (BmsFormLocks) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(primaryKey);
    }
}