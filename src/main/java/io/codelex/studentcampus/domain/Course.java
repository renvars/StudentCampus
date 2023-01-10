package io.codelex.studentcampus.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.ClientEndpoint;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    private long courseId;

    @NotBlank
    private String courseName;
    @NotBlank
    private String tutor;

    @ManyToMany(mappedBy = "coursesAttending", cascade = CascadeType.ALL)
    private Set<Student> studentsAttending;

    public Course(String courseName, String tutor) {
        this.courseName = courseName;
        this.tutor = tutor;
    }

    public Course() {

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public Set<Student> getStudentsAttending() {
        return studentsAttending;
    }

    public void setStudentsAttending(Set<Student> studentsAttending) {
        this.studentsAttending = studentsAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseName.equalsIgnoreCase(course.courseName)
                && tutor.equalsIgnoreCase(course.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, tutor);
    }
}
