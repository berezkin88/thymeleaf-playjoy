package person.birch.thymeleafplayjoy.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import person.birch.thymeleafplayjoy.domain.Shelf;

@RequestMapping(ShelfApi.BASE_URL)
public interface ShelfApi {

    String BASE_URL = "/shelves";

    @GetMapping
    String getShelves(Model model);

    @GetMapping("/new")
    String addShelf(Model model);

    @PostMapping("/new")
    String saveShelf(Shelf shelf);
}
