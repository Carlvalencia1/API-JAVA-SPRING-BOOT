package com.valenciacompani.qrpaylink.merchant.repository;

import com.valenciacompani.qrpaylink.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  MerchantRepository extends JpaRepository<Merchant, Long> {
    Optional<Merchant> findByEmail(String email);
    Optional<Merchant> findByBusinessName(String bussinessName);
    boolean existsByEmail(String email);
    boolean existsByBusinessName(String bussinessName);


}
