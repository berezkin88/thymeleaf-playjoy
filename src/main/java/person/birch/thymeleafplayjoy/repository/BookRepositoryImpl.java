package person.birch.thymeleafplayjoy.repository;

import org.springframework.stereotype.Repository;
import person.birch.thymeleafplayjoy.domain.Book;

import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final Set<Book> books = new HashSet<>();

    @Override
    public Book save(Book book) {
        if (books.add(book)) {
            return book;
        }
        throw new RuntimeException("Failed to save a book");
    }

    @Override
    public boolean saveAll(List<Book> bookList) {
        return books.addAll(bookList);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return books
            .stream()
            .filter(book -> book.getIsbn().equals(isbn))
            .findFirst();
    }

    @Override
    public Book findByTitle(String title) {
        return books
            .stream()
            .filter(book -> book.getTitle().equals(title))
            .findFirst()
            .orElseThrow();
    }

    @Override
    public int size() {
        return books.size();
    }
}
