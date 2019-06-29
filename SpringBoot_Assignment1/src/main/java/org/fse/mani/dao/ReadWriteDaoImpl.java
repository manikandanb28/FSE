package org.fse.mani.dao;


import org.fse.mani.entities.Book;
import org.fse.mani.entities.Subject;
import org.fse.mani.repositories.BookRepository;
import org.fse.mani.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ReadWriteDaoImpl implements ReadWriteDao {

    private SubjectRepository subjectRepositories;

    private BookRepository bookRepositories;

    @Autowired
    public ReadWriteDaoImpl(SubjectRepository subjectRepositories, BookRepository bookRepositories) {
        this.subjectRepositories = subjectRepositories;
        this.bookRepositories = bookRepositories;
    }

    public List<Book> findAllBooks(){
        return bookRepositories.findAll();
    }

    public List<Subject> findAllSubjects(){
        return subjectRepositories.findAll();
    }
    public List<Book> findBooksByTitle(String bookTitle) {

        List<Book> books = null;

        try {
            books = bookRepositories.findByTitleIgnoreCaseContaining(bookTitle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (books == null) {
            books = new ArrayList<>();
        }
        return books;
    }

    public List<Subject> findSubjectsByTitle(String SubjectTitle) {

        List<Subject> subjects = null;

        try {
            subjects = subjectRepositories.findBySubtitleIgnoreCaseContaining(SubjectTitle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        return subjects;
    }

    @Override
    public Subject findSubjectById(Long subjectId) {

        Subject subject = null;

        try {

            subject = subjectRepositories.findById(subjectId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return subject;
    }

    @Override
    public Book findBookById(Long bookId) {
        Book book = null;

        try {
            book = bookRepositories.findById(bookId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }

    public void saveSubject(Subject subject) {
        subjectRepositories.save(subject);
    }

    public void saveBook(Book book, Subject subject) {

        book.setSubject(subject);
        bookRepositories.save(book);

    }

    public void removeBook(Long bookId) {
        bookRepositories.deleteByBookId(bookId);

    }

    public void removeSubject(Long subjectId) {

            subjectRepositories.deleteBySubjectId(subjectId);

    }
}
