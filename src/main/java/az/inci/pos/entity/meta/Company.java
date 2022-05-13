package az.inci.pos.entity.meta;

import az.inci.pos.entity.composite.BranchCompany;
import az.inci.pos.entity.composite.UserCompany;
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
@Table(name = "COMPANY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Company
{
    @Id
    @Column(name = "CC", nullable = false)
    private String id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "FIRST_REC_USER", length = 15)
    private String createdBy;

    @Column(name = "FIRST_REC_DATE")
    private LocalDateTime createdAt;

    @Column(name = "FIRST_HOST_NAME", length = 15)
    private String createdHostName;

    @Column(name = "LAST_REC_USER", length = 15)
    private String modifiedBy;

    @Column(name = "LAST_REC_DATE")
    private LocalDateTime modifiedAt;

    @Column(name = "LAST_HOST_NAME", length = 15)
    private String modifiedHostName;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_COMPANY_COUNTRY"))
    private Country country;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<BranchCompany> branches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<UserCompany> userCompanies = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return id != null && Objects.equals(id, company.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}