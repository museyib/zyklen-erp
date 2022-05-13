package az.inci.pos.entity.meta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_DICTIONARY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsDictionary
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "LANG_ID", length = 2)
    private String langId;

    @Column(name = "INPUT_VALUE", length = 100)
    private String inputValue;

    @Column(name = "OUTPUT_VALUE", length = 100)
    private String outputValue;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsDictionary that = (BmsDictionary) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}