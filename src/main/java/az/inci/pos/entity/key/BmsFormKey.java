package az.inci.pos.entity.key;

import az.inci.pos.entity.meta.BmsForm;
import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BmsFormKey implements Serializable
{
    @OneToOne
    @JoinColumn(name = "FORM_ID")
    private BmsForm bmsForm;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsFormKey that = (BmsFormKey) o;
        return Objects.equals(bmsForm, that.bmsForm);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bmsForm);
    }
}