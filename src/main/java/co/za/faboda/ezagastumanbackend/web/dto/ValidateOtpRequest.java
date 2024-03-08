package co.za.faboda.ezagastumanbackend.web.dto;

import lombok.Data;

@Data
public class ValidateOtpRequest {
    private String otp;
    private String email;
}
