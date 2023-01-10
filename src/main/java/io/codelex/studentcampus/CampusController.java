package io.codelex.studentcampus;

import io.codelex.studentcampus.domain.Course;
import io.codelex.studentcampus.domain.Student;
import io.codelex.studentcampus.domain.Tutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CampusController {

    private CampusService campusService;

    @Autowired
    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudents(@Valid @RequestBody Student student) {
        return campusService.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        return campusService.getStudent(id);
    }

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@Valid @RequestBody Course course) {
        return campusService.addCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable long id) {
        return campusService.getCourse(id);
    }

    @PostMapping("/tutor")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor addTutor(@Valid @RequestBody Tutor tutor) {
        return campusService.addTutor(tutor);
    }

    @GetMapping("/tutor/{id}")
    public Tutor getTutor(@PathVariable long id) {
        return campusService.getTutor(id);
    }


}
