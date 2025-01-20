package org.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Card {

    @Id
    private String id;
    private String name;
    private String generation;
    private String cardCode;

}
