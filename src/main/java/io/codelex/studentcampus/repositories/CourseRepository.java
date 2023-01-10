package io.codelex.studentcampus.repositories;

import io.codelex.studentcampus.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
