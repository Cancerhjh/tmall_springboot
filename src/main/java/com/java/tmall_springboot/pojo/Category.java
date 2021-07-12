package com.java.tmall_springboot.pojo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
//作用是在 json 序列化时忽略 bean 中的一些不需要转化的属性
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;

    @Transient
    List<Product> products;
    @Transient
    List<List<Product>> productsByRow;

    public Category(){}

}
