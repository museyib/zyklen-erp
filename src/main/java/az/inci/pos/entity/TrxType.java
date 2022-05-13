package az.inci.pos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TRX_DEF")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TrxType
{
    @Id
    @Column(name = "TRX_TYPE_ID", nullable = false)
    private Integer id;

    @Column(name = "TRX_TYPE_NAME")
    private String name;

    @Column(name = "TRX_TABLE")
    private String trxTable;

    @Column(name = "FORM_ID", nullable = false)
    private int formId;

    @Column(name = "trx_no_mask")
    private String trxNoMask;

    @Column(name = "SBE_TYPE")
    private String sbeType;

    @Column(name = "TRX_REC_STATUS", nullable = false)
    private int trxRecStatus;

    @Column(name = "SBE_REQ_FLAG", nullable = false)
    private boolean sbeReqFlag;

    @Column(name = "STOCK_AVAIL_CHECK_FLAG", nullable = false)
    private boolean stockAvailCheckFlag;

    @Column(name = "CLOSE_FLAG", nullable = false)
    private boolean closeFlag;

    @Column(name = "CANCEL_FLAG", nullable = false)
    private boolean cancelFlag;

    @Column(name = "PRICE_CONTROL_FLAG", nullable = false)
    private boolean priceControlFlag;

    @Column(name = "CREDIT_LIMIT_FLAG", nullable = false)
    private boolean creditLimitFlag;

    @Column(name = "WHS_AFFECTED_FLAG", nullable = false)
    private boolean whsAffectedFlag;

    @Column(name = "WHS_INV_BLOCK_CHECK", nullable = false)
    private boolean whsInvBlockCheck;

    @Column(name = "WHS_PICK_CHECK_FLAG", nullable = false)
    private boolean whsPickCheckFlag;

    @Column(name = "AMOUNT_ZERO_CHECK_FLAG", nullable = false)
    private boolean amountZeroCheckFlag;

    @Column(name = "CLOSE_DOC_IF_NOITEMS_FLAG", nullable = false)
    private boolean closeDocIfNoItemsFlag;

    @Column(name = "INACTIVE_FLAG", nullable = false)
    private boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrxType trxType = (TrxType) o;
        return id != null && Objects.equals(id, trxType.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}