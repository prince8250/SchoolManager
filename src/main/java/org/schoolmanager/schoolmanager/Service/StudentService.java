package org.schoolmanager.schoolmanager.Service;

import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentRequestDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();


    void createStudent(StudentRequestDTO studentRequestDTO);

    StudentResponseDTO getStudentById(String studentId);

    void deleteStudentById(String studentId);

    void updateStudent(String studentId, StudentRequestDTO studentRequestDTO);
}
