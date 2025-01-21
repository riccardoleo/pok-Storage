package org.example;

import com.mongodb.lang.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    private int id;

    private String name;
    private String cardCode;
    private int quantity;
    private int year;
    private String language;

    @Nullable
    private String rarity;
    @Nullable
    private int pokedexNumber;
    @Nullable
    private float price;
    @Nullable
    private String generation;
}
