package az.inci.pos.entity.composite;

import az.inci.pos.entity.key.BranchCompanyKey;
import az.inci.pos.entity.meta.Branch;
import az.inci.pos.entity.meta.Company;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BRANCH_COMPANY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BranchCompany
{
    @EmbeddedId
    private BranchCompanyKey primaryKey;

    @ManyToOne
    @JoinColumn(name = "CC",
            referencedColumnName = "CC",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BRANCH_COMPANY_COMPANY"))
    private Company company;

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE",
            referencedColumnName = "BRANCH_CODE",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BRANCH_COMPANY_BRANCH"))
    private Branch branch;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BranchCompany that = (BranchCompany) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(primaryKey);
    }
}