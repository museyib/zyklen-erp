package az.inci.pos.entity.auth;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BMS_ROLE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsRole
{
    @Id
    @Column(name = "ROLE_ID", nullable = false, length = 30)
    private String id;

    @Column(name = "ROLE_DESC", length = 100)
    private String name;

//    @OneToMany(mappedBy = "bmsRole", orphanRemoval = true, cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private Set<UserRole> users = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "bmsRoles")
    private Set<BmsUser> bmsUsers = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsRole bmsRole = (BmsRole) o;
        return id != null && Objects.equals(id, bmsRole.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}