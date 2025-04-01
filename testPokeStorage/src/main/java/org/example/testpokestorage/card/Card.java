package org.example.testpokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Card {

    public String id;
    public String localId;
    public String name;
    public String image;
    //public String category;
    public String illustrator;
    public String rarity;
    public boolean[] variant; // normal, reverse, holo firstedition

//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Variant{
//        public Boolean normal;
//        public Boolean reverse;
//        public Boolean holo;
//        public Boolean firstEdition;
//    }

//    public Variant variant;

//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class SetBrief {
//
//        public String id;
//        public String name;
//        public String logo;
//        public String Symbol;
//
//
//        @Data
//        @AllArgsConstructor
//        @NoArgsConstructor
//        public static class CardCount {
//
//            public int total;
//            public int official;
//
//        }
//    }

//    public SetBrief setBrief;
//    public SetBrief.CardCount cardCount;

}
