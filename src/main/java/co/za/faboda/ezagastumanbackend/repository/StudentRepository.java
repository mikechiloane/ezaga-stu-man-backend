package co.za.faboda.ezagastumanbackend.repository;

import co.za.faboda.ezagastumanbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where upper(s.email) = upper(?1)")
    Optional<Student> findByEmail(String email);
}