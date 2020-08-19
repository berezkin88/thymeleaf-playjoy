package person.birch.thymeleafplayjoy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
public class Page {

    private int number = new Random().nextInt(100);
    private String text;
    private Book book;
}
