package org.schoolmanager.schoolmanager.Service.Implementation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.schoolmanager.schoolmanager.DTOs.RequestDTOs.StudentRequestDTO;
import org.schoolmanager.schoolmanager.DTOs.ResponseDTOs.StudentResponseDTO;
import org.schoolmanager.schoolmanager.Mapper.StudentMapper;
import org.schoolmanager.schoolmanager.Model.Student;
import org.schoolmanager.schoolmanager.Model.StudentIdSequence;
import org.schoolmanager.schoolmanager.Repository.StudentIdSequenceRepo;
import org.schoolmanager.schoolmanager.Repository.StudentRepo;
import org.schoolmanager.schoolmanager.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;
    private final StudentMapper mapper;
    private final StudentIdSequenceRepo sequenceRepo;

    @Override
    public List<StudentResponseDTO> getAllStudents(){
        List <Student> allStudents = repo.findAll();
        return mapper.toDTO(allStudents);
    }

    @Override
    public void createStudent(StudentRequestDTO studentRequestDTO) {
        Student newStudent = mapper.toEntity(studentRequestDTO);

        String studentId = generateStudentId(newStudent.getEntryYear());
        newStudent.setStudentId(studentId);
        repo.save(newStudent);
    }

    @Override
    public StudentResponseDTO getStudentById(String studentId) {
        Student student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return mapper.toDTO(student);
    }

    @Override
    public void deleteStudentById(String studentId) {
        Student student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        repo.delete(student);
    }

    @Override
    @Transactional
    public void updateStudent(String studentId, StudentRequestDTO studentRequestDTO) {
        Student student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        mapper.updateStudentFromDTO(studentRequestDTO, student);

        // Protect fields user should NOT update
        // (just override MapStruct’s changes)
        student.setEntryYear(student.getEntryYear());
        student.setCurrentYear(student.getCurrentYear());
        student.setStudentId(student.getStudentId());
    }


    @Transactional
    public String generateStudentId(Integer entryYear) {
        int yearPart = entryYear % 100; // 2025 → 25

        StudentIdSequence sequence = sequenceRepo
                .findById(yearPart)
                .orElseGet(() -> new StudentIdSequence(yearPart, 0));

        int nextNumber = sequence.getLastNumber() + 1;
        sequence.setLastNumber(nextNumber);
        sequenceRepo.save(sequence);

        String numberPart = String.format("%04d", nextNumber); // pads with zeros

        return yearPart + numberPart;
    }


}
