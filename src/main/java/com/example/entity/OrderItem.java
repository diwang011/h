package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "orderItem")
@ToString
@JsonIgnoreProperties("order")
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = { CascadeType.ALL }, optional = true)
    @JoinColumn(nullable = false)
    private Order order;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private Integer quantity;

}
