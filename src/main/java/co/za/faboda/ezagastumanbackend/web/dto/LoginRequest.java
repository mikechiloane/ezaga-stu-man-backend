package co.za.faboda.ezagastumanbackend.web.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
