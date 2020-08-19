package person.birch.thymeleafplayjoy.service;

import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.domain.Page;

import java.util.List;

public interface BookService {

    Book save(Book book);
    void saveAll(List<Book> books);
    void addPage(Page page, Book book);
    Book findBook(Book book);
    List<Book> findAllBooks();
}
