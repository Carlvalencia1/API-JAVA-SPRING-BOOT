package com.valenciacompani.qrpaylink.merchant.service.impl;

import com.valenciacompani.qrpaylink.merchant.dto.MerchantRequest;
import com.valenciacompani.qrpaylink.merchant.model.Merchant;
import com.valenciacompani.qrpaylink.merchant.repository.MerchantRepository;
import com.valenciacompani.qrpaylink.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    @Override
    public Merchant createMerchant(MerchantRequest request){
        if (merchantRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        if (merchantRepository.existsByBusinessName(request.getBussienesName())){
            throw new RuntimeException("Business name already taken");
        }
        Merchant merchant = new Merchant();
        merchant.setBusinessName(request.getBussienesName());
        merchant.setContactName(request.getContactName());
        merchant.setEmail(request.getEmail());
        merchant.setPhone(request.getPhone());
        merchant.setAddress(request.getAddress());
        merchant.setTaxId(request.getTaxId());

        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant getMerchantById(Long id){
        return merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));
    }

    @Override
    public Merchant getMerchantByEmail(String email){
        return merchantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));
    }

    @Override
    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }

    @Override
    public Merchant updateMerchant(Long id, MerchantRequest request){
        Merchant merchant = getMerchantById(id);

        merchant.setBusinessName(request.getBussienesName());
        merchant.setContactName(request.getContactName());
        merchant.setPhone(request.getPhone());
        merchant.setAddress(merchant.getAddress());
        merchant.setTaxId(request.getTaxId());

        return merchantRepository.save(merchant);
    }

    @Override
    public void deleteMerchant(Long id){
        Merchant merchant =  getMerchantById(id);
        merchantRepository.delete(merchant);
    }
}
