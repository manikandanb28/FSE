package org.fse.mani.repositories;

import org.fse.mani.entities.Subject;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SubjectRepository extends Repository<Subject, Long> {
    List<Subject> findAll();
    List<Subject> findBySubtitleIgnoreCaseContaining(String title);
    Subject findById(Long subjectId);
    Subject save(Subject subject);
    void deleteBySubjectId(Long subjectId);
}
