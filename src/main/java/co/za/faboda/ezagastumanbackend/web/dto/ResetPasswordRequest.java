package co.za.faboda.ezagastumanbackend.web.dto;


import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String token;
    private String password;
}
