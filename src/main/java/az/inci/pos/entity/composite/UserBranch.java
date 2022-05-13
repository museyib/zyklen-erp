package az.inci.pos.entity.composite;

import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.entity.key.UserBranchKey;
import az.inci.pos.entity.meta.Branch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_USER_BRANCH")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserBranch
{
    @EmbeddedId
    private UserBranchKey primaryKey;

    @ManyToOne
    @JoinColumn(name = "USER_ID",
            referencedColumnName = "USER_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_BRANCH_BMS_USER"))
    private BmsUser bmsUser;

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE",
            referencedColumnName = "BRANCH_CODE",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_USER_BRANCH_BRANCH"))
    private Branch branch;

    @Column(name = "DEFAULT_FLAG")
    private Boolean defaultFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserBranch that = (UserBranch) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(primaryKey);
    }
}