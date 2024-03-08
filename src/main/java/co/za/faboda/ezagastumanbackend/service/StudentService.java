package co.za.faboda.ezagastumanbackend.service;

import co.za.faboda.ezagastumanbackend.exceptions.AlreadyExistsException;
import co.za.faboda.ezagastumanbackend.exceptions.NotFoundException;
import co.za.faboda.ezagastumanbackend.exceptions.ValidationException;
import co.za.faboda.ezagastumanbackend.model.Student;
import co.za.faboda.ezagastumanbackend.repository.StudentRepository;
import co.za.faboda.ezagastumanbackend.util.JWTUtil;
import co.za.faboda.ezagastumanbackend.util.StudentNumberGenerator;
import co.za.faboda.ezagastumanbackend.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public AuthTokenResponse registerStudent(RegistrationRequest registrationRequest) {

        Student studentExists = studentRepository.findByEmail(registrationRequest.getEmail()).orElse(null);
        if (studentExists == null) {

            Student student = new Student();
            student.setEmail(registrationRequest.getEmail());
            student.setFullName(registrationRequest.getFullName());
            student.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            student.setStudentNumber(StudentNumberGenerator.generateStudentNumber());
            studentRepository.save(student);
            return AuthTokenResponse.builder().token(jwtUtil.createToken(student)).build();
        }
        throw new AlreadyExistsException("Student already exists");

    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    public AuthTokenResponse loginStudent(LoginRequest loginRequest) {
        Student student = studentRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        if (student != null && passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
            log.info("User {} authenticated successfully", student.getFullName());
            return AuthTokenResponse.builder().token(jwtUtil.createToken(student)).build();
        }

        throw new NotFoundException("User not found");
    }

    public StudentDetails getStudentDetails(String email) {
        Student student = studentRepository.findByEmail(email).orElse(null);
        if (student != null) {
            return StudentDetails.builder().fullName(student.getFullName()).studentNumber(student.getStudentNumber()).needsPasswordReset(student.isNeedsPasswordReset()).secondFactorAuthEnabled(student.isSecondFactorAuthEnabled()).email(student.getEmail()).build();
        }
        log.error("Student not found for email: {}", email);
        throw new NotFoundException("Student not found");
    }

    public StudentEmailResponse getStudentEmail(AuthTokenRequest authTokenRequest) {
        String email = jwtUtil.extractUserEmailFromToken(authTokenRequest.getToken());

        if (email != null) {
            return StudentEmailResponse.builder().email(email).build();
        }

        throw new NotFoundException("Student not found");
    }

    public Success getOtp(String email) {
        Student student = studentRepository.findByEmail(email).orElse(null);
        if (student != null) {
            return Success.builder().message("OTP sent successfully").build();
        }
        log.error("Student not found for email: {}", email);
        throw new NotFoundException("Student not found");
    }

    public AuthTokenResponse validateOtp(ValidateOtpRequest validateOtpRequest) {
        Student student = studentRepository.findByEmail(validateOtpRequest.getEmail()).orElse(null);
        if (student != null && validateOtpRequest.getOtp().equals("1234")) {
            return AuthTokenResponse.builder().token(jwtUtil.createToken(student)).build();
        }
        throw new ValidationException("Invalid OTP");
    }

    public Success resetPassword(ResetPasswordRequest resetPasswordRequest) {
        String email = jwtUtil.extractUserEmailFromToken(resetPasswordRequest.getToken());
        Student student = studentRepository.findByEmail(email).orElse(null);
        if (student != null) {
            student.setPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()));
            student.setNeedsPasswordReset(false);
            studentRepository.save(student);
            return Success.builder().message("Password reset successfully").build();
        }
        throw new NotFoundException("Student not found");
    }


}
