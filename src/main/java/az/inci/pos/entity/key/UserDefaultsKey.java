package az.inci.pos.entity.key;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.meta.BmsDynamicSettings;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserDefaultsKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private BmsUser user;

    @ManyToOne
    @JoinColumn(name = "KEY_NAME")
    private BmsDynamicSettings settings;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDefaultsKey that = (UserDefaultsKey) o;
        return Objects.equals(user, that.user) && Objects.equals(settings, that.settings);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(user, settings);
    }
}