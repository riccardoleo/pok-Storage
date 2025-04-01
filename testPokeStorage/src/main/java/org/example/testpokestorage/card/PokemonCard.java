package org.example.testpokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonCard extends Card {


    public String category;
    public int[] dexId;
    public int hp;
    public String[] types;
    public String evolveForm;
    public String description;
    public String level;
    public String stage;
    public String suffix;
    public String[] item; //name, effect

//    public static class Item{
//        public String name;
//        public String effect;
//
//    }
//
//    public Item items;
}
