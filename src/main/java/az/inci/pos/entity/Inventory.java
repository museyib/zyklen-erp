package az.inci.pos.entity;

import az.inci.pos.entity.meta.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INV_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Inventory
{
    @Id
    @Column(name = "INV_CODE", nullable = false)
    private String id;

    @Column(name = "INV_NAME")
    private String name;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "INV_TYPE",
            referencedColumnName = "INV_TYPE",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_TYPE"))
    private InvType type;

    @ManyToOne
    @JoinColumn(name = "INV_CLASS",
            referencedColumnName = "INV_CLASS",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_CLASS"))
    private InvClass invClass;

    @ManyToOne
    @JoinColumn(name = "UNIT_CODE",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_UOM"))
    private Uom unitCode;

    @Column(name = "UNIT_FACTOR", nullable = false)
    private double unitFactor;

    @ManyToOne
    @JoinColumn(name = "INV_GROUP_ID",
            referencedColumnName = "INV_GROUP_ID",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_GROUP"))
    private InvGroup group;

    @ManyToOne
    @JoinColumn(name = "INV_BRAND_CODE",
            referencedColumnName = "INV_BRAND_CODE",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_BRAND"))
    private InvBrand brand;

    @ManyToOne
    @JoinColumn(name = "INV_CATEGORY_ID",
            referencedColumnName = "INV_CATEGORY_ID",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_CATEGORY"))
    private InvCategory category;

    @ManyToOne
    @JoinColumn(name = "PRODUCER_CODE",
            referencedColumnName = "PRODUCER_CODE",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_INV_PRODUCER"))
    private InvProducer producer;

    @ManyToOne
    @JoinColumn(name = "COUNTRY",
            referencedColumnName = "COUNTRY",
            foreignKey = @ForeignKey(name = "FK_INV_MASTER_COUNTRY"))
    private Country country;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "tax_inv_code")
    private String taxInvCode;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "notes")
    private String notes;

    @Column(name = "WARRANTY_FLAG")
    private Boolean warrantyFlag;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Column(name = "ITEM_FLAG")
    private Boolean itemFlag;

    @Column(name = "SALE_FLAG")
    private Boolean saleFlag;

    @Column(name = "PURCHASE_FLAG")
    private Boolean purchaseFlag;

    @Column(name = "FXA_FLAG")
    private Boolean fxaFlag;

    @Column(name = "INTERNET_FLAG")
    private Boolean internetFlag;

    @Column(name = "PRODUCTION_FLAG")
    private Boolean productionFlag;

    @Column(name = "NEW_FLAG")
    private Boolean newFlag;

    @Column(name = "SPECIAL_FLAG")
    private Boolean specialFlag;

    @Column(name = "CREDIT_SALE_FLAG")
    private Boolean creditSaleFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Inventory inventory = (Inventory) o;
        return id != null && Objects.equals(id, inventory.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}