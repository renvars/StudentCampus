package io.codelex.studentcampus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private long studentId;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String courseName;

    @ManyToMany
    @JoinTable(
            name = "course_attending",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_name"))
    private Set<Course> coursesAttending;

    public Student(String name, String surname, String courseName, Set<Course> coursesAttending) {
        this.name = name;
        this.surname = surname;
        this.courseName = courseName;
        this.coursesAttending = coursesAttending;
    }

    public Student() {

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Set<Course> getCoursesAttending() {
        return coursesAttending;
    }

    public void setCoursesAttending(Set<Course> coursesAttending) {
        this.coursesAttending = coursesAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equalsIgnoreCase(student.name)
                && surname.equalsIgnoreCase(student.surname)
                && courseName.equalsIgnoreCase(student.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, courseName);
    }
}
