package org.xsalefter.springhibernate.model;

import org.xsalefter.springhibernate.utils.ItemNameComparatorForItemReception;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Entity
@Table(name="good_reception")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GoodReception implements Serializable {

    private static final long serialVersionUID = -2342350435464534L;

    private Long id;
    private Date receptionDate;
    private Integer officialAmount;
    private Integer administrationAmount;
    private String notes;
    private Supplier supplier;
    private Set<ItemReception> itemReceptions;

    public GoodReception() {}

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="good_reception_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="reception_date", nullable=false)
    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date transactionDate) {
        this.receptionDate = transactionDate;
    }

    @Column(name="official_amount")
    public Integer getOfficialAmount() {
        return officialAmount;
    }

    public void setOfficialAmount(Integer officialAmount) {
        this.officialAmount = officialAmount;
    }

    @Column(name="administration_amount")
    public Integer getAdministrationAmount() {
        return administrationAmount;
    }

    public void setAdministrationAmount(Integer administrationAmount) {
        this.administrationAmount = administrationAmount;
    }

    @Column(name="reception_notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @LazyToOne(LazyToOneOption.PROXY)
    @Fetch(FetchMode.JOIN)
    @ManyToOne(targetEntity=Supplier.class, fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="supplier_id", nullable=false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @BatchSize(size=10)
    @ElementCollection(fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Fetch(value=FetchMode.JOIN)
    @OneToMany(mappedBy="goodReception", fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @Sort(type=SortType.COMPARATOR, comparator=ItemNameComparatorForItemReception.class)
    // @javax.persistence.OrderBy("item.name") This is never works!
    public Set<ItemReception> getItemReceptions() {
        return itemReceptions;
    }

    public void setItemReceptions(Set<ItemReception> itemReceptions) {
        this.itemReceptions = itemReceptions;
    }
}
