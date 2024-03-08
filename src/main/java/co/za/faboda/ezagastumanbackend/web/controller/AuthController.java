package co.za.faboda.ezagastumanbackend.web.controller;


import co.za.faboda.ezagastumanbackend.service.StudentService;
import co.za.faboda.ezagastumanbackend.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<AuthTokenResponse> register(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(studentService.registerStudent(registrationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenResponse> login (@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(studentService.loginStudent(loginRequest));
    }

    @PostMapping("/getStudentEmail")
    public ResponseEntity<StudentEmailResponse> getStudentEmail(@RequestBody AuthTokenRequest authTokenRequest){
        return ResponseEntity.ok(studentService.getStudentEmail(authTokenRequest));
    }

    @PostMapping("/getOtp")
    public ResponseEntity<Success> getOtp(@RequestBody GetStudentDetailsRequest getStudentDetailsRequest){
        return ResponseEntity.ok(studentService.getOtp(getStudentDetailsRequest.getEmail()));
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<AuthTokenResponse> verifyOtp(@RequestBody ValidateOtpRequest validateOtpRequest){
        return ResponseEntity.ok(studentService.validateOtp(validateOtpRequest));
    }

}
