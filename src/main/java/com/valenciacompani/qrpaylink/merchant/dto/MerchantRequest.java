package com.valenciacompani.qrpaylink.merchant.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MerchantRequest {
    @NotBlank(message = "Bussines name is requerid")
    private String bussienesName;

    @NotBlank(message = "Contact name is required")
    private String contactName;

    @NotBlank(message = "Emain is requieres")
    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private  String address;

    private String taxId;
}
