package week_3.Spring_Core_Maven.LibraryManagementSystem.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week_3.Spring_Core_Maven.LibraryManagementSystem.library.repository.BookRepository;

//@Service
public class BookService {
//    @Autowired
    private BookRepository bookRepository;

    private String additionalInfo;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);
        System.out.println("BookService: addBook() called");
        System.out.println(additionalInfo);
    }
}