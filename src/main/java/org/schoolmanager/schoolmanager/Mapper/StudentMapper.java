package org.schoolmanager.schoolmanager.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentRequestDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;
import org.schoolmanager.schoolmanager.Model.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequestDTO studentDTO);

    StudentResponseDTO toDTO(Student student);

    @Mapping(source = "age", target = "age")
    List<StudentResponseDTO> toDTO(List<Student> students);

    void updateStudentFromDTO(StudentRequestDTO studentRequestDTO, @MappingTarget Student student);
}
