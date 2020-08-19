package person.birch.thymeleafplayjoy.repository;

import person.birch.thymeleafplayjoy.domain.Shelf;

import java.util.List;

public interface ShelfRepository {

    Shelf save(Shelf shelf);
    boolean saveAll(List<Shelf> shelfList);
    List<Shelf> findAll();
    Shelf findById(int id);
}
