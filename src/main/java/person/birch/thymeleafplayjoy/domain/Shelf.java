package person.birch.thymeleafplayjoy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Shelf {

    private int id;
    private List<Book> books = new ArrayList<>();
}
