package az.inci.pos.entity.auth;

import az.inci.pos.entity.Price;
import az.inci.pos.entity.Warehouse;
import az.inci.pos.entity.composite.UserBranch;
import az.inci.pos.entity.composite.UserCash;
import az.inci.pos.entity.composite.UserCompany;
import az.inci.pos.entity.composite.UserDefaults;
import az.inci.pos.entity.meta.BmsFormLocks;
import az.inci.pos.entity.meta.BmsUserGroup;
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
@Table(name = "BMS_USER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsUser
{
    @Id
    @Column(name = "USER_ID", nullable = false, length = 15)
    private String id;

    @Column(name = "USER_NAME", length = 50)
    private String userName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PASS_WORD", length = 15)
    private String password;

    @Column(name = "ADMIN_FLAG")
    private Boolean adminFlag;

    @Column(name = "TERMINAL_FLAG")
    private Boolean terminalFlag;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "RETAIL_FLAG")
    private Boolean retailFlag;

    @Column(name = "REMOTE_ACCESS_FLAG")
    private Boolean remoteFlag;

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

    @Column(name = "EMC_DATA", length = 250)
    private String emcData;

    @ManyToOne
    @JoinColumn(name = "USER_GROUP_ID",
            referencedColumnName = "USER_GROUP_ID",
            foreignKey = @ForeignKey(name = "FK_BMS_USER_BMS_USER_GROUP"))
    private BmsUserGroup bmsUserGroup;


    @OneToMany(mappedBy = "bmsUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<UserCompany> companies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bmsUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<UserBranch> branches = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "BMS_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"),
            foreignKey = @ForeignKey(name = "FK_BMS_USER_ROLE_BMS_USER"),
            inverseForeignKey = @ForeignKey(name = "FK_BMS_USER_ROLE_BMS_ROLE"))
    @ToString.Exclude
    private Set<BmsRole> bmsRoles = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "BMS_USER_WHS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "WHS_CODE"),
            foreignKey = @ForeignKey(name = "FK_BMS_USER_WHS_BMS_USER"),
            inverseForeignKey = @ForeignKey(name = "FK_BMS_USER_WHS_WHS_MASTER"))
    @ToString.Exclude
    private Set<Warehouse> warehouses = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "BMS_USER_PRICE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRICE_CODE"),
            foreignKey = @ForeignKey(name = "FK_BMS_USER_PRICE_BMS_USER"),
            inverseForeignKey = @ForeignKey(name = "FK_BMS_USER_PRICE_PRICE_MASTER"))
    @ToString.Exclude
    private Set<Price> prices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bmsUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<UserCash> cashes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<UserDefaults> userDefaults = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bmsUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<BmsFormLocks> formLocks = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsUser bmsUser = (BmsUser) o;
        return id != null && Objects.equals(id, bmsUser.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
