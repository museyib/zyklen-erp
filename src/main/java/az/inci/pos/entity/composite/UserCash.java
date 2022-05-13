package az.inci.pos.entity.composite;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.key.UserCashKey;
import az.inci.pos.entity.meta.Cash;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_USER_CSH")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserCash
{
    @EmbeddedId
    private UserCashKey userCashKey;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            referencedColumnName = "USER_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_CSH_BMS_USER"))
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "CSH_CODE",
            referencedColumnName = "CSH_CODE",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_CSH_CSH_MASTER"))
    private Cash cash;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCash userCash = (UserCash) o;
        return userCashKey != null && Objects.equals(userCashKey, userCash.userCashKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userCashKey);
    }
}