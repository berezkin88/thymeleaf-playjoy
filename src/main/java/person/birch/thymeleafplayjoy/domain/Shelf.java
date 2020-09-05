package person.birch.thymeleafplayjoy.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shelf {

    private int id;
    private List<Book> books = new ArrayList<>();
}
