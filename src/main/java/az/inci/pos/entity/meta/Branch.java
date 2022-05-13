package az.inci.pos.entity.meta;

import az.inci.pos.entity.Bp;
import az.inci.pos.entity.composite.BranchCompany;
import az.inci.pos.entity.composite.UserBranch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BRANCH")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Branch
{
    @Id
    @Column(name = "BRANCH_CODE", nullable = false, length = 3)
    private String id;

    @Column(name = "BRANCH_NAME", length = 50)
    private String name;

    @Column(name = "SHORT_NAME", length = 20)
    private String shortName;

    @Column(name = "ADDRESS1", length = 50)
    private String address1;

    @Column(name = "ADDRESS2", length = 50)
    private String address2;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_BRANCH_COUNTRY"))
    private Country country;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_CODE",
            referencedColumnName = "PROVINCE_CODE",
            foreignKey = @ForeignKey(name = "FK_BRANCH_PROVINCE"))
    private Province province;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_CODE",
            referencedColumnName = "DISTRICT_CODE",
            foreignKey = @ForeignKey(name = "FK_BRANCH_DISTRICT"))
    private District district;

    @Column(name = "ZIP", length = 5)
    private String zip;

    @Column(name = "PHONE1", length = 13)
    private String phone1;

    @Column(name = "PHONE2", length = 13)
    private String phone2;

    @Column(name = "PHONE3", length = 13)
    private String phone3;

    @Column(name = "PHONE4", length = 13)
    private String phone4;

    @Column(name = "FAX1", length = 13)
    private String fax1;

    @Column(name = "FAX2", length = 13)
    private String fax2;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "WEB", length = 50)
    private String web;

    @Column(name = "FIRST_REC_USER", length = 15)
    private String createdBy;

    @Column(name = "FIRST_REC_DATE")
    private LocalDateTime createdAt;

    @Column(name = "FIRST_HOST_NAME", length = 50)
    private String createdHostName;

    @Column(name = "LAST_REC_USER", length = 15)
    private String modifiedBy;

    @Column(name = "LAST_REC_DATE")
    private LocalDateTime modifiedAt;

    @Column(name = "LAST_HOST_NAME", length = 50)
    private String modifiedHostName;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @OneToMany(mappedBy = "branch",
            cascade = {CascadeType.PERSIST,
                       CascadeType.MERGE,
                       CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Bp> bpList = new LinkedHashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<BranchCompany> companies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<UserBranch> users = new LinkedHashSet<>();

    @OneToMany(mappedBy = "branch",
            cascade = {CascadeType.PERSIST,
                       CascadeType.MERGE,
                       CascadeType.REFRESH},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Cash> cashes = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Branch branch = (Branch) o;
        return id != null && Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}