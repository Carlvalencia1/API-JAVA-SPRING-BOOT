package com.valenciacompani.qrpaylink.merchant.service;

import com.valenciacompani.qrpaylink.merchant.dto.MerchantRequest;
import com.valenciacompani.qrpaylink.merchant.model.Merchant;

import javax.swing.*;
import java.util.List;

public interface MerchantService {
    Merchant createMerchant(MerchantRequest request);
    Merchant getMerchantById(Long id);
    Merchant getMerchantByEmail(String email);
    List<Merchant> getAllMerchants();
    Merchant updateMerchant(Long id, MerchantRequest request);
    void deleteMerchant(Long id);
}
