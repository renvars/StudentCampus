package io.codelex.studentcampus.repositories;

import io.codelex.studentcampus.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
