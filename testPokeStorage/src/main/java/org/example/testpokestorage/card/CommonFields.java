package org.example.testpokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    public String illustratior;
    public String rarity;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Variant{
        public Boolean normal;
        public Boolean reverse;
        public Boolean holo;
        public Boolean firstedition;
    }
    public Variant variant;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SetBrief{
        public String id;
        public String name;
        public String logo;
        public String Symbol;
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class CardCount{
            public int total;
            public int official;
        }
    }
    public SetBrief setBrief;
    public SetBrief.CardCount cardCount;
}
