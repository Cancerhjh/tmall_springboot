package com.java.tmall_springboot.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "property")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    @Transient
    List<Product> products;
    @Transient
    List<List<Product>> productsByRow;

    public Property(){}

    @Override
    public String toString() {
        return "Property [id=" + id + ", name=" + name + ", category=" + category + "]";
    }
}
