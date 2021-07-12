package com.java.tmall_springboot.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.java.tmall_springboot.service.OrderService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

@Getter
@Setter
@Entity
@Table(name = "order_")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="uid")

    private User user;

    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private String status;

    @Transient
    private List<OrderItem> orderItems;
    @Transient
    private float total;
    @Transient
    private int totalNumber;
    @Transient
    private String statusDesc;

    public Order(){

    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getStatusDesc(){
        if(null!=statusDesc)
            return statusDesc;
        String desc ="未知";
        switch(status){
            case OrderService.waitPay:
                desc="待付";
                break;
            case OrderService.waitDelivery:
                desc="待发";
                break;
            case OrderService.waitConfirm:
                desc="待收";
                break;
            case OrderService.waitReview:
                desc="等评";
                break;
            case OrderService.finish:
                desc="完成";
                break;
            case OrderService.delete:
                desc="刪除";
                break;
            default:
                desc="未知";
        }
        statusDesc = desc;
        return statusDesc;
    }
}
