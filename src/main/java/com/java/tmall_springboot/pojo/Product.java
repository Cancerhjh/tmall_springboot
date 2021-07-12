package com.java.tmall_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.data.elasticsearch.annotations.Document;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
@Document(indexName = "tmall_springboot",type = "product")

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    //如果既没有指明 关联到哪个Column,又没有明确要用@Transient忽略，那么就会自动关联到表对应的同名字段
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;

    @Transient
    private ProductImage firstProductImage;
    @Transient
    private List<ProductImage> productSingleImages;
    @Transient
    private List<ProductImage> productDetailImages;
    @Transient
    private int reviewCount;
    @Transient
    private int saleCount;;

    public Product(){}
}