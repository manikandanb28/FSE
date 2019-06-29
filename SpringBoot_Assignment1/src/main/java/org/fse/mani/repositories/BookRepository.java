package org.fse.mani.repositories;

import org.fse.mani.entities.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends Repository<Book,Long> {
    List<Book> findAll();
    List<Book> findByTitleIgnoreCaseContaining(String title);
    Book findById(Long bookId);
    Book save(Book book);
    void deleteByBookId(Long bookId);
}
