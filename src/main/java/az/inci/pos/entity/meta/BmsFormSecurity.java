package az.inci.pos.entity.meta;

import az.inci.pos.entity.key.BmsFormKey;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BMS_FORM_SECURITY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BmsFormSecurity
{
    @EmbeddedId
    private BmsFormKey bmsFormKey;

    @ManyToOne
    @JoinColumn(name = "SEC_OBJECT_TYPE",
            referencedColumnName = "SEC_OBJECT_TYPE",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_SECURITY_SEC_OBJECT_TYPE"))
    private BmsSecObjectType secObjectType;

    @Column(name = "SEC_OBJECT_ID", length = 15)
    private String secObjectId;

    @ManyToOne
    @JoinColumn(name = "FORM_ID",
            referencedColumnName = "FORM_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_BMS_FORM_SECURITY_BMS_FORM"))
    private BmsForm bmsForm;

    @Column(name = "CANMODIFY")
    private Boolean canModify;

    @Column(name = "CANDELETE")
    private Boolean canDelete;

    @Column(name = "CANCREATE")
    private Boolean canCreate;

    @Column(name = "CANCOMMIT")
    private Boolean canCommit;

    @Column(name = "CANIGNORE")
    private Boolean canIgnore;

    @Column(name = "CANPRINT")
    private Boolean canPrint;

    @Column(name = "CANDESIGN")
    private Boolean canDesign;

    @Column(name = "CANPREVIEW")
    private Boolean canPreview;

    @Column(name = "CANREDIRECT")
    private Boolean canRedirect;

    @Column(name = "HIDDEN")
    private Boolean hidden;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BmsFormSecurity that = (BmsFormSecurity) o;
        return bmsFormKey != null && Objects.equals(bmsFormKey, that.bmsFormKey);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(bmsFormKey);
    }
}