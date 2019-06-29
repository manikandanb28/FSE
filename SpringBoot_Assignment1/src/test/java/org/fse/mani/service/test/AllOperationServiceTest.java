package org.fse.mani.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fse.mani.config.JpaConfig;
import org.fse.mani.dao.ReadWriteDaoImpl;
import org.fse.mani.entities.Book;
import org.fse.mani.entities.Subject;
import org.fse.mani.service.ReadWriteOperationImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.format.annotation.DateTimeFormat;

@RunWith(MockitoJUnitRunner.class)
public class AllOperationServiceTest {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate publishDate;

	@InjectMocks
	ReadWriteOperationImpl service;

	@InjectMocks
	JpaConfig config;

	@Mock
	ReadWriteDaoImpl dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addSubject() {

		Subject subject = new Subject();
		subject.setSubjectId(1);
		subject.setSubtitle("Kafka");
		subject.setDurationInHours(100);

		service.addSubject(subject);
		verify(dao, times(1)).saveSubject(subject);
	}

	@Test
	public void addBook() {

		Book book = new Book();
		book.setBookId(1);
		book.setTitle("KafkaManager");
		book.setPrice(1000);
		book.setPublishDate(publishDate);
		book.setVolume(2);

		Subject subject = new Subject();
		subject.setSubjectId(1);
		subject.setSubtitle("Kafka");
		subject.setDurationInHours(100);

		service.addBook(book, subject.getSubjectId());
		verify(dao, times(1)).saveBook(book, subject);
	}

	@Test
	public void searchSubjects() {

		List<Subject> list = new ArrayList<Subject>();

		Subject sub1 = new Subject("headFirstJava", 100);
		Subject sub2 = new Subject("C#", 150);
		Subject sub3 = new Subject("MySQL", 75);

		list.add(sub1);
		list.add(sub2);
		list.add(sub3);

		when(dao.findSubjectsByTitle("C#")).thenReturn(list);

		List<Subject> subjectList = service.searchSubjects("C#");
		assertNotNull(subjectList);
		for (Subject subject : subjectList) {
			if (subject.getSubtitle().equalsIgnoreCase("C#")) {
				assertNotNull("C#", subject.getSubtitle());
			}

		}

	}

	@Test
	public void deleteSubject() {

		List<Subject> list = new ArrayList<Subject>();

		Subject sub1 = new Subject(10001);
		Subject sub2 = new Subject(2);
		Subject sub3 = new Subject(3);

		list.add(sub1);
		list.add(sub2);
		list.add(sub3);

		Long id = (long) 10001;

		service.deleteSubject("10001");

		verify(dao, times(1)).removeSubject(id);

	}

	@Test
	public void deleteBook() {

		List<Book> list = new ArrayList<Book>();
		Book bookOne = new Book(1, "Java", 1500, 1, publishDate);
		Book bookTwo = new Book(2, ".Net", 1000, 2, publishDate);
		Book bookThree = new Book(3, "SQL", 500, 3, publishDate);

		list.add(bookOne);
		list.add(bookTwo);
		list.add(bookThree);

		Long id = (long) 1;

		service.deleteBook("1");

		verify(dao, times(1)).removeBook(id);

	}

	@Test
	public void searchBooks() {
		List<Book> list = new ArrayList<Book>();

		Book bookOne = new Book(1, "Java", 1500, 1, publishDate);
		Book bookTwo = new Book(2, ".Net", 1000, 2, publishDate);
		Book bookThree = new Book(3, "SQL", 500, 3, publishDate);

		list.add(bookOne);
		list.add(bookTwo);
		list.add(bookThree);

		when(dao.findBooksByTitle("java")).thenReturn(list);
		List<Book> booklist = service.searchBooks("java");

		for (Book book : booklist) {
			if (book.getTitle().equalsIgnoreCase("java")) {
				assertNotNull("java", book.getTitle());
			}

		}
		assertNotNull(booklist);

	}

	@Test
	public void findAllBooks() {
		List<Book> list = new ArrayList<Book>();

		Book bookOne = new Book(1, "Java", 1500, 1, publishDate);
		Book bookTwo = new Book(2, ".Net", 1000, 2, publishDate);
		Book bookThree = new Book(3, "SQL", 500, 3, publishDate);

		list.add(bookOne);
		list.add(bookTwo);
		list.add(bookThree);

		when(dao.findAllBooks()).thenReturn(list);
		List<Book> booklist = service.findAllBooks();
		assertEquals(3, booklist.size());
		assertNotNull(booklist);

	}

	@Test
	public void findAllSubjects() {
		List<Subject> list = new ArrayList<Subject>();

		Subject sub1 = new Subject("headFirstJava", 100);
		Subject sub2 = new Subject("C#", 150);
		Subject sub3 = new Subject("MySQL", 75);

		list.add(sub1);
		list.add(sub2);
		list.add(sub3);

		when(dao.findAllSubjects()).thenReturn(list);
		List<Subject> subjectList = service.findAllSubjects();
		assertEquals(3, subjectList.size());
		assertNotNull(subjectList);

	}

}
