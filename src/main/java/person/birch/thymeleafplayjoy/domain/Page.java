package person.birch.thymeleafplayjoy.domain;

import lombok.*;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page {

    private int number = new Random().nextInt(100);
    private String text;
    private Book book;
}
