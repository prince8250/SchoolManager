package org.schoolmanager.schoolmanager.Repository;

import org.schoolmanager.schoolmanager.Model.StudentIdSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdSequenceRepo extends JpaRepository<StudentIdSequence,Integer> {
}
