package person.birch.thymeleafplayjoy.service;

import org.springframework.stereotype.Service;
import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.domain.Page;
import person.birch.thymeleafplayjoy.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void saveAll(List<Book> books) {
        if (!bookRepository.saveAll(books)) {
            throw new RuntimeException("Failed to save books");
        }
    }

    @Override
    public void addPage(Page page, Book book) {
        bookRepository
            .findByIsbn(book.getIsbn())
            .ifPresentOrElse(bk -> bk.getPages().add(page), () -> {
                book.getPages().add(page);
                bookRepository.save(book);
            });
    }

    @Override
    public Book findBook(Book book) {
        return bookRepository.findByIsbn(book.getIsbn()).orElseThrow();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
