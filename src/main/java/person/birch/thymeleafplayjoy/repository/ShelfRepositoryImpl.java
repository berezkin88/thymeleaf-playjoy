package person.birch.thymeleafplayjoy.repository;

import org.springframework.stereotype.Repository;
import person.birch.thymeleafplayjoy.domain.Shelf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ShelfRepositoryImpl implements ShelfRepository {

    private final Set<Shelf> shelves = new HashSet<>();

    @Override
    public Shelf save(Shelf shelf) {
        if (shelves.add(shelf)) {
            return shelf;
        }
        throw new RuntimeException("Failed to add shelf");
    }

    @Override
    public boolean saveAll(List<Shelf> shelfList) {
        return shelves.addAll(shelfList);
    }

    @Override
    public List<Shelf> findAll() {
        return new ArrayList<>(shelves);
    }

    @Override
    public Shelf findById(int id) {
        return shelves
            .stream()
            .filter(shelf -> shelf.getId() == id)
            .findFirst()
            .orElseThrow();
    }
}
