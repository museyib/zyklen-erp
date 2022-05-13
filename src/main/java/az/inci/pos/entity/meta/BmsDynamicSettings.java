package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "BMS_DYN_SETTINGS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsDynamicSettings
{
    @Id
    @Column(name = "KEY_NAME", nullable = false, length = 50)
    private String keyName;

    @Column(name = "KEY_VALUE", length = 200)
    private String keyValue;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "KEY_CATEGORY", length = 3)
    private String keyCategory;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsDynamicSettings that = (BmsDynamicSettings) o;
        return keyName != null && Objects.equals(keyName, that.keyName);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}