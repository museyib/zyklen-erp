package az.inci.pos.entity.meta;

import az.inci.pos.entity.TrxType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BMS_FORM")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsForm
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Id
    @Column(name = "form_id")
    private Integer formId;

    @Column(name = "FORM_CAPTION", length = 50)
    private String name;

    @Column(name = "FORM_CLASS", length = 50)
    private String formClass;

    @Column(name = "FORM_TABLE", length = 50)
    private String formTable;

    @Column(name = "FORM_KEY", length = 30)
    private String formKey;

    @Column(name = "FORM_DESC", length = 200)
    private String formDesc;

    @ManyToOne
    @JoinColumn(name = "MODULE_ID",
            referencedColumnName = "MODULE_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_BMS_MODULE"))
    private BmsModule bmsModule;

    @ManyToOne
    @JoinColumn(name = "FORM_CATEGORY",
            referencedColumnName = "FORM_CATEGORY",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_BMS_FORM_CATEGORY"))
    private BmsFormCategory bmsFormCategory;

    @ManyToOne
    @JoinColumn(name = "TRX_TYPE_ID",
            referencedColumnName = "TRX_TYPE_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_TRX_DEF"))
    private TrxType trxType;

    @Column(name = "FORM_MASK", length = 3)
    private String formMask;

    @Column(name = "ORDERING")
    private Integer ordering;

    @Column(name = "COMPANY_FLAG")
    private Boolean companyFlag;

    @Column(name = "MODAL_FLAG")
    private Boolean modalFlag;

    @Column(name = "STAYTOP_FLAG")
    private Boolean stayTopFlag;

    @Column(name = "AUTO_COUNT")
    private Boolean autoCount;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "IS_MENU_ITEM")
    private Boolean isMenuItem;

    @Column(name = "IS_UNIQUE_LOAD")
    private Boolean isUniqueLoad;

    @Column(name = "SAVE_AND_CLOSE")
    private Boolean saveAndClose;

    @Column(name = "SAVE_AND_NEW")
    private Boolean saveAndNew;

    @Column(name = "SAVE_AND_LOAD")
    private Boolean saveAndLoad;

    @Column(name = "AUTO_LOAD")
    private Boolean autoLoad;

    @Column(name = "AUTO_NEW")
    private Boolean autoNew;

    @Column(name = "DO_LOG")
    private Boolean doLog;

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

    @OneToMany(mappedBy = "bmsForm", orphanRemoval = true)
    @ToString.Exclude
    private Set<BmsFormSecurity> bmsFormSecurities = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsForm bmsForm = (BmsForm) o;
        return id != null && Objects.equals(id, bmsForm.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}