package week_3.Spring_Core_Maven.LibraryManagementSystem;

import week_3.Spring_Core_Maven.LibraryManagementSystem.library.service.BookService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class LibraryManagementSystemApplication {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookService bookService = context.getBean("bookService", BookService.class);
			System.out.println("Enter book name:");
			bookService.addBook(scan.next());

			System.out.println("Enter book name:");
			bookService.addBook(scan.next());
		}
}
