package person.birch.thymeleafplayjoy.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.domain.Page;
import person.birch.thymeleafplayjoy.repository.BookRepository;

import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final BookRepository bookRepository;

    public Bootstrap(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBooks();
    }

    private void loadBooks() {
        List<Page> pages = List.of(Page.builder().build(), Page.builder().build(), Page.builder().build());

        Book abc = Book.builder().title("ABC").author("People").isbn("1sdasw").pages(pages).build();
        Book law = Book.builder().title("Law").author("Suits").isbn("asddws").pages(null).build();

        bookRepository.saveAll(List.of(abc, law));

        System.out.println("Books available: " + bookRepository.size());
    }
}
