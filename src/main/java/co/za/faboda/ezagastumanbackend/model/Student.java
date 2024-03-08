package co.za.faboda.ezagastumanbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student extends User{
    @GeneratedValue
    @Id
    private Long id;
    private String email;
    private String fullName;
    private String studentNumber;
    private String password;
    private boolean secondFactorAuthEnabled;
    private boolean needsPasswordReset;
}
