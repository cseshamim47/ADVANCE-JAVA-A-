package dev.rest;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/users")
    public String createStudent(@RequestBody Student student) throws SQLException {
       studentService.create(student);
        return "Registration Successful";
    }



    @GetMapping("/users")
    public List<Student> getAllStudents() throws SQLException {
        return studentService.getAllStudents();
    }

    @GetMapping("/users/{id}")
    public Student findStudent(@PathVariable("id") Integer id) throws SQLException {
        return studentService.getStudentById(id);
    }

    @PutMapping(value = "/users")
    public String editStudentForm(@RequestBody Student student) throws SQLException {
        studentService.updateStudent(student);
        return "Updated";
    }

    @DeleteMapping("/users/{id}")
    public String deleteStudent(@PathVariable("id") int id) throws SQLException {
        studentService.deleteStudent(id);
        return "Deleted";
    }

    @GetMapping("users/count")
    public ResponseEntity<Integer> getStudentCount() {
        int count = studentService.getCount();
        return ResponseEntity.ok(count);
    }


}
