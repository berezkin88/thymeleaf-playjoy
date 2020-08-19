package person.birch.thymeleafplayjoy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private String isbn = UUID.randomUUID().toString();
    private String title;
    private String author;
    private List<Page> pages = new ArrayList<>();
}
