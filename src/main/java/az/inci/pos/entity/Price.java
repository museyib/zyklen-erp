package az.inci.pos.entity;

import az.inci.pos.entity.meta.Currency;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRICE_MASTER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Price
{
    @Id
    @Column(name = "PRICE_CODE", nullable = false)
    private String id;

    @Column(name = "PRICE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "BASE_PC",
            referencedColumnName = "PRICE_CODE",
            foreignKey = @ForeignKey(name = "FK_PRICE_MASTER_PRICE_MASTER"))
    private Price price;

    @Column(name = "FACTOR", nullable = false)
    private double factor;

    @ManyToOne
    @JoinColumn(name = "CURR_CODE",
            referencedColumnName = "CURR_CODE",
            foreignKey = @ForeignKey(name = "FK_PRICE_MASTER_CURRENCY"))
    private Currency currency;

    @Column(name = "ORDER_ID", nullable = false)
    private int orderId;

    @Column(name = "ROUND_LENGTH", nullable = false)
    private int roundLength;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Price price = (Price) o;
        return id != null && Objects.equals(id, price.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}