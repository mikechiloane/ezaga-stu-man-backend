package co.za.faboda.ezagastumanbackend.web.controller;

import co.za.faboda.ezagastumanbackend.service.StudentService;
import co.za.faboda.ezagastumanbackend.web.dto.GetStudentDetailsRequest;
import co.za.faboda.ezagastumanbackend.web.dto.ResetPasswordRequest;
import co.za.faboda.ezagastumanbackend.web.dto.StudentDetails;
import co.za.faboda.ezagastumanbackend.web.dto.Success;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/getStudentDetails")
    public ResponseEntity<StudentDetails> getStudentDetails(@RequestBody GetStudentDetailsRequest getStudentDetailsRequest) {
        return ResponseEntity.ok(studentService.getStudentDetails(getStudentDetailsRequest.getEmail()));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<Success> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        return ResponseEntity.ok(studentService.resetPassword(resetPasswordRequest));
    }

}
