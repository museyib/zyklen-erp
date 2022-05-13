package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AccountType
{
    @Id
    @Column(name = "ACCOUNT_TYPE_ID", nullable = false)
    private Integer id;

    @Column(name = "ACCOUNT_TYPE_NAME", length = 40)
    private String name;

    @Column(name = "MASTER_TABLE", length = 100)
    private String masterTable;

    @Column(name = "TRX_TABLE", length = 100)
    private String trxTable;

    @Column(name = "FORM_CLASS", length = 100)
    private String formClass;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountType that = (AccountType) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}