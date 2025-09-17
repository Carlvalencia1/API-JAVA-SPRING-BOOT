package com.valenciacompani.qrpaylink.merchant.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "merchants")
@Data

public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String businessName;

    @Column(nullable = false)
    private String contactName;

    @Column (nullable = false, unique = true)
    private String email;

    private String phone;

    private  String address;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updte_at")
    private  LocalDateTime updateAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
