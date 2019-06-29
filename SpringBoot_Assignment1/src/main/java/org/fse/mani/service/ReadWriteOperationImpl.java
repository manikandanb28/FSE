package org.fse.mani.service;

import org.fse.mani.dao.ReadWriteDao;
import org.fse.mani.entities.Book;
import org.fse.mani.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadWriteOperationImpl implements ReadWriteOperation{

    private ReadWriteDao readWriteDao;

    @Autowired
    public ReadWriteOperationImpl(ReadWriteDao readWriteDao) {
        this.readWriteDao = readWriteDao;
    }

    public void addSubject(Subject subject) {
        readWriteDao.saveSubject(subject);
    }

    public void addBook(Book book, long subjectId) {
        readWriteDao.saveBook(book, new Subject(subjectId));
    }

    public void deleteSubject(String subjectId) { readWriteDao.removeSubject(Long.valueOf(subjectId));

    }

    public void deleteBook(String bookId) {

        readWriteDao.removeBook(Long.valueOf(bookId));

    }

    public List<Book> searchBooks(String bookTitle) {
        List<Book> books = readWriteDao.findBooksByTitle(bookTitle);

        if (books == null) {
            books = new ArrayList<>();
        }

        return books;
    }

    public List<Subject> searchSubjects(String SubjectTitle) {
        List<Subject> resultSubjectList = readWriteDao.findSubjectsByTitle(SubjectTitle);

        if (resultSubjectList == null) {
            resultSubjectList = new ArrayList<>();
        }

        return resultSubjectList;
    }

    @Override
    public List<Book> findAllBooks() {
        return readWriteDao.findAllBooks();
    }

    @Override
    public List<Subject> findAllSubjects() {
        return readWriteDao.findAllSubjects();
    }

    private long getUniqueSubjectId(List<Subject> searchList) {

        if (searchList == null || searchList.isEmpty()) {
            return 1;
        } else {
            Subject subject = searchList.get(searchList.size() - 1);

            return subject.getSubjectId() + 1;
        }
    }


}
