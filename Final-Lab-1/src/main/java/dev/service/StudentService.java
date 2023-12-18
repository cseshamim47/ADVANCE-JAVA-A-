package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws SQLException {
        student.setName(student.getName().toUpperCase());
        studentRepository.create(student);
    }

    public void update(Student student) throws  SQLException {
        studentRepository.update(student);
    }

//    public Student get(String email) throws SQLException {
//        return studentRepository.get(email);
//    }
}
