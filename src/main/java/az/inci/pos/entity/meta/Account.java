package az.inci.pos.entity.meta;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Account
{
    @Id
    @Column(name = "ACCOUNT_CODE", nullable = false, length = 20)
    private String id;

    @Column(name = "ACCOUNT_NAME", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_TYPE_ID",
            referencedColumnName = "ACCOUNT_TYPE_ID",
            foreignKey = @ForeignKey(name = "FK_ACCOUNT_ACCOUNT_TYPE"))
    private AccountType accountType;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}