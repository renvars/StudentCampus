package io.codelex.studentcampus;

import io.codelex.studentcampus.domain.Course;
import io.codelex.studentcampus.domain.Student;
import io.codelex.studentcampus.domain.Tutor;
import io.codelex.studentcampus.repositories.CourseRepository;
import io.codelex.studentcampus.repositories.StudentRepository;
import io.codelex.studentcampus.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class CampusService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TutorRepository tutorRepository;

    @Autowired
    public CampusService(StudentRepository studentRepository,
                         CourseRepository courseRepository, TutorRepository tutorRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.tutorRepository = tutorRepository;
    }

    public Student addStudent(Student student) {
        if (studentRepository.findAll().stream()
                .anyMatch(s -> s.equals(student))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        } else {
            studentRepository.save(student);
            return student;
        }
    }

    public Student getStudent(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        System.out.println(student.get().getCoursesAttending().toString());
        return student.get();
    }

    public Course addCourse(Course course) {
        if (courseRepository.findAll().stream()
                .anyMatch(s -> s.equals(course))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        } else {
            courseRepository.save(course);
            return course;
        }
    }

    public Course getCourse(long id) {
        Optional<Course> student = courseRepository.findById(id);
        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student.get();
    }

    public Tutor addTutor(Tutor tutor) {
        if (tutorRepository.findAll().stream()
                .anyMatch(s -> s.equals(tutor))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        } else {
            tutorRepository.save(tutor);
            return tutor;
        }

    }

    public Tutor getTutor(long id) {
        Optional<Tutor> tutor = tutorRepository.findById(id);
        if (tutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return tutor.get();
    }


}
