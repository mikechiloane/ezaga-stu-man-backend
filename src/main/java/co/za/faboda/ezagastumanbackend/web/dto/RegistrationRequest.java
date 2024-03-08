package co.za.faboda.ezagastumanbackend.web.dto;


import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String fullName;
    private String password;
}
