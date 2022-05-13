package az.inci.pos.entity.key;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.meta.Branch;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserBranchKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE")
    private Branch branch;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBranchKey that = (UserBranchKey) o;
        return Objects.equals(bmsUser, that.bmsUser) && Objects.equals(branch, that.branch);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bmsUser, branch);
    }
}