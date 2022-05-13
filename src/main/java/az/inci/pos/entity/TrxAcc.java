package az.inci.pos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRX_ACC")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TrxAcc
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TRX_TYPE_ID",
            referencedColumnName = "TRX_TYPE_ID",
            foreignKey = @ForeignKey(name = "FK_TRX_ACC_TRX_DEF"))
    private TrxType trxType;

    @Column(name = "DBT_CRD", nullable = false)
    private short dbtCrd;

    @Column(name = "TRX_TABLE")
    private String trxTable;

    @Column(name = "TAX_TABLE")
    private String taxTable;

    @Column(name = "MIN_REC_COUNT", nullable = false)
    private int minRecCount;

    @Column(name = "TAXABLE_FLAG", nullable = false)
    private boolean taxableFlag;

    @Column(name = "MULTIREC_FLAG", nullable = false)
    private boolean multiRecFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrxAcc trxAcc = (TrxAcc) o;
        return id != null && Objects.equals(id, trxAcc.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}