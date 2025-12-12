package org.schoolmanager.schoolmanager.Service;

import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentCreateDTO;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentUpdateDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();


    void createStudent(StudentCreateDTO studentCreateDTO);

    StudentResponseDTO getStudentById(String studentId);

    void deleteStudentById(String studentId);

    void updateStudent(String studentId, StudentUpdateDTO studentUpdateDTO);
}
