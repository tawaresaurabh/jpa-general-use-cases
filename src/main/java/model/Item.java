package model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@CascadeOnDelete
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {


    @Id
    @GeneratedValue
    private Long id;
    @Column(name="UNIT_COST")
    private BigDecimal unitCost;
    @Column(length = 100)
    private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
