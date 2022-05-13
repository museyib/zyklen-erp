package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAY_METHOD")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PayMethod
{
    @Id
    @Column(name = "PAY_METHOD_CODE", nullable = false, length = 10)
    private String id;

    @Column(name = "DESCRIPTION", length = 50)
    private String name;

    @Column(name = "RISK_FLAG")
    private Boolean riskFlag;

    @Column(name = "DELIVERY_FLAG")
    private Boolean deliveryFlag;

    @ManyToOne
    @JoinColumn(name = "CURR_CODE",
            referencedColumnName = "CURR_CODE",
            foreignKey = @ForeignKey(name = "FK_PAY_METHOD_CURRENCY"))
    private Currency currency;

    @Column(name = "CASH_FLAG")
    private Boolean cashFlag;

    @Column(name = "INACTIVE_FLAG")
    private Boolean inactiveFlag;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PayMethod payMethod = (PayMethod) o;
        return id != null && Objects.equals(id, payMethod.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}