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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Entity
@Table(name="item")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Item implements Serializable {

    private static final long serialVersionUID = -23409374239654564L;

    private Long id;
    private String name;
    private String description;
    private Set<ItemReception> itemReceptions;

    public Item() {}


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="item_name", nullable=false, length=75)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description", length=255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @BatchSize(size=10)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Fetch(value=FetchMode.JOIN)
    @OneToMany(mappedBy="item", fetch=FetchType.LAZY,
        cascade={CascadeType.PERSIST, CascadeType.MERGE})
    public Set<ItemReception> getItemReceptions() {
        return itemReceptions;
    }

    public void setItemReceptions(Set<ItemReception> itemReceptions) {
        this.itemReceptions = itemReceptions;
    }
}
