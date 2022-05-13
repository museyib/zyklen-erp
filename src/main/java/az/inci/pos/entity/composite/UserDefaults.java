package az.inci.pos.entity.composite;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.key.UserDefaultsKey;
import az.inci.pos.entity.meta.BmsDynamicSettings;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_USER_DEFAULTS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDefaults
{
    @EmbeddedId
    private UserDefaultsKey primaryKey;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            referencedColumnName = "USER_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_DEFAULTS_BMS_USER"))
    private BmsUser user;

    @ManyToOne
    @JoinColumn(name = "KEY_NAME",
            referencedColumnName = "KEY_NAME",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_DEFAULTS_BMS_DYNAMIC_SETTINGS"))
    private BmsDynamicSettings settings;

    @Column(name = "KEY_VALUE", length = 200)
    private String keyValue;

    @Column(name = "description", length = 50)
    private String description;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserDefaults that = (UserDefaults) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(primaryKey);
    }
}