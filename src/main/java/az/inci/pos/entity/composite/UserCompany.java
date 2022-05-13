package az.inci.pos.entity.composite;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.key.UserCompanyKey;
import az.inci.pos.entity.meta.Company;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_USER_COMPANY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserCompany
{
    @EmbeddedId
    private UserCompanyKey id;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            referencedColumnName = "USER_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_COMPANY_BMS_USER"))
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "CC",
            referencedColumnName = "CC",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_COMPANY_COMPANY"))
    private Company company;

    @Column(name = "DEFAULT_FLAG")
    private Boolean defaultFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCompany that = (UserCompany) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}