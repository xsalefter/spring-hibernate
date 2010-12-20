package org.xsalefter.springhibernate.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Entity
@Table(name="item_reception")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ItemReception implements Serializable {

    private static final long serialVersionUID = -2348234593473284354L;

    private Long id;
    private Integer amount;
    private GoodReception goodReception;
    private Item item;

    public ItemReception() {}

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_reception_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @LazyToOne(LazyToOneOption.NO_PROXY)
    @Fetch(FetchMode.JOIN)
    @ManyToOne(targetEntity=GoodReception.class, fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="good_reception_id", nullable=false)
    public GoodReception getGoodReception() {
        return goodReception;
    }

    public void setGoodReception(GoodReception goodReception) {
        this.goodReception = goodReception;
    }

    @LazyToOne(LazyToOneOption.NO_PROXY)
    @Fetch(FetchMode.JOIN)
    @ManyToOne(targetEntity=Item.class, fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="item_id", nullable=false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
