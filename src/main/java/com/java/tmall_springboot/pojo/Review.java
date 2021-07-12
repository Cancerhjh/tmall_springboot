package com.java.tmall_springboot.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

@Getter
@Setter
@Entity
@Table(name = "review")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "uid")

    private User user;

    @ManyToOne
    @JoinColumn(name = "pid")

    private Product product;

    private String content;
    private Date createDate;
    public Review(){}
}