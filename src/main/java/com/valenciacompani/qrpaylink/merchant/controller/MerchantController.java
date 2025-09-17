package com.valenciacompani.qrpaylink.merchant.controller;


import com.valenciacompani.qrpaylink.merchant.dto.MerchantRequest;
import com.valenciacompani.qrpaylink.merchant.model.Merchant;
import com.valenciacompani.qrpaylink.merchant.service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.metadata.PredefinedScopeBeanMetaDataManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@Valid @RequestBody MerchantRequest request) {
        Merchant merchant = merchantService.createMerchant(request);
        return  ResponseEntity.ok(merchant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable Long id) {
        Merchant merchant = merchantService.getMerchantById(id);
        return  ResponseEntity.ok(merchant);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable String email){
        Merchant merchant = merchantService.getMerchantByEmail(email);
        return  ResponseEntity.ok(merchant);
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants(){
        List<Merchant> merchants = merchantService.getAllMerchants();
        return  ResponseEntity.ok(merchants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Merchant> updateMerchant(
            @PathVariable Long id,
            @Valid @RequestBody MerchantRequest request){
        Merchant merchant = merchantService.updateMerchant(id, request);
        return ResponseEntity.ok(merchant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable long id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.noContent().build();
    }
}
