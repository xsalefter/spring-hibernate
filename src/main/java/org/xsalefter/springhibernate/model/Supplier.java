package org.xsalefter.springhibernate.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ParamDef;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Entity
@Table(name="supplier")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@FilterDef(
    name="supplierToGoodReceptionsWhereOfficialAmountBetween",
    parameters={
        @ParamDef(name="officialAmountFrom", type="int"),
        @ParamDef(name="officialAmountUntil", type="int")
    }
)
public class Supplier implements Serializable {
    private static final long serialVersionUID = -23492347239484645L;

    private Long id;
    private String name;
    private String description;
    private Set<GoodReception> goodReceptions;

    public Supplier() {}

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="supplier_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="supplier_name", nullable=false, length=50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Filter(name="supplierToGoodReceptionsWhereOfficialAmountBetween",
        condition="official_amount between :officialAmountFrom and :officialAmountUntil")
    @org.hibernate.annotations.OrderBy(clause="reception_date asc")
    @BatchSize(size=5)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy="supplier", fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    public Set<GoodReception> getGoodReceptions() {
        return goodReceptions;
    }

    public void setGoodReceptions(Set<GoodReception> goodReceptions) {
        this.goodReceptions = goodReceptions;
    }

}
