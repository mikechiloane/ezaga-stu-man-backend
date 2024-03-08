package co.za.faboda.ezagastumanbackend.web.dto;

import co.za.faboda.ezagastumanbackend.model.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDetails {
    private String email;
    private String fullName;
    private String studentNumber;
    private boolean secondFactorAuthEnabled;
    private boolean needsPasswordReset;

}
