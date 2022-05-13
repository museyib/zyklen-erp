package az.inci.pos.entity.meta;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CSH_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cash
{
    @Id
    @Column(name = "CSH_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "CSH_NAME", length = 50)
    private String name;

    @Column(name = "SHORT_NAME", length = 20)
    private String shortName;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "FIRST_REC_USER", length = 15)
    private String createdBy;

    @Column(name = "FIRST_REC_DATE")
    private LocalDateTime createdAt;

    @Column(name = "FIRST_HOST_NAME", length = 15)
    private String createdHost;

    @Column(name = "LAST_REC_USER", length = 15)
    private String modifiedBy;

    @Column(name = "LAST_REC_DATE")
    private LocalDateTime modifiedAt;

    @Column(name = "LAST_HOST_NAME", length = 15)
    private String modifiedHost;

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE",
            referencedColumnName = "BRANCH_CODE",
            foreignKey = @ForeignKey(name = "FK_CSH_MASTER_BRANCH"))
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "CURR_CODE",
            referencedColumnName = "CURR_CODE",
            foreignKey = @ForeignKey(name = "FK_CSH_MASTER_CURR"))
    private Currency currency;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cash cash = (Cash) o;
        return id != null && Objects.equals(id, cash.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}