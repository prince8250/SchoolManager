package org.schoolmanager.schoolmanager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class StudentIdSequence {

    @Id
    private Integer entryYear ; // e.g. 25, 26, 27

    private Integer lastNumber; // e.g. 12, 5, etc.

    public StudentIdSequence(Integer entryYear, Integer lastNumber) {
        this.entryYear = entryYear;
        this.lastNumber = lastNumber;
    }

    public StudentIdSequence() {
    }

    public Integer getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Integer entryYear) {
        this.entryYear = entryYear;
    }

    public Integer getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(Integer lastNumber) {
        this.lastNumber = lastNumber;
    }
}
