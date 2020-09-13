package person.birch.thymeleafplayjoy.config;

import lombok.SneakyThrows;
import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.repository.BookRepository;

import java.beans.PropertyEditorSupport;

public class BookPropertyEditor extends PropertyEditorSupport {

    private final BookRepository bookRepository;

    // should Editor know about Repository?
    public BookPropertyEditor(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @SneakyThrows
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Book book = bookRepository.findByIsbn(text).orElseThrow();
        super.setValue(book);
    }
}
