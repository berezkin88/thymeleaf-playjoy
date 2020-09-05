package person.birch.thymeleafplayjoy.repository;

import person.birch.thymeleafplayjoy.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    // todo optional or not?
    Book save(Book book);
    boolean saveAll(List<Book> bookList);
    List<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    Book findByTitle(String title);
    int size();
}
