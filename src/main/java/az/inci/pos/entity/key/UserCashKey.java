package az.inci.pos.entity.key;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.meta.Cash;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserCashKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "CSH_CODE")
    private Cash cash;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCashKey that = (UserCashKey) o;
        return Objects.equals(bmsUser, that.bmsUser) && Objects.equals(cash, that.cash);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bmsUser, cash);
    }
}
