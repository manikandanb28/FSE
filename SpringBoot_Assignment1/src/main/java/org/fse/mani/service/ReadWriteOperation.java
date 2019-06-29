package org.fse.mani.service;

import org.fse.mani.entities.Book;
import org.fse.mani.entities.Subject;

import java.util.List;

public interface ReadWriteOperation {
    void addSubject(Subject subject);

    void addBook(Book book, long subjectId);

    void deleteSubject(String subjectIdOrTitle);

    void deleteBook(String bookIdOrTitle);

    List<Book> findAllBooks();

    List<Subject> findAllSubjects();

    List<Book> searchBooks(String bookTitle);

    List<Subject> searchSubjects(String SubjectTitle);
}
