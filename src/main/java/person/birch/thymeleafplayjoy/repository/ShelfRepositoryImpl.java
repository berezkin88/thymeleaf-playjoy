package person.birch.thymeleafplayjoy.repository;

import org.springframework.stereotype.Repository;
import person.birch.thymeleafplayjoy.domain.Book;
import person.birch.thymeleafplayjoy.domain.Shelf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ShelfRepositoryImpl implements ShelfRepository {

    private final BookRepository bookRepository;

    public ShelfRepositoryImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final Set<Shelf> shelves = new HashSet<>();

    @Override
    public Shelf save(Shelf shelf) {
        if (shelves.add(shelf)) {
            addBooks(shelf.getBooks(), shelf);

            return shelf;
        }
        throw new RuntimeException("Failed to add shelf");
    }

    private void addBooks(List<Book> books, Shelf shelf) {
        List<Book> booksForReplace = books.stream()
            .map(book -> bookRepository.findByIsbn(book.getIsbn()).orElseThrow())
            .collect(Collectors.toList());
        shelf.setBooks(booksForReplace);
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
