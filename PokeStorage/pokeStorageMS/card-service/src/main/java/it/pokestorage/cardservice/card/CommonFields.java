package it.pokestorage.cardservice.card;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class CommonFields {

    public String id;
    public String localId;
    public String name;
    public String image;
    public String category;
    public String illustrator;
    public String rarity;
    public int[] albumId;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Variant{
        public Boolean normal;
        public Boolean reverse;
        public Boolean holo;
        public Boolean firstEdition;
    }

    public Variant variant;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SetBrief {

        public String id;
        public String name;
        public String logo;
        public String Symbol;


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class CardCount {

            public int total;
            public int official;

        }
    }

    public SetBrief setBrief;
    public SetBrief.CardCount cardCount;

}
