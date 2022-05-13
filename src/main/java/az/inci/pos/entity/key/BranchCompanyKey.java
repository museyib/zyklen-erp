package az.inci.pos.entity.key;

import az.inci.pos.entity.meta.Branch;
import az.inci.pos.entity.meta.Company;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BranchCompanyKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "CC")
    private Company company;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchCompanyKey that = (BranchCompanyKey) o;
        return Objects.equals(branch, that.branch) && Objects.equals(company, that.company);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(branch, company);
    }
}