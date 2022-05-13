package az.inci.pos.entity;

import az.inci.pos.entity.meta.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "BP_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Bp
{
    @Id
    @Column(name = "BP_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "BP_NAME", length = 100)
    private String name;

    @Column(name = "SHORT_NAME", length = 20)
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "branch_code",
            referencedColumnName = "BRANCH_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_BRANCH"))
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "CURR_CODE",
            referencedColumnName = "CURR_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_CURRENCY"))
    private Currency currency;

    @Column(name = "ADDRESS1", length = 100)
    private String address1;

    @Column(name = "ADDRESS2", length = 100)
    private String address2;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_COUNTRY"))
    private Country country;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_CODE",
            referencedColumnName = "PROVINCE_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_PROVINCE"))
    private Province province;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_CODE",
            referencedColumnName = "DISTRICT_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_DISTRICT"))
    private District district;

    @Column(name = "ZIP", length = 5)
    private String zip;

    @Column(name = "PAY_DAY", nullable = false)
    private short payDay;

    @ManyToOne
    @JoinColumn(name = "PAY_METHOD_CODE",
            referencedColumnName = "PAY_METHOD_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_PAY_METHOD"))
    private PayMethod payMethod;

    @Column(name = "FORBIDDEN_FLAG")
    private Boolean forbiddenFlag;

    @Column(name = "tax_office_code", length = 12)
    private String taxOfficeCode;

    @Column(name = "TAX_ACCOUNT_NO", length = 12)
    private String taxAccountNo;

    @Column(name = "PHONE1", length = 15)
    private String phone1;

    @Column(name = "PHONE2", length = 15)
    private String phone2;

    @Column(name = "PHONE3", length = 15)
    private String phone3;

    @Column(name = "PHONE4", length = 15)
    private String phone4;

    @Column(name = "FAX1", length = 15)
    private String fax1;

    @Column(name = "FAX2", length = 15)
    private String fax2;

    @Column(name = "EMAIL", length = 80)
    private String email;

    @Column(name = "WEB", length = 80)
    private String web;

    @Column(name = "NOTES", length = 250)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "BP_STATUS",
            referencedColumnName = "BP_STATUS_ID",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_BP_STATUS"))
    private BpStatus bpStatus;

    @ManyToOne
    @JoinColumn(name = "BP_GROUP_CODE",
            referencedColumnName = "BP_GROUP_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_BP_GROUP"))
    private BpGroup bpGroup;

    @ManyToOne
    @JoinColumn(name = "BP_TYPE",
            referencedColumnName = "BP_TYPE_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_BP_TYPE"))
    private BpType bpType;

    @ManyToOne
    @JoinColumn(name = "WHS_PROFILE_CODE",
            referencedColumnName = "WHS_PROFILE_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_WHS_PROFILE"))
    private WarehouseProfile warehouseProfile;

    @ManyToOne
    @JoinColumn(name = "BP_CHAIN_CODE",
            referencedColumnName = "BP_CHAIN_CODE",
            foreignKey = @ForeignKey(name = "FK_BP_MASTER_BP_CHAIN"))
    private BpChain bpChain;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "INTERNET_FLAG")
    private Boolean internetFlag;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bp bp = (Bp) o;
        return id != null && Objects.equals(id, bp.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}