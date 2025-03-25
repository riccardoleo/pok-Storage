package org.example.testpokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonCard extends CommonFields {
    public String category;
    public ArrayList dexId;
    public int hp;
    public ArrayList types;
    public String evolveForm;
    public String description;
    public String level;
    public String stage;
    public String suffix;
    public class Item{
        public String name;
        public String effect;
    }
    public Item items;
}
