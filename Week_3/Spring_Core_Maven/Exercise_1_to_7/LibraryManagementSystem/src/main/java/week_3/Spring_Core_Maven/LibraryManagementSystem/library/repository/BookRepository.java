package week_3.Spring_Core_Maven.LibraryManagementSystem.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Saving book "+bookName);
    }
}