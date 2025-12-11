package org.schoolmanager.schoolmanager.Controller;

import lombok.RequiredArgsConstructor;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentRequestDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;
import org.schoolmanager.schoolmanager.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents()
    {
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Void> createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        service.createStudent(studentRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable("studentId") String studentId){
        return new ResponseEntity<>(service.getStudentById(studentId),HttpStatus.FOUND);
    }

    @DeleteMapping("/students")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") String studentId){
        service.deleteStudentById(studentId);
        return new  ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable("studentId") String studentId, @RequestBody StudentRequestDTO studentRequestDTO){
        service.updateStudent(studentId, studentRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
