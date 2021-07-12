package com.java.tmall_springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "orderItem")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="pid")

    private Product product;

    @ManyToOne
    @JoinColumn(name="oid")
    private Order order;

    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    private int number;

    public OrderItem(){}
}
