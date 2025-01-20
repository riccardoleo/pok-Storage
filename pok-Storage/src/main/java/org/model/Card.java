package org.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "album")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Card {

    @Id
    private int id;
    private String name;
    private String generation;
    private String cardCode;

    public List findAll(){
        List list = new ArrayList();
        list.add(this);
        return list;
    }
}
