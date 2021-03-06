package person.birch.thymeleafplayjoy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import person.birch.thymeleafplayjoy.config.BookPropertyEditor;
import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.domain.Shelf;
import person.birch.thymeleafplayjoy.repository.BookRepository;
import person.birch.thymeleafplayjoy.repository.ShelfRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ShelfController implements ShelfApi {

    private final ShelfRepository shelfRepository;
    private final BookRepository bookRepository;

    public ShelfController(ShelfRepository shelfRepository, BookRepository bookRepository) {
        this.shelfRepository = shelfRepository;
        this.bookRepository = bookRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Book.class, new BookPropertyEditor(bookRepository));
    }

    @Override
    public String getShelves(Model model) {
        model.addAttribute("shelves", shelfRepository.findAll());

        return "shelves";
    }

    @Override
    public String addShelf(Model model) {
        List<Book> newBooks = new ArrayList<>();
        model.addAttribute("shelf", Shelf.builder().id(new Random().nextInt(100)).books(newBooks).build());
//        model.addAttribute("books", bookRepository.findAll());

        return "shelfform";
    }

    @Override
    public String saveShelf(@ModelAttribute("shelf") Shelf shelf) {
        shelfRepository.save(shelf);

        return "redirect:/shelves";
    }

    @ModelAttribute("booksList")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
