package io.codelex.studentcampus.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "tutors")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tutor_id")
    private long tutorId;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;

    public Tutor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Tutor() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return name.equalsIgnoreCase(tutor.name)
                && surname.equalsIgnoreCase(tutor.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
