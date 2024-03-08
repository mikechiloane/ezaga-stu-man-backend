package co.za.faboda.ezagastumanbackend.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Success {
    private String message;
}
