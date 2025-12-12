package org.schoolmanager.schoolmanager.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentCreateDTO;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentUpdateDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;
import org.schoolmanager.schoolmanager.Model.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentCreateDTO studentCreateDTO);

    Student toEntity(StudentUpdateDTO studentUpdateDTO);

    StudentResponseDTO toDTO(Student student);

    List<StudentResponseDTO> toDTO(List<Student> students);

    void updateStudentFromDTO(StudentUpdateDTO studentUpdateDTO, @MappingTarget Student student);
}
