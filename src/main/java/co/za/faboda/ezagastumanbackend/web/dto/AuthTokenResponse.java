package co.za.faboda.ezagastumanbackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenResponse {
    private String token;
}
