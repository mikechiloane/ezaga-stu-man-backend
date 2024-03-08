package co.za.faboda.ezagastumanbackend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student extends User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String email;
    private String fullName;
    private String studentNumber;
    private String password;
    private boolean secondFactorAuthEnabled;
    private boolean needsPasswordReset;
}
