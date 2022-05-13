package az.inci.pos.entity.key;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.meta.Company;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserCompanyKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "CC")
    private Company company;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCompanyKey that = (UserCompanyKey) o;
        return Objects.equals(bmsUser, that.bmsUser) && Objects.equals(company, that.company);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bmsUser, company);
    }
}