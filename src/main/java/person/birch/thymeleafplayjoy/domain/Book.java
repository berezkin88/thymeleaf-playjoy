package person.birch.thymeleafplayjoy.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String isbn = UUID.randomUUID().toString();
    private String title;
    private String author;
    private List<Page> pages = new ArrayList<>();
}
