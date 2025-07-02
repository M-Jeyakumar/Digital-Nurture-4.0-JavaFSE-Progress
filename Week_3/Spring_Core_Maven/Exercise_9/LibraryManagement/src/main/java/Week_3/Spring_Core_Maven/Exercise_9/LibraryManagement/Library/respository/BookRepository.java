package Week_3.Spring_Core_Maven.Exercise_9.LibraryManagement.Library.respository;

import Week_3.Spring_Core_Maven.Exercise_9.LibraryManagement.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
}
