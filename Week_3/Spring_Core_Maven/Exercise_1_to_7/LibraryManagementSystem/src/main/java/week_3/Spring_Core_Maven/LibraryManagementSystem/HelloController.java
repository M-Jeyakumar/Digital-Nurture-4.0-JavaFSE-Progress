package week_3.Spring_Core_Maven.LibraryManagementSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "👋 Hello from Spring Boot! JKJKKKK";
    }
}