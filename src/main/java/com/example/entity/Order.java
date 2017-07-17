package com.example.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@ToString
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Long id;

    @ManyToOne(cascade = { CascadeType.ALL }, optional = true)
    @JoinColumn(nullable = false)
    private @Getter @Setter Account account;

    @Column(nullable = false)
    private @Getter @Setter Date orderDate;

    @Column(nullable = false)
    private @Getter @Setter String orderStatus;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "order")
    private @Getter @Setter Set<OrderItem> orderItems;

    @Column(length = 2000)
    private @Getter @Setter String orderDesc;

}
