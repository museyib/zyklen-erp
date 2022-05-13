package az.inci.pos.entity.meta;

import az.inci.pos.entity.auth.BmsUser;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BMS_USER_GROUP")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsUserGroup
{
    @Id
    @Column(name = "USER_GROUP_ID", nullable = false, length = 15)
    private String id;

    @Column(name = "USER_GROUP_NAME", length = 50)
    private String name;

    @OneToMany(mappedBy = "bmsUserGroup", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @ToString.Exclude
    private Set<BmsUser> bmsUsers = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsUserGroup that = (BmsUserGroup) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}